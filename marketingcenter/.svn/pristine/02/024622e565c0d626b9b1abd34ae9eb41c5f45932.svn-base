package com.ve.marketingcenter.core.service.action.coupon;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponStatus;
import com.ve.marketingcenter.core.domain.ActivityDO;
import com.ve.marketingcenter.core.domain.coupon.ActivityCoupon;
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
public class ActivateCoupon extends TransAction {
	@Resource
	ActivityCouponManager activityCouponManager;
	@Resource
	GrantedCouponManager grantedCouponManager;
	@Resource
	ReceivedCouponManager receivedCouponManager;

	/**
	 * 激活营销活动券 (用户激活优惠券时使用)
	 */
	@Override
	public MarketingResponse doTransaction(RequestContext context)
			throws MarketingException {
		// 获取参数
		Long userId = (Long) context.getRequest().getParam("userId");
		String couponCode = (String) context.getRequest()
				.getParam("couponCode");
		if (userId == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"userId is null");
		}
		if (couponCode == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"couponCode is null");
		}
		// 根据优惠券代码获取优惠券实体
		List<ActivityCoupon> activityCouponList = activityCouponManager
				.queryCouponByCode(couponCode);
		// 优惠券代码不存在
		if (activityCouponList.size() == 0) {
			throw new MarketingException(ReturnCodeEnum.COUPON_CODE_NOT_EXIST);
		}
		ActivityCoupon activityCoupon = null;
		for (ActivityCoupon coupon : activityCouponList) {
			if (coupon.getTotalCount().intValue() > coupon.getGrantedCount()
					.intValue()) {
				activityCoupon = coupon;
				break;
			}
		}
		// 符合条件的优惠券不存在，则已被激活
		if (activityCoupon == null) {
			throw new MarketingException(ReturnCodeEnum.COUPON_CODE_ACTIVATED);
		}
		// 更新优惠券发放数量
		List<ActivityCoupon> couponList = new ArrayList<ActivityCoupon>();
		activityCoupon.setGrantedCount(1l);
		couponList.add(activityCoupon);
		int row = activityCouponManager.updateGrantedCount(couponList);
		if (row == 0) {
			throw new MarketingException(ReturnCodeEnum.UPDATE_ERROR.getCode(),
					"increaseGrantedCount error");
		}

		// 根据活动取活动创建ID（发放者ID）
		ActivityDO activityDO = activityCouponManager
				.getActivity(activityCoupon.getActivityId());
		if (activityDO == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"coupon activityId:" + activityCoupon.getActivityId()
							+ " not exist");
		}
		// 先存储已被领用的营销活动券
		ReceivedCoupon receivedCoupon = new ReceivedCoupon();
		receivedCoupon.setCouponId(activityCoupon.getId());
		receivedCoupon.setGrantorUserId(activityDO.getCreatorUserId());
		receivedCoupon.setReceiverUserId(userId);
		receivedCoupon.setStatus(CouponStatus.UN_USE.getValue());
		receivedCoupon.setActivityId(activityDO.getId());
		receivedCoupon.setEndTime(activityDO.getEndTime());
		receivedCoupon.setStartTime(activityDO.getStartTime());
		receivedCouponManager.addReceivedCoupon(receivedCoupon);

		// 在存储已被发放的营销活动券
		GrantedCoupon grantedCoupon = new GrantedCoupon();
		grantedCoupon.setCouponId(activityCoupon.getId());
		grantedCoupon.setGrantorUserId(activityDO.getCreatorUserId());
		grantedCoupon.setReceiverUserId(userId);
		grantedCoupon.setStatus(CouponStatus.UN_USE.getValue());
		grantedCoupon.setActivityId(activityDO.getId());
		grantedCoupon.setEndTime(activityDO.getEndTime());
		grantedCoupon.setStartTime(activityDO.getStartTime());
		grantedCouponManager.addGrantedCoupon(grantedCoupon);

		// 返回response对象
		return ResponseUtil.getResponse(true);
	}

	@Override
	public String getName() {
		return ActionEnum.ACTIVATE_COUPON.getActionName();
	}
}
