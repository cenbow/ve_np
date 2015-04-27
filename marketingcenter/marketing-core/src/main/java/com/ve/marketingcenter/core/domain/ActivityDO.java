package com.ve.marketingcenter.core.domain;

import java.util.Date;
import java.util.List;

public class ActivityDO{
	private Long id;

	private String actCode;

	private String actName;

	private Date startTime;

	private Date endTime;

	private Integer couponFlag;

	private Integer couponType;

	private Integer repellentFlag;

	private Long toolId;

	private Integer creatorType;

	private Long creatorUserId;

	private Integer status;

	private Integer deleteFlag;

	private Integer platform;

	private Date gmtCreated;

	private Date gmtModified;
	
	private List<ScopeDO> marketScopes;
	
	private List<ActualParamDO> marketParams;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode == null ? null : actCode.trim();
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName == null ? null : actName.trim();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getCouponFlag() {
		return couponFlag;
	}

	public void setCouponFlag(Integer couponFlag) {
		this.couponFlag = couponFlag;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Integer getRepellentFlag() {
		return repellentFlag;
	}

	public void setRepellentFlag(Integer repellentFlag) {
		this.repellentFlag = repellentFlag;
	}

	public Long getToolId() {
		return toolId;
	}

	public void setToolId(Long toolId) {
		this.toolId = toolId;
	}

	public Integer getCreatorType() {
		return creatorType;
	}

	public void setCreatorType(Integer creatorType) {
		this.creatorType = creatorType;
	}

	public Long getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Long creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
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

	public List<ScopeDO> getMarketScopes() {
		return marketScopes;
	}

	public void setMarketScopes(List<ScopeDO> marketScopes) {
		this.marketScopes = marketScopes;
	}

	public List<ActualParamDO> getMarketParams() {
		return marketParams;
	}

	public void setMarketParams(List<ActualParamDO> marketParams) {
		this.marketParams = marketParams;
	}
}