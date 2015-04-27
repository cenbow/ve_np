package com.ve.marketingcenter.common.constant.coupon;

public enum CouponGrantStatus {
	/**
	 * 未发放
	 */
	UN_GRANTED(1),
	/**
	 * 已发放
	 */
	GRANTED(2);

	private Integer value;

	private CouponGrantStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
