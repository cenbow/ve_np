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
public class AddConsigneeAction extends TransAction {

	private static final int MAX_CONSIGNEE = 20;
	@Resource
	private ConsigneeManager consigneeManager;

	@Override
	public String getName() {
		return ActionEnum.ADD_CONSIGNEE.getActionName();
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

		Long userId = consigneeDto.getUserId();
		// 查询当前用户的总的收货地址数量，如果大余20条，则不能插入
		Integer totalCount = consigneeManager.getConsigneeCountByUserId(userId);
		if (totalCount >= MAX_CONSIGNEE) {
			throw new UserException(ResponseCode.B_ADD_ERROR,
					"user consignee can't greater than 20");
		}

		// 如果新增的地址为默认地址，则将该用户的默认地址改为非默认
		if (consigneeDto.getIsDefault() == true) {
			consigneeManager.updateUserDefaultConsignee(userId);
		}

		// 添加收货地址
		consigneeDto = consigneeManager.addConsignee(consigneeDto);
		return new UserResponse(consigneeDto);
	}

}
