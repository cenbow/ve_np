package com.ve.marketingcenter.core.manager.coupon;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.domain.qto.coupon.ReceivedCouponQTO;
import com.ve.marketingcenter.core.domain.coupon.ReceivedCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;

@Service
public interface ReceivedCouponManager {

	public ReceivedCoupon addReceivedCoupon(ReceivedCoupon receivedCoupon)
			throws MarketingException;

	public int batchAddReceivedCoupon(List<ReceivedCoupon> receivedCouponList)
			throws MarketingException;

	public int freezeCoupon(ReceivedCoupon receivedCoupon)
			throws MarketingException;

	public int updateCouponStatus(ReceivedCoupon receivedCoupon)
			throws MarketingException;

	public List<ReceivedCoupon> queryReceivedCoupon(
			ReceivedCouponQTO receivedCouponQTO) throws MarketingException;

}
