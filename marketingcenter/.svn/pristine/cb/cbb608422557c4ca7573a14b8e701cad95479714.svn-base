package com.ve.marketingcenter.core.api.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.core.api.RequestAdapter;
import com.ve.marketingcenter.core.service.RequestDispatcher;

@Service
public class MarketingServiceImpl<T> implements MarketingService<T> {

	@Resource
	private RequestDispatcher requestDispatcher;

	/**
	 * 服务端接口执行
	 **/
	public Response<T> execute(Request request) {
		return requestDispatcher.dispatch(new RequestAdapter(request));
	}
}
