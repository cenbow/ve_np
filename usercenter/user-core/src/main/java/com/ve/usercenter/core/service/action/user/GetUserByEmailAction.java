package com.ve.usercenter.core.service.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.constant.ResponseCode;
import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class GetUserByEmailAction implements Action {

	@Resource
	private UserManager userManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {
		// TODO Auto-generated method stub
		UserDTO userDto = null;

		UserRequest request = context.getRequest();
		String email = (String) request.getParam("email");// 用户邮箱

		userDto = userManager.getUserByEmail(email);
		if (null == userDto) {
			throw new UserException(ResponseCode.B_ADD_ERROR,
					"user is not exist");
		}

		return new UserResponse(userDto);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.GET_USER_BY_EMAIL.getActionName();
	}

}
