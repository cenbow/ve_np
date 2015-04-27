package com.ve.usercenter.core.filter.impl;

import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.filter.Filter;
import com.ve.usercenter.core.service.RequestContext;


public class ParamCheckFilter implements Filter{

	@Override
	public boolean isAccept(RequestContext ctx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean before(RequestContext ctx) throws UserException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean after(RequestContext ctx) throws UserException {
		// TODO Auto-generated method stub
		return false;
	}
}
