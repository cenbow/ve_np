package com.ve.marketingcenter.common.domain.qto;

import java.io.Serializable;

public class MarketingFormalParamQTO extends BaseQTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5731359681351210970L;
	private Long ownerId;
	private Integer ownerType;
	private String paramName;
	private String dispName;
	private Integer valueType;
	private String description;

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getDispName() {
		return dispName;
	}

	public void setDispName(String dispName) {
		this.dispName = dispName;
	}

	public Integer getValueType() {
		return valueType;
	}

	public void setValueType(Integer valueType) {
		this.valueType = valueType;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
