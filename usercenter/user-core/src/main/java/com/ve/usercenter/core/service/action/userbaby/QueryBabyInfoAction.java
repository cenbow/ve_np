package com.ve.usercenter.core.service.action.userbaby;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.UserBabyInfoDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserBabyInfoManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class QueryBabyInfoAction implements Action {

	@Resource
	private UserBabyInfoManager userBabyInfoManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		List<UserBabyInfoDTO> babysDto = null;

		UserRequest userRequest = context.getRequest();
		Long userId = (Long) userRequest.getParam("userId");
		babysDto = userBabyInfoManager.queryBabyInfo(userId);
		return new UserResponse(babysDto);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.QUERY_USER_BABYS.getActionName();
	}

}
