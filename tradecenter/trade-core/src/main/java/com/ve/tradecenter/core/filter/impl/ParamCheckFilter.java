package com.ve.tradecenter.core.filter.impl;

import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.filter.Filter;
import com.ve.tradecenter.core.service.RequestContext;

public class ParamCheckFilter implements Filter{

	@Override
	public boolean isAccept(RequestContext ctx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean before(RequestContext ctx) throws TradeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean after(RequestContext ctx) throws TradeException {
		// TODO Auto-generated method stub
		return false;
	}
}
