package com.ve.marketingcenter.core.manager.coupon;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.domain.qto.coupon.GrantedCouponQTO;
import com.ve.marketingcenter.core.domain.coupon.GrantedCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;

@Service
public interface GrantedCouponManager {

	public GrantedCoupon addGrantedCoupon(GrantedCoupon grantedCoupon)
			throws MarketingException;

	public int batchAddGrantedCoupon(List<GrantedCoupon> grantedCouponList)
			throws MarketingException;

	public int freezeCoupon(GrantedCoupon grantedCoupon)
			throws MarketingException;

	public int updateCouponStatus(GrantedCoupon grantedCoupon)
			throws MarketingException;

	public List<GrantedCoupon> queryGrantedCoupon(
			GrantedCouponQTO grantedCouponQTO) throws MarketingException;

}
