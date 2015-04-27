package com.ve.usercenter.core.service.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class SetUserRoleAction implements Action {

	@Resource
	private UserManager userManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest request = context.getRequest();
		Long userId = (Long) request.getParam("userId");
		Byte role = (Byte) request.getParam("role");// 用户角色id
		userManager.setUserRole(userId, role);

		return new UserResponse(true);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.SET_ROLE.getActionName();
	}

}
