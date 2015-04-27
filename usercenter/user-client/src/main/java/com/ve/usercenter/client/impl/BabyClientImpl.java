package com.ve.usercenter.client.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ve.usercenter.client.BabyClient;
import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.BaseRequest;
import com.ve.usercenter.common.api.Request;
import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.api.UserService;
import com.ve.usercenter.common.dto.UserBabyInfoDTO;

public class BabyClientImpl implements BabyClient {

	@Resource
	private UserService userService;

	public Response<UserBabyInfoDTO> addBabyInfo(UserBabyInfoDTO userBabyInfoDto) {
		Request request = new BaseRequest();
		request.setParam("userBabyDTO", userBabyInfoDto);
		request.setCommand(ActionEnum.ADD_USER_BABY_INFO.getActionName());
		Response<UserBabyInfoDTO> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> deleteBabyInfo(Long userId, Long babyId) {
		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setParam("babyId", babyId);
		request.setCommand(ActionEnum.DELETE_USER_BABY_INFO.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<List> queryBabyInfo(Long userId) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setCommand(ActionEnum.QUERY_USER_BABYS.getActionName());
		Response<List> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> updateBabyInfo(UserBabyInfoDTO babyInfoDTO) {
		Request request = new BaseRequest();
		request.setParam("userBabyDTO", babyInfoDTO);
		request.setCommand(ActionEnum.UPDATE_USER_BABY_INFO.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

}
