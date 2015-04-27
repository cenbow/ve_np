package com.ve.marketingcenter.core.exception;

import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;

public class MarketingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2453984659537756900L;
	private String code;

	public MarketingException() {
		super();
	}

	public MarketingException(String message) {
		super(message);
	}

	public MarketingException(Throwable cause) {
		super(cause);
	}

	public MarketingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarketingException(String code, String message) {
		super(message);
		this.code = code;
	}

	public MarketingException(ReturnCodeEnum retCodeEnum) {
		super(retCodeEnum.getMessage());
		this.code = retCodeEnum.getCode();
	}

	public String getCode() {
		return code;
	}

}
