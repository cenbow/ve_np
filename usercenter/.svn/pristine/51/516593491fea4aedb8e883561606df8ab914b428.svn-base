package com.ve.usercenter.core.service.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.common.dto.UserInfoDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.TransAction;

/**
 * 第三方用户登陆
 * */
@Service
public class ApiUserLoginAction extends TransAction {

	@Resource
	private UserManager userManager;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.API_USER_LOGIN.getActionName();
	}

	@Override
	protected UserResponse doTransaction(RequestContext context)
			throws UserException {

		// TODO Auto-generated method stub

		UserRequest userRequest = context.getRequest();

		UserInfoDTO userInfoDto = (UserInfoDTO) userRequest
				.getParam("userInfoDTO");

		UserDTO userDto = userManager.apiUserLogin(userInfoDto);

		return new UserResponse(userDto);

	}

}
