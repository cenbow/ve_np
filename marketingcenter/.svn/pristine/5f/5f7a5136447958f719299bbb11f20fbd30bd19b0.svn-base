package com.ve.marketingcenter.core.service;

import com.ve.marketingcenter.common.api.MarketingResponse;

/**
 * 当前请求的上下文容器
 * 
 * @author wujin.zzq
 */
public class RequestContext<T> extends Context {
	private static final long serialVersionUID = -1054539809433963262L;

	/**
	 * 系统级别的上下文容器
	 */
	private AppContext appContext;

	/**
	 * 当前请求的请求对象
	 */
	private MarketingRequest request;

	/**
	 * 返回的response对象
	 */
	private MarketingResponse<T> response;

	/**
	 * @param appContext
	 * @param serverSideRequest
	 */
	public RequestContext(AppContext appContext, MarketingRequest request) {
		this.appContext = appContext;
		this.request = request;
	}

	/**
	 * @return the appContext
	 */
	public AppContext getAppContext() {
		return appContext;
	}

	/**
	 * @return the request
	 */
	public MarketingRequest getRequest() {
		return request;
	}

	/**
	 * @return the response
	 */
	public MarketingResponse<T> getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(MarketingResponse<T> response) {
		this.response = response;
	}
}
