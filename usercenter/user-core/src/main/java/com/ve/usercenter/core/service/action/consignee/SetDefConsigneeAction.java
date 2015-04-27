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
public class SetDefConsigneeAction extends TransAction {

	@Resource
	private ConsigneeManager consigneeManager;

	@Override
	public String getName() {
		return ActionEnum.SET_DEFAULT_CONSIGNEE.getActionName();
	}

	@Override
	protected UserResponse doTransaction(RequestContext context)
			throws UserException {

		UserRequest userRequest = context.getRequest();
		Long userId = (Long) userRequest.getParam("userId");
		Long consigneeId = (Long) userRequest.getParam("consigneeId");// 收货地址id
		// 查询是否存在指定id对应的收货地址
		ConsigneeDTO consigneeDto = consigneeManager.getConsigneeById(userId,
				consigneeId);
		if (null == consigneeDto) {
			throw new UserException(ResponseCode.B_UPDATE_ERROR,
					"consignee is not exist");
		}

		// 如果修改的收货地址为默认地址，则返回
		if (consigneeDto.getIsDefault() == true) {
			throw new UserException(ResponseCode.B_UPDATE_ERROR,
					"consignee is default");
		}

		// 将指定用户的其他地址改为非默认
		consigneeManager.updateUserDefaultConsignee(userId);
		consigneeManager.setDefConsignee(userId, consigneeId);

		return new UserResponse(true);

	}

}
