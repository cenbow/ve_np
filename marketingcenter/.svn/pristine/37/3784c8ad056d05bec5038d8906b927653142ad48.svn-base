package com.ve.marketingcenter.core.util;

import java.util.List;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;

public class ResponseUtil {
	public static MarketingResponse getResponse(String code, String message) {
		MarketingResponse response = new MarketingResponse(code, message);
		return response;
	}

	public static MarketingResponse getResponse(ReturnCodeEnum retCodeEnum) {
		MarketingResponse response = new MarketingResponse(retCodeEnum);
		return response;
	}

	public static MarketingResponse getResponse(Object model) {
		MarketingResponse response = new MarketingResponse(model);
		return response;
	}

	public static MarketingResponse getResponse(List modelList, long totalCount) {
		MarketingResponse response = new MarketingResponse(modelList,
				totalCount);
		return response;
	}
}
