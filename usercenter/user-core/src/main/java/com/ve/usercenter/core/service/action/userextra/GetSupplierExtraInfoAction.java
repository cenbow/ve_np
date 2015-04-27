package com.ve.usercenter.core.service.action.userextra;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.SupplierExtraInfoDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.SupplierExtraInfoManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class GetSupplierExtraInfoAction implements Action {

	@Resource
	private SupplierExtraInfoManager supplierExtraManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {
		UserRequest userRequest = context.getRequest();

		Long userId = (Long) userRequest.getParam("userId");

		SupplierExtraInfoDTO supplierExtraDto = supplierExtraManager
				.getSupplierExtraInfoByUserId(userId);

		return new UserResponse(supplierExtraDto);
	}

	@Override
	public String getName() {

		return ActionEnum.GET_SUPPLIER_EXTRA_INFO.getActionName();
	}

}
