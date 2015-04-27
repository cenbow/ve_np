package com.ve.marketingcenter.common.domain.qto.coupon;

import java.io.Serializable;

import com.ve.marketingcenter.common.domain.qto.BaseQTO;

public class ActivityCouponQTO extends BaseQTO implements Serializable {
	private Long activityId;
	private Long suppliedUserId;
	private Integer status;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getSuppliedUserId() {
		return suppliedUserId;
	}

	public void setSuppliedUserId(Long suppliedUserId) {
		this.suppliedUserId = suppliedUserId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
