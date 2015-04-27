package com.ve.marketingcenter.core.manager.coupon;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.constant.coupon.CouponStatus;
import com.ve.marketingcenter.common.domain.dto.coupon.OrderActivityDTO;
import com.ve.marketingcenter.core.exception.MarketingException;

@Service
public interface OrderActivityManager {

	public void updateOrderActivityStatus(OrderActivityDTO orderActivityDTO,
			CouponStatus couponStatus) throws MarketingException;

}
