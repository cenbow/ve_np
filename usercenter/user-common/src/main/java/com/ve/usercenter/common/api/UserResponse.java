package com.ve.usercenter.common.api;

import java.util.Collection;

import com.ve.usercenter.common.constant.ResponseCode;

public class UserResponse<T> implements Response<T> {
	private static final long serialVersionUID = 8295766534182699773L;

	private T module;
	private final String code;
	private final String message;
	private long totalCount = 0;

	public UserResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public UserResponse(String code, String message, T module) {
		this.code = code;
		this.message = message;
		this.module = module;
	}

	public UserResponse(T module) {
		this.module = module;
		if (module != null) {
			if (module instanceof Collection) {
				totalCount = ((Collection) module).size();
			} else {
				totalCount = 1;
			}
		}
		this.code = ResponseCode.REQUEST_SUCCESS.getCode();
		this.message = ResponseCode.REQUEST_SUCCESS.getMessage();
	}

	public UserResponse(T module, Long totalCount) {
		this.module = module;
		this.code = ResponseCode.REQUEST_SUCCESS.getCode();
		this.message = ResponseCode.REQUEST_SUCCESS.getMessage();
		this.totalCount = this.totalCount;
	}

	public T getModule() {
		return module;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public void setModule(T module) {
		this.module = module;
	}

	public String getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
