package com.ve.marketingcenter.common.domain.dto;

import java.io.Serializable;

public class MarketingActualParamDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6145585635045220301L;

	private Long id;

    private Integer ownerType;

    private Long ownerId;

    private String paramName;

    private String paramValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

}
