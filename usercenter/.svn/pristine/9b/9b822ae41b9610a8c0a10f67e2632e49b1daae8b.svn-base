package com.ve.usercenter.core.service.action.userextra;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.SupplierExtraInfoManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

/**
 * 供应商的审核失败
 * */
@Service
public class RefuseSupplierIdenAction implements Action {

	@Resource
	private SupplierExtraInfoManager supplierExtraManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest userRequest = context.getRequest();
		Long userId = (Long) userRequest.getParam("userId");

		supplierExtraManager.refuseSupplierIden(userId);

		return new UserResponse(true);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.SUPPLIER_FAIL_IDENTIFIED_ACTION.getActionName();
	}

}
