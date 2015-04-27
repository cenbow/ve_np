package com.ve.marketingcenter.client;

import java.util.List;

import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;
import com.ve.marketingcenter.common.domain.dto.coupon.OrderActivityDTO;
import com.ve.marketingcenter.common.domain.dto.coupon.ReceivedCouponDTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ActivityCouponQTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ReceivedCouponQTO;

public interface CouponClient {
	/**
	 * 激活营销活动券
	 * 
	 * @param userId
	 * @param couponCode
	 * @return
	 */
	public Response<Boolean> activateCoupon(Long userId, String couponCode);

	/**
	 * 取消关联营销活动接口
	 * 
	 * @param orderActivityDTO
	 * @return
	 */
	public Response<Boolean> cancelOrderActivity(
			OrderActivityDTO orderActivityDTO);

	/**
	 * 生成营销活动优惠券
	 * 
	 * @param activityCouponDTO
	 * @return
	 */
	public Response<Boolean> generateActivityCoupon(
			ActivityCouponDTO activityCouponDTO);

	/**
	 * 发放(领用)营销活动优惠券
	 * 
	 * @param activityId
	 * @param userIdList
	 * @return
	 */
	public Response<Boolean> grantActivityCoupon(Long activityId,
			List<Long> userIdList);

	/**
	 * 查询活动包含的营销活动券
	 * 
	 * @param activityCouponQTO
	 * @return
	 */
	public Response<List<ActivityCouponDTO>> queryActivityCoupon(
			ActivityCouponQTO activityCouponQTO);

	/**
	 * 查询用户的营销活动券
	 * 
	 * @param receivedCouponQTO
	 * @return
	 */
	public Response<List<ReceivedCouponDTO>> queryUserCoupon(
			ReceivedCouponQTO receivedCouponQTO);

	/**
	 * 关联营销活动接口
	 * 
	 * @param orderActivityDTO
	 * @return
	 */
	public Response<Boolean> relateOrderActivity(
			OrderActivityDTO orderActivityDTO);

	/**
	 * 营销活动使用接口（支付完成时使用）
	 * 
	 * @param orderActivityDTO
	 * @return
	 */
	public Response<Boolean> useOrderActivity(OrderActivityDTO orderActivityDTO);

}
