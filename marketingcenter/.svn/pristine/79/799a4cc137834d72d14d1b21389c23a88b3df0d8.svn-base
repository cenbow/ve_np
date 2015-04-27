package com.ve.marketingcenter.core.service.action.coupon;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponTypeStatus;
import com.ve.marketingcenter.common.domain.dto.coupon.ReceivedCouponDTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ReceivedCouponQTO;
import com.ve.marketingcenter.core.domain.ActivityDO;
import com.ve.marketingcenter.core.domain.coupon.ActivityCoupon;
import com.ve.marketingcenter.core.domain.coupon.ReceivedCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.coupon.ActivityCouponManager;
import com.ve.marketingcenter.core.manager.coupon.ReceivedCouponManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.ResponseUtil;

@Service
public class QueryUserCoupon implements Action {
	@Resource
	ActivityCouponManager activityCouponManager;

	@Resource
	ReceivedCouponManager receivedCouponManager;

	/**
	 * 查询用户的营销活动券
	 * 
	 * @throws MarketingException
	 */
	@Override
	public MarketingResponse execute(RequestContext context)
			throws MarketingException {
		// 获取参数
		ReceivedCouponQTO receivedCouponQTO = (ReceivedCouponQTO) context
				.getRequest().getParam("receivedCouponQTO");
		if (receivedCouponQTO == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"receivedCouponQTO is null");
		}
		if (receivedCouponQTO.getUserId() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"userId is null");
		}
		if (receivedCouponQTO.getStatus() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"status is null");
		}
		// 1未使用 2已使用 3已过期
		if (receivedCouponQTO.getStatus() != 1
				&& receivedCouponQTO.getStatus() != 2
				&& receivedCouponQTO.getStatus() != 3) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_ERROR.getCode(),
					"status not in (1,2,3) error");
		}
		// 根据条件查询符合条件的优惠券
		List<ReceivedCoupon> receivedCouponList = receivedCouponManager
				.queryReceivedCoupon(receivedCouponQTO);
		// do转成dto返回
		List<ReceivedCouponDTO> receivedCouponDTOList = new ArrayList();
		for (ReceivedCoupon receivedCoupon : receivedCouponList) {
			ReceivedCouponDTO receivedCouponDTO = new ReceivedCouponDTO();
			receivedCouponDTO.setCouponId(receivedCoupon.getCouponId());
			// 根据优惠券活动ID取有码无码类型
			ActivityDO activityDO = activityCouponManager
					.getActivity(receivedCoupon.getActivityId());
			if (activityDO == null) {
				throw new MarketingException(
						ReturnCodeEnum.PARAMETER_NULL.getCode(),
						"coupon activityId:" + receivedCoupon.getActivityId()
								+ " not exist");
			}
			receivedCouponDTO.setCouponType(activityDO.getCouponType());
			// 如果活动是有码券，则查询优惠券代码
			if (receivedCouponDTO.getCouponType().intValue() == CouponTypeStatus.CODE
					.getValue().intValue()) {
				// 取优惠券代码
				ActivityCoupon activityCoupon = activityCouponManager
						.getActivityCoupon(receivedCoupon.getCouponId());
				if (activityCoupon == null) {
					throw new MarketingException(
							ReturnCodeEnum.PARAMETER_NULL.getCode(), "couponId:"
									+ receivedCoupon.getCouponId()
									+ " not exist");
				}
				receivedCouponDTO.setCouponCode(activityCoupon.getCouponCode());
			}
			receivedCouponDTO.setEndTime(receivedCoupon.getEndTime());
			receivedCouponDTO.setStartTime(receivedCoupon.getStartTime());
			receivedCouponDTO.setStatus(receivedCouponQTO.getStatus());
			receivedCouponDTO.setCouponParam(activityCouponManager
					.queryActivityParam(receivedCoupon.getActivityId()));
			receivedCouponDTOList.add(receivedCouponDTO);
		}

		// 返回response对象
		return ResponseUtil.getResponse(receivedCouponDTOList,
				receivedCouponQTO.getTotalCount());
	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_USER_COUPON.getActionName();
	}
}
