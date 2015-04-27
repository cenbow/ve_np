package com.ve.usercenter.core.service.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.TransAction;

/**
 * 将用户移入回收站
 * */
@Service
public class MoveToRecycleAction extends TransAction {

	@Resource
	private UserManager userManager;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.MOVE_USER.getActionName();
	}

	@Override
	protected UserResponse doTransaction(RequestContext context)
			throws UserException {

		UserRequest request = context.getRequest();
		Long userId = (Long) request.getParam("userId");

		userManager.moveToRecycle(userId);

		return new UserResponse(true);

	}

}
