package com.ve.marketingcenter.core.service.action.coupon;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponStatus;
import com.ve.marketingcenter.common.domain.dto.coupon.OrderActivityDTO;
import com.ve.marketingcenter.core.domain.ActivityDO;
import com.ve.marketingcenter.core.domain.coupon.GrantedCoupon;
import com.ve.marketingcenter.core.domain.coupon.ReceivedCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.coupon.ActivityCouponManager;
import com.ve.marketingcenter.core.manager.coupon.GrantedCouponManager;
import com.ve.marketingcenter.core.manager.coupon.ReceivedCouponManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.TransAction;
import com.ve.marketingcenter.core.util.ResponseUtil;

@Service
public class RelateOrderActivity extends TransAction {
	@Resource
	GrantedCouponManager grantedCouponManager;
	@Resource
	ReceivedCouponManager receivedCouponManager;
	@Resource
	ActivityCouponManager activityCouponManager;

	/**
	 * 关联营销活动接口
	 */
	@Override
	public MarketingResponse doTransaction(RequestContext context)
			throws MarketingException {
		// 获取参数
		OrderActivityDTO orderActivityDTO = (OrderActivityDTO) context
				.getRequest().getParam("orderActivityDTO");
		if (orderActivityDTO == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"orderActivityDTO is null");
		}
		if (orderActivityDTO.getOrderId() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"orderId is null");
		}
		if (orderActivityDTO.getUserId() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"userId is null");
		}
		if (orderActivityDTO.getActivityIdList() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"activityIdList is null");
		}
		// 循环每个活动和订单建立关联
		for (Long activityId : orderActivityDTO.getActivityIdList()) {
			ActivityDO activityDO = activityCouponManager
					.getActivity(activityId);
			if (activityDO == null) {
				throw new MarketingException(
						ReturnCodeEnum.PARAMETER_NULL.getCode(), "activityId:"
								+ activityId + " not exist");
			}
			// 先存储营销活动享用信息
			ReceivedCoupon receivedCoupon = new ReceivedCoupon();
			receivedCoupon.setCouponId(0l);
			receivedCoupon.setActivityId(activityId);
			receivedCoupon.setEndTime(activityDO.getEndTime());
			receivedCoupon.setGrantorUserId(activityDO.getCreatorUserId());
			receivedCoupon.setOrderId(orderActivityDTO.getOrderId());
			receivedCoupon.setReceiverUserId(orderActivityDTO.getUserId());
			receivedCoupon.setStartTime(activityDO.getStartTime());
			receivedCoupon.setStatus(CouponStatus.FREEZE.getValue());
			receivedCouponManager.addReceivedCoupon(receivedCoupon);
			// 在存储营销活动提供信息
			GrantedCoupon grantedCoupon = new GrantedCoupon();
			grantedCoupon.setCouponId(0l);
			grantedCoupon.setActivityId(activityId);
			grantedCoupon.setEndTime(activityDO.getEndTime());
			grantedCoupon.setGrantorUserId(activityDO.getCreatorUserId());
			grantedCoupon.setOrderId(orderActivityDTO.getOrderId());
			grantedCoupon.setReceiverUserId(orderActivityDTO.getUserId());
			grantedCoupon.setStartTime(activityDO.getStartTime());
			grantedCoupon.setStatus(CouponStatus.FREEZE.getValue());
			grantedCouponManager.addGrantedCoupon(grantedCoupon);
		}
		// 如果使用了优惠券，循环设为冻结状态
		if (orderActivityDTO.getCouponIdList() != null) {
			for (Long couponId : orderActivityDTO.getCouponIdList()) {
				// 先把已被领用的营销活动券冻结
				ReceivedCoupon receivedCoupon = new ReceivedCoupon();
				receivedCoupon.setCouponId(couponId);
				receivedCoupon.setOrderId(orderActivityDTO.getOrderId());
				// receivedCoupon.setReceiverUserId(orderActivityDTO.getUserId());//分表后在加
				receivedCoupon.setStatus(CouponStatus.FREEZE.getValue());
				int row = receivedCouponManager.freezeCoupon(receivedCoupon);
				if (row == 0) {
					throw new MarketingException(
							ReturnCodeEnum.PARAMETER_ERROR.getCode(), "couponId:"
									+ couponId + " no receivedcoupon to freeze");
				}
				// 在把已被发放的营销活动券冻结
				GrantedCoupon grantedCoupon = new GrantedCoupon();
				grantedCoupon.setCouponId(couponId);
				// grantedCoupon.setGrantorUserId(1l);//分表后在加
				grantedCoupon.setOrderId(orderActivityDTO.getOrderId());
				grantedCoupon.setStatus(CouponStatus.FREEZE.getValue());
				row = grantedCouponManager.freezeCoupon(grantedCoupon);
				if (row == 0) {
					throw new MarketingException(
							ReturnCodeEnum.PARAMETER_ERROR.getCode(), "couponId:"
									+ couponId + " no grantedcoupon to freeze");
				}
			}
		}

		// 返回response对象
		return ResponseUtil.getResponse(true);
	}

	@Override
	public String getName() {
		return ActionEnum.RELATE_ORDER_ACTIVITY.getActionName();
	}
}
