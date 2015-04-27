package com.ve.usercenter.client.impl;

import javax.annotation.Resource;

import com.ve.usercenter.client.UserAuthClient;
import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.BaseRequest;
import com.ve.usercenter.common.api.Request;
import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.api.UserService;
import com.ve.usercenter.common.dto.UserAuthInfoDTO;

public class UserAuthClientImpl implements UserAuthClient {
	@Resource
	private UserService userService;

	public Response<UserAuthInfoDTO> saveUserAuthInfo(
			UserAuthInfoDTO authInfoDto) {
		Request request = new BaseRequest();
		request.setParam("userAuthDTO", authInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response<UserAuthInfoDTO> response = userService.execute(request);
		return response;
	}

	public Response<UserAuthInfoDTO> getAuthInfoByUserId(Long userId) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setCommand(ActionEnum.GET_USER_AUTH_INFO.getActionName());
		Response<UserAuthInfoDTO> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> passUserIden(Long userId, String remark) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setParam("remark", remark);
		request.setCommand(ActionEnum.IDENTIFIED_USER_AUTH_INFO.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> refuseUserIden(Long userId, String remark) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setParam("remark", remark);
		request.setCommand(ActionEnum.FILEIDENTIFIED_USER_AUTH_INFO
				.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}
}
