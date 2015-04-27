package com.ve.itemcenter.core.api.impl;

import javax.annotation.Resource;

import com.ve.itemcenter.common.api.ItemService;
import com.ve.itemcenter.common.api.Request;
import com.ve.itemcenter.common.api.Response;
import com.ve.itemcenter.core.service.RequestDispatcher;

public class ItemServiceImpl implements ItemService {

	@Resource
	private RequestDispatcher requestDispatcher;

	/**
	 * 服务端接口执行
	 **/
	@SuppressWarnings({ "rawtypes" })
	@Override
	public Response execute(Request request) {
		// 代理基础的request
		Response response = requestDispatcher.dispatch(new RequestAdapter(
				request));
		return response;
	}

}
