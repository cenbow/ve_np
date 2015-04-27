package com.ve.usercenter.core.service.action.consignee;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.ConsigneeManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class DeleteConsigneeAction implements Action {

	@Resource
	private ConsigneeManager consigneeManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest userRequest = context.getRequest();
		Long userId = (Long) userRequest.getParam("userId");
		Long consigneeId = (Long) userRequest.getParam("consigneeId");

		consigneeManager.deleteConsignee(userId, consigneeId);
		return new UserResponse(true);
	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_CONSIGNEE.getActionName();
	}

}
