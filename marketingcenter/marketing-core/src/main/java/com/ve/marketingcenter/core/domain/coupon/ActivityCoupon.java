package com.ve.marketingcenter.core.domain.coupon;

import java.util.Date;

public class ActivityCoupon extends BaseDo {
	private Long id;
	private Long activityId;
	private Long suppliedUserId;
	private String couponCode;
	private Integer scope;
	private Long totalCount;
	private Long grantedCount;
	private Integer status;
	private Date gmtCreated;
	private Date gmtModified;
	private Integer deleted;

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getGrantedCount() {
		return grantedCount;
	}

	public void setGrantedCount(Long grantedCount) {
		this.grantedCount = grantedCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
}
