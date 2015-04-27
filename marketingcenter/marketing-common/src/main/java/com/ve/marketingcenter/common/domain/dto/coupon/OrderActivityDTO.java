package com.ve.marketingcenter.common.domain.dto.coupon;

import java.io.Serializable;
import java.util.List;

public class OrderActivityDTO extends BaseDTO implements Serializable {
	private Long orderId;
	private Long userId;
	private List<Long> activityIdList;
	private List<Long> couponIdList;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getActivityIdList() {
		return activityIdList;
	}

	public void setActivityIdList(List<Long> activityIdList) {
		this.activityIdList = activityIdList;
	}

	public List<Long> getCouponIdList() {
		return couponIdList;
	}

	public void setCouponIdList(List<Long> couponIdList) {
		this.couponIdList = couponIdList;
	}

}
