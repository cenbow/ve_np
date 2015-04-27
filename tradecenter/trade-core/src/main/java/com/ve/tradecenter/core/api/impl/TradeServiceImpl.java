package com.ve.tradecenter.core.api.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.Response;
import com.ve.tradecenter.common.api.TradeService;
import com.ve.tradecenter.core.service.RequestDispatcher;

public class TradeServiceImpl implements TradeService{

	@Autowired
	private RequestDispatcher requestDispatcher;
	
	/**
	 * 服务端接口执行
	 **/
	@SuppressWarnings({"rawtypes" })
	@Override
	public Response execute(Request request) {
		// 代理基础的request
		Response response = requestDispatcher.dispatch(new RequestAdapter(request));
		return response;
	}
	
}
