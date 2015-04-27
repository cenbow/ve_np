package com.ve.usercenter.core.service.action.consignee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.ConsigneeDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.ConsigneeManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class QueryConsigneeAction implements Action {

	@Resource
	private ConsigneeManager consigneeManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		List<ConsigneeDTO> consigneeDtos = null;

		UserRequest userRequest = context.getRequest();
		Long userId = (Long) userRequest.getParam("userId");
		consigneeDtos = consigneeManager.queryConsignee(userId);
		return new UserResponse(consigneeDtos);
	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_CONSIGNEE.getActionName();
	}

}
