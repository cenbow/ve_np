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

/**
 * 根据用户id查找指定用户
 * */
@Service
public class GetUserByIdAction implements Action {

	@Resource
	private UserManager userManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserDTO userDto = null;
		UserRequest request = context.getRequest();
		Long userId = (Long) request.getParam("userId");

		userDto = userManager.getUserById(userId);

		if (null == userDto) {
			throw new UserException(ResponseCode.B_ADD_ERROR,
					"user is not exist");
		}

		return new UserResponse(userDto);
	}

	@Override
	public String getName() {
		return ActionEnum.GET_USER_BY_ID.getActionName();
	}

}
