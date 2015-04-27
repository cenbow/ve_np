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
import com.ve.usercenter.core.service.action.TransAction;

@Service
public class RestoreUserAction extends TransAction {

	@Resource
	private UserManager userManager;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.RESTORE_USER.getActionName();
	}

	@Override
	protected UserResponse doTransaction(RequestContext context)
			throws UserException {

		// TODO Auto-generated method stub

		UserRequest request = context.getRequest();
		Long userId = (Long) request.getParam("userId");

		UserDTO userDto = userManager.getRecycleUser(userId);
		if (null == userDto) {
			throw new UserException(ResponseCode.B_SELECT_ERROR,
					"user not in recycle");
		}

		userManager.restoreUser(userId);
		return new UserResponse(true);

	}

}
