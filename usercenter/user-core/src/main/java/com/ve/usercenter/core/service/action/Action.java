package com.ve.usercenter.core.service.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.action.suppliercompany.DeleteCompanyAction;

/**
 * 操作对像基类
 * 
 * @author wujin.zzq
 * 
 */
@Service
public interface Action {
	static final Logger log = LoggerFactory
			.getLogger(DeleteCompanyAction.class);

	@SuppressWarnings("rawtypes")
	public UserResponse execute(RequestContext context) throws UserException;

	public String getName();
}
