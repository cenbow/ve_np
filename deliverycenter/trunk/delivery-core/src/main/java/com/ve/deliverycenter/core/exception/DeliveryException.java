package com.ve.deliverycenter.core.exception;

import com.ve.deliverycenter.common.constant.RetCodeEnum;

public class DeliveryException extends Exception {
	private static final long serialVersionUID = 4065133016321980497L;
	private String code;

	public DeliveryException() {
		super();
	}

	public DeliveryException(String message) {
		super(message);
	}

	public DeliveryException(Throwable cause) {
		super(cause);
	}

	public DeliveryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeliveryException(String code, String message) {
		super(message);
		this.code = code;
	}

	public DeliveryException(RetCodeEnum retCodeEnum) {
		super(retCodeEnum.getMessage());
		this.code = retCodeEnum.getCode();
	}

	public String getCode() {
		return code;
	}
}
