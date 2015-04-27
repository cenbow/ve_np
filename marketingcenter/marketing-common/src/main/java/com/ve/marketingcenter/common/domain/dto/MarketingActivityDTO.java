package com.ve.marketingcenter.common.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MarketingActivityDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3357517183458525059L;
	private Long id;
	private String actName;
	private Date startTime;
	private Date endTime;
	private String platform;
	private Integer repellentFlag;
	private Integer couponFlag;
	private Integer couponType;
	private Long toolId;
	private Integer creatorType;
	private Long creatorUserId;
//	/**
//	 * 此map存放活动的范围，结构如下：
//	 * 
//	 */
//	private Map<String, Map<String,List<Long>>> scopeParams;
//
//	/**
//	 * 此map存放活动的工具实参
//	 */
//	private Map<String, String> toolParams;
	
	private List<MarketingScopeDTO> marketScopes;
	
	private List<MarketingActualParamDTO> marketParams;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Integer getRepellentFlag() {
		return repellentFlag;
	}

	public void setRepellentFlag(Integer repellentFlag) {
		this.repellentFlag = repellentFlag;
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

	public List<MarketingScopeDTO> getMarketScopes() {
		return marketScopes;
	}

	public void setMarketScopes(List<MarketingScopeDTO> marketScopes) {
		this.marketScopes = marketScopes;
	}

	public List<MarketingActualParamDTO> getMarketParams() {
		return marketParams;
	}

	public void setMarketParams(List<MarketingActualParamDTO> marketParams) {
		this.marketParams = marketParams;
	}

//	public Map<String, Map<String, List<Long>>> getScopeParams() {
//		return scopeParams;
//	}
//
//	public void setScopeParams(Map<String, Map<String, List<Long>>> scopeParams) {
//		this.scopeParams = scopeParams;
//	}
//
//	public Map<String, String> getToolParams() {
//		return toolParams;
//	}
//
//	public void setToolParams(Map<String, String> toolParams) {
//		this.toolParams = toolParams;
//	}
}
