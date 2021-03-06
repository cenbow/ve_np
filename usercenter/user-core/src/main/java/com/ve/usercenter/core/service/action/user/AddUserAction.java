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

/**
 * 添加用户接口
 * */
@Service
public class AddUserAction implements Action {

	@Resource
	private UserManager userManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest userRequest = context.getRequest();
		UserDTO userDto = (UserDTO) userRequest.getParam("userDTO");

		userDto = userManager.addUser(userDto);
		return new UserResponse(userDto);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.ADD_USER.getActionName();
	}

}
