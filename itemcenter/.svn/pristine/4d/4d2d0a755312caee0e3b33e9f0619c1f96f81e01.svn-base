package com.ve.itemcenter.core.util;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ResCodeNum;

public class ResponseUtil {

	public static <T> ItemResponse<T> getSuccessResponse(T model) {
		ItemResponse res = new ItemResponse(model);
		res.setErrorCode(ResCodeNum.SUCCESS.getCode());
		res.setMessage(ResCodeNum.SUCCESS.getComment());
		return res;
	}

	public static <T> ItemResponse<T> getSuccessResponse(T model, long totalCount) {
		ItemResponse res = new ItemResponse(model, totalCount);
		res.setErrorCode(ResCodeNum.SUCCESS.getCode());
		res.setMessage(ResCodeNum.SUCCESS.getComment());
		return res;
	}

	public static ItemResponse getErrorResponse(ResCodeNum resCodeNum) {
		return new ItemResponse(resCodeNum);
	}

	public static ItemResponse getErrorResponse(ResCodeNum resCodeNum, String message) {
		return new ItemResponse(resCodeNum, message);
	}

	public static ItemResponse getErrorResponse(String errorCode, String message) {
		return new ItemResponse(errorCode, message);
	}

}
