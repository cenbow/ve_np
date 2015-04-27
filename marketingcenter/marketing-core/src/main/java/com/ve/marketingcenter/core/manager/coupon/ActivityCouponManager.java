package com.ve.marketingcenter.core.manager.coupon;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.domain.dto.coupon.CouponParamDTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ActivityCouponQTO;
import com.ve.marketingcenter.core.domain.ActivityDO;
import com.ve.marketingcenter.core.domain.coupon.ActivityCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;

@Service
public interface ActivityCouponManager {

	public ActivityCoupon addActivityCoupon(ActivityCoupon activityCoupon)
			throws MarketingException;

	public int batchAddActivityCoupon(List<ActivityCoupon> activityCouponList)
			throws MarketingException;

	public int updateGrantedCount(List<ActivityCoupon> activityCouponIdList)
			throws MarketingException;

	public List<ActivityCoupon> queryActivityCoupon(
			ActivityCouponQTO activityCouponQTO) throws MarketingException;

	public List<ActivityCoupon> queryCouponByCode(String couponCode)
			throws MarketingException;

	public ActivityDO getActivity(Long activityId) throws MarketingException;

	public ActivityCoupon getActivityCoupon(Long couponId)
			throws MarketingException;

	public List<CouponParamDTO> queryActivityParam(Long activityId)
			throws MarketingException;

}
