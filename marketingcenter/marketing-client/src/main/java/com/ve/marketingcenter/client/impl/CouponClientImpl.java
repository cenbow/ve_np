package com.ve.marketingcenter.client.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ve.marketingcenter.client.CouponClient;
import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;
import com.ve.marketingcenter.common.domain.dto.coupon.OrderActivityDTO;
import com.ve.marketingcenter.common.domain.dto.coupon.ReceivedCouponDTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ActivityCouponQTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ReceivedCouponQTO;

public class CouponClientImpl implements CouponClient {
	@Resource
	private MarketingService marketingService;

	@Override
	public Response<Boolean> activateCoupon(Long userId, String couponCode) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

	@Override
	public Response<Boolean> cancelOrderActivity(
			OrderActivityDTO orderActivityDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CANCEL_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

	@Override
	public Response<Boolean> generateActivityCoupon(
			ActivityCouponDTO activityCouponDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

	@Override
	public Response<Boolean> grantActivityCoupon(Long activityId,
			List<Long> userIdList) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

	@Override
	public Response<List<ActivityCouponDTO>> queryActivityCoupon(
			ActivityCouponQTO activityCouponQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponQTO", activityCouponQTO);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

	@Override
	public Response<List<ReceivedCouponDTO>> queryUserCoupon(
			ReceivedCouponQTO receivedCouponQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

	@Override
	public Response<Boolean> relateOrderActivity(
			OrderActivityDTO orderActivityDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

	@Override
	public Response<Boolean> useOrderActivity(OrderActivityDTO orderActivityDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.USE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		return marketingService.execute(request);
	}

}
