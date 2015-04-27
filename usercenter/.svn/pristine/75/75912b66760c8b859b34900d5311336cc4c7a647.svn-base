package com.ve.usercenter.core.api;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;


import com.ve.usercenter.common.api.Request;
import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.api.UserService;
import com.ve.usercenter.core.service.RequestDispatcher;




public class UserServiceImpl implements UserService{

	@Resource
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
