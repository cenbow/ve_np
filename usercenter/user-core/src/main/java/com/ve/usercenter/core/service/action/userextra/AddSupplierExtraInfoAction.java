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
public class AddSupplierExtraInfoAction implements Action {

	@Resource
	private SupplierExtraInfoManager supplierExtraManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {
		UserRequest userRequest = context.getRequest();
		SupplierExtraInfoDTO supplierExtraDto = (SupplierExtraInfoDTO) userRequest
				.getParam("supplierExtraDTO"); // 卖家扩展信息dto

		supplierExtraDto = supplierExtraManager
				.addSupplierExtraInfo(supplierExtraDto);
		return new UserResponse(supplierExtraDto);
	}

	@Override
	public String getName() {
		return ActionEnum.ADD_SUPPLIER_EXTRA_INFO.getActionName();
	}

}