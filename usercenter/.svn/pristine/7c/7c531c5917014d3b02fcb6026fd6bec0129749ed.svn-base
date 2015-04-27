package com.ve.usercenter.core.service.action.consignee;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.constant.ResponseCode;
import com.ve.usercenter.common.dto.ConsigneeDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.ConsigneeManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.TransAction;

@Service
public class UpdateConsigneeAction extends TransAction {

	@Resource
	private ConsigneeManager consigneeManager;

	@Override
	public String getName() {
		return ActionEnum.UPDATE_CONSIGNEE.getActionName();
	}

	@Override
	protected UserResponse doTransaction(RequestContext context)
			throws UserException {
		UserRequest userRequest = context.getRequest();
		ConsigneeDTO consigneeDto = (ConsigneeDTO) userRequest
				.getParam("consigneeDTO");

		if (null == consigneeDto) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"consigneeDTO is null");
		}

		// 如果新增的地址为默认地址，则将该用户的所有地址改为非默认
		if (consigneeDto.getIsDefault() == true) {
			consigneeManager.updateUserDefaultConsignee(consigneeDto
					.getUserId());
		}

		// 修改用户的收货地址
		consigneeManager.updateConsignee(consigneeDto);
		return new UserResponse(true);
	}

}
