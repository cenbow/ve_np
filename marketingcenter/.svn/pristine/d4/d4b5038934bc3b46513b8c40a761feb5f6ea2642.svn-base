package com.ve.marketingcenter.core.manager.coupon.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponStatus;
import com.ve.marketingcenter.common.domain.dto.coupon.OrderActivityDTO;
import com.ve.marketingcenter.core.domain.coupon.GrantedCoupon;
import com.ve.marketingcenter.core.domain.coupon.ReceivedCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.coupon.GrantedCouponManager;
import com.ve.marketingcenter.core.manager.coupon.OrderActivityManager;
import com.ve.marketingcenter.core.manager.coupon.ReceivedCouponManager;

@Service
public class OrderActivityManagerImpl implements OrderActivityManager {
	@Resource
	GrantedCouponManager grantedCouponManager;
	@Resource
	ReceivedCouponManager receivedCouponManager;

	@Override
	public void updateOrderActivityStatus(OrderActivityDTO orderActivityDTO,
			CouponStatus couponStatus) throws MarketingException {
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
		// 处理优惠券，由冻结状态变成未使用或已使用
		// 先处理被领用的营销活动券
		ReceivedCoupon receivedCoupon = new ReceivedCoupon();
		receivedCoupon.setOrderId(orderActivityDTO.getOrderId());
		receivedCoupon.setStatus(couponStatus.getValue());
		int row = receivedCouponManager.updateCouponStatus(receivedCoupon);
		// 在处理已被发放的营销活动券
		GrantedCoupon grantedCoupon = new GrantedCoupon();
		grantedCoupon.setOrderId(orderActivityDTO.getOrderId());
		grantedCoupon.setStatus(couponStatus.getValue());
		row = grantedCouponManager.updateCouponStatus(grantedCoupon);
	}

}
