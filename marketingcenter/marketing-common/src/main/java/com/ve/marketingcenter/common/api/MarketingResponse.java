package com.ve.marketingcenter.common.api;

import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;

public class MarketingResponse<T> implements Response<T> {
	private static final long serialVersionUID = 8295766534182699773L;

	private T module;
	private String resCode;
	private String message;
	private long totalCount;

	public MarketingResponse(String resCode) {
		this.resCode = resCode;
	}

	public MarketingResponse(String resCode, String message) {
		this.resCode = resCode;
		this.message = message;
	}

	public MarketingResponse(ReturnCodeEnum rtnCode) {
		this(rtnCode.getCode(), rtnCode.getMessage());
	}

	public MarketingResponse(ReturnCodeEnum rtnCode, String message) {
		this(rtnCode);
		this.message = message;
	}

	public MarketingResponse(T module) {
		this.module = module;
		this.resCode = ReturnCodeEnum.SUCCESS.getCode();
		this.message = ReturnCodeEnum.SUCCESS.getMessage();
	}

	public MarketingResponse(T module, long totalCount) {
		this.module = module;
		this.totalCount = totalCount;
		this.resCode = ReturnCodeEnum.SUCCESS.getCode();
		this.message = ReturnCodeEnum.SUCCESS.getMessage();
	}

	@Override
	public T getModule() {
		return module;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public void setModule(T module) {
		this.module = module;
	}

	@Override
	public boolean isSuccess() {
		return ReturnCodeEnum.SUCCESS.getCode().equals(this.resCode) ? true
				: false;
	}
}
