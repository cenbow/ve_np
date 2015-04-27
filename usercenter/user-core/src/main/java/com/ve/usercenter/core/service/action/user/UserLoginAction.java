package com.ve.usercenter.core.service.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class UserLoginAction implements Action {

	@Resource
	private UserManager userManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {
		// TODO Auto-generated method stub

		UserRequest userRequest = context.getRequest();
		String loginName = (String) userRequest.getParam("loginName");// 登陆的用户名/邮箱/手机号
		String loginPwd = (String) userRequest.getParam("loginPwd");// 登陆的密码

		UserDTO userDto = userManager.userLogin(loginName, loginPwd);

		return new UserResponse(userDto);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.USER_LOGIN.getActionName();
	}

}
