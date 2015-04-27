package com.ve.marketingcenter.common.domain.dto.coupon;

import java.io.Serializable;

public class CouponParamDTO extends BaseDTO implements Serializable {
	private String paramName;
	private String paramValue;

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

}