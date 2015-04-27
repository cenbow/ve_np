package com.ve.usercenter.core.service.action.usergroup;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.UserGroupDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserGroupManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class AddUserGroupAction implements Action {

	@Resource
	private UserGroupManager userGroupManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest userRequest = context.getRequest();
		UserGroupDTO userGroupDto = (UserGroupDTO) userRequest
				.getParam("userGroupDTO");

		userGroupDto = userGroupManager.addUserGroup(userGroupDto);
		return new UserResponse(userGroupDto);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.ADD_USER_GROUP.getActionName();
	}

}
