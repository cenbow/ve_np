package com.ve.itemcenter.core.exception;

import com.ve.itemcenter.common.constant.ResCodeNum;

public class ItemException extends Exception {
	private static final long serialVersionUID = 4065133016321980497L;
	private String errorCode;
	private String message;
	private ResCodeNum resCodeNum;

	public ItemException() {
		super();
		this.errorCode = ResCodeNum.SYS_E_DEFAULT_ERROR.getCode();
	}

	public ItemException(String message) {
		super(message);
		this.errorCode = ResCodeNum.SYS_E_DEFAULT_ERROR.getCode();
	}

	public ItemException(Throwable cause) {
		super(cause);
		this.errorCode = ResCodeNum.SYS_E_DEFAULT_ERROR.getCode();
	}

	public ItemException(String message, Throwable cause) {
		super(message, cause);
		this.errorCode = ResCodeNum.SYS_E_DEFAULT_ERROR.getCode();
	}

	public ItemException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ItemException(ResCodeNum resCodeNum, Throwable cause) {
		super(resCodeNum.getComment(), cause);
		this.errorCode = resCodeNum.getCode();
	}

	public ItemException(ResCodeNum resCodeNum, String message) {
		this.message = message;
		this.errorCode = resCodeNum.getCode();
		this.resCodeNum = resCodeNum;
	}

	public ItemException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public ResCodeNum getResCodeNum() {
		return resCodeNum;
	}

	public void setResCodeNum(ResCodeNum resCodeNum) {
		this.resCodeNum = resCodeNum;
	}
}
