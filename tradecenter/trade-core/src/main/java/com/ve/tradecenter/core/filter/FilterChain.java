package com.ve.tradecenter.core.filter;

import java.util.List;

import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.service.RequestContext;


public interface FilterChain{
	
	/**
     * 在拦截操作方法之前调用，如果所有filter成功调用，则返回true
     * 否则返回false
     * @param ctx 当前请求上下文容器
	 * @throws TradeException 处理异常时抛出 
     */
	public boolean before(RequestContext ctx)  throws TradeException;
	
	/**
	 * 在拦截方法后调用
	 * 调用成功返回true， 失败返回false
	 * @param ctx 当前请求上下文容器
	 * @throws TradeException 处理异常时抛出 
	 */
	public boolean after(RequestContext ctx)  throws TradeException;
	
	public List<Filter> getFilters() throws TradeException;
}
