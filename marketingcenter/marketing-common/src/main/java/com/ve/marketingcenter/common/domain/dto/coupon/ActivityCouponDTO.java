package com.ve.marketingcenter.common.domain.dto.coupon;

import java.io.Serializable;

public class ActivityCouponDTO extends BaseDTO implements Serializable {

	private Long id;
	private String couponCode;
	private Integer status;
	private Long grantedCount;
	private Long activityId;
	private Long totalCount;
	private Integer couponType;
	private Integer scope;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getActivityId() {
		return activityId;
	}

	public Long getGrantedCount() {
		return grantedCount;
	}

	public void setGrantedCount(Long grantedCount) {
		this.grantedCount = grantedCount;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

}
