package com.ve.marketingcenter.common.constant.coupon;

public enum UserCouponStatus {
	/**
	 * 未使用
	 */
	UN_USE(1),
	/**
	 * 已使用
	 */
	USED(2),
	/**
	 * 已过期
	 */
	EXPIRED(3);

	private Integer value;

	private UserCouponStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
