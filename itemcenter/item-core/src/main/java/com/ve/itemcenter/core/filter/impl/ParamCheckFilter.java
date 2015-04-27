package com.ve.itemcenter.core.filter.impl;

import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.filter.Filter;
import com.ve.itemcenter.core.service.RequestContext;

public class ParamCheckFilter implements Filter{

	@Override
	public boolean isAccept(RequestContext ctx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean before(RequestContext ctx) throws ItemException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean after(RequestContext ctx) throws ItemException {
		// TODO Auto-generated method stub
		return false;
	}
}
