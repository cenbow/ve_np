package com.ve.usercenter.client.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ve.usercenter.client.UserClient;
import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.BaseRequest;
import com.ve.usercenter.common.api.Request;
import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.api.UserService;
import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.common.dto.UserInfoDTO;
import com.ve.usercenter.common.qto.UserQTO;

public class UserClientImpl implements UserClient {

	@Resource
	private UserService userService;

	public Response<Boolean> activeUser(Long userId) {
		Request request = new BaseRequest();

		request.setParam("userId", userId);
		request.setCommand(ActionEnum.ACTIVE_USER.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> deletedUser(Long userId) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setCommand(ActionEnum.DELETE_USER.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> freezeUser(Long userId) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setCommand(ActionEnum.FREEZE_USER.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<UserDTO> getUserByEmail(String email) {
		Request request = new BaseRequest();
		request.setParam("email", email);
		request.setCommand(ActionEnum.GET_USER_BY_EMAIL.getActionName());
		Response<UserDTO> response = userService.execute(request);
		return response;
	}

	public Response<UserDTO> getUserById(Long userId) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setCommand(ActionEnum.GET_USER_BY_ID.getActionName());
		Response<UserDTO> response = userService.execute(request);
		return response;
	}

	public Response<UserDTO> getUserByMobile(String mobile) {
		Request request = new BaseRequest();
		request.setParam("mobile", mobile);
		request.setCommand(ActionEnum.GET_USER_BY_MOBILE.getActionName());
		Response<UserDTO> response = userService.execute(request);
		return response;
	}

	public Response<UserDTO> getUserByName(String name) {
		Request request = new BaseRequest();
		request.setParam("name", name);
		request.setCommand(ActionEnum.GET_USER_BY_NAME.getActionName());
		Response<UserDTO> response = userService.execute(request);
		return response;
	}

	public Response<UserDTO> addUser(UserDTO userDto) {
		Request request = new BaseRequest();
		request.setParam("userDTO", userDto);
		request.setCommand(ActionEnum.ADD_USER.getActionName());
		Response<UserDTO> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> moveUserIntoRecycle(Long userId) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setCommand(ActionEnum.MOVE_USER.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> restoreUser(Long userId) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setCommand(ActionEnum.RESTORE_USER.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> setUserRole(Long userId, Byte role) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setParam("role", role);
		request.setCommand(ActionEnum.SET_ROLE.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> updateEmail(Long userId, String email) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setParam("email", email);
		request.setCommand(ActionEnum.UPDATE_EMAIL.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> updateMobile(Long userId, String mobile) {
		Request request = new BaseRequest();

		request.setParam("userId", userId);
		request.setParam("mobile", mobile);
		request.setCommand(ActionEnum.UPDATE_MOBILE.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> updatePwd(Long userId, String newPwd, String oldPwd) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setParam("oldPwd", oldPwd);
		request.setParam("newPwd", newPwd);
		request.setCommand(ActionEnum.UPDATE_PWD.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<Boolean> updateHeadImg(Long userId, String headImg) {
		Request request = new BaseRequest();
		request.setParam("userId", userId);
		request.setParam("headImg", headImg);
		request.setCommand(ActionEnum.UPDATE_HEADIMG.getActionName());
		Response<Boolean> response = userService.execute(request);
		return response;
	}

	public Response<List> queryUser(UserQTO userQto) {
		Request request = new BaseRequest();
		request.setParam("userQto", userQto);
		request.setCommand(ActionEnum.QUERY_USER.getActionName());
		Response<List> response = userService.execute(request);
		return response;
	}

	public Response<UserDTO> apiUserLogin(UserInfoDTO userInfoDto) {
		Request request = new BaseRequest();
		request.setParam("userInfoDto", userInfoDto);
		request.setCommand(ActionEnum.API_USER_LOGIN.getActionName());
		Response<UserDTO> response = userService.execute(request);
		return response;
	}

	public Response<UserDTO> userLogin(String loginName, String loginPwd) {
		Request request = new BaseRequest();
		request.setParam("loginName", loginName);
		request.setParam("loginPwd", loginPwd);
		request.setCommand(ActionEnum.USER_LOGIN.getActionName());
		Response<UserDTO> response = userService.execute(request);
		return response;
	}

}
