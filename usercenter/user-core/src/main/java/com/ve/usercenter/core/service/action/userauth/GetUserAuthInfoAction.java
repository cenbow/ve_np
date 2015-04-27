package com.ve.usercenter.core.service.action.userauth;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.UserAuthInfoDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserAuthInfoManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class GetUserAuthInfoAction implements Action {

	@Resource
	private UserAuthInfoManager userAuthInfoManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest userRequest = context.getRequest();
		Long userId = (Long) userRequest.getParam("userId");

		UserAuthInfoDTO authInfoDto = userAuthInfoManager
				.getAuthInfoByUserId(userId);

		return new UserResponse(authInfoDto);
	}

	@Override
	public String getName() {
		return ActionEnum.GET_USER_AUTH_INFO.getActionName();
	}

}
