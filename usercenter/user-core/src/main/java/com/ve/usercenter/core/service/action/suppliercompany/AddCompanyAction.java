package com.ve.usercenter.core.service.action.suppliercompany;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.SupplierCompanyDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.CompanyManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.Action;

@Service
public class AddCompanyAction implements Action {

	@Resource
	private CompanyManager companyManager;

	@Override
	public UserResponse execute(RequestContext context) throws UserException {

		UserRequest userRequest = context.getRequest();
		SupplierCompanyDTO supplierCompanyDto = (SupplierCompanyDTO) userRequest
				.getParam("supplierCompanyDTO ");
		try {
			supplierCompanyDto = companyManager.addCompany(supplierCompanyDto);
		} catch (UserException e) {
			log.error(e.getMessage(), e);
			return new UserResponse(e.getResponseCode().getCode(),
					e.getMessage());
		}

		return new UserResponse(supplierCompanyDto);
	}

	@Override
	public String getName() {

		return ActionEnum.ADD_SUPPLIER_COMPANY.getActionName();
	}

}
