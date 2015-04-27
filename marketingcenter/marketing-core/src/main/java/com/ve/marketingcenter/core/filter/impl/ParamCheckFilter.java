package com.ve.marketingcenter.core.filter.impl;

import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.filter.Filter;
import com.ve.marketingcenter.core.service.RequestContext;
@SuppressWarnings("rawtypes") 
public class ParamCheckFilter implements Filter{

	@Override
	public boolean isAccept(RequestContext ctx) {
		//TODO to be done
		return false;
	}

	@Override
	public boolean before(RequestContext ctx) throws MarketingException {
		// TODO  to be done
		return false;
	}

	@Override
	public boolean after(RequestContext ctx) throws MarketingException {
		// TODO  to be done
		return false;
	}
}
