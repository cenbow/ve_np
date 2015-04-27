package com.ve.usercenter.core.service.action.userextra;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.UserExtraInfoDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.UserExtraInfoManage;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class AddUserExtraInfoAction implements Action {

	@Resource
	private UserExtraInfoManage userExtraInfoManage;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest userRequest = context.getRequest();

		UserExtraInfoDTO userExtraDto = (UserExtraInfoDTO) userRequest
				.getParam("userExtraDTO");// 买家的扩展信息

		userExtraDto = userExtraInfoManage.addUserExtraInfo(userExtraDto);
		return new UserResponse(userExtraDto);
	}

	@Override
	public String getName() {
		return ActionEnum.ADD_USER_EXTRA_INFO.getActionName();
	}

}
