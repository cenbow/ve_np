package com.ve.deliverycenter.core.filter.impl;

import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.filter.Filter;
import com.ve.deliverycenter.core.service.RequestContext;

public class ParamCheckFilter implements Filter {

	@Override
	public boolean isAccept(RequestContext ctx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean before(RequestContext ctx) throws DeliveryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean after(RequestContext ctx) throws DeliveryException {
		// TODO Auto-generated method stub
		return false;
	}
}
