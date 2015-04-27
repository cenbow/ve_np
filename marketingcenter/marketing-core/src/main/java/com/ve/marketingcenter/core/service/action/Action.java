package com.ve.marketingcenter.core.service.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.service.RequestContext;

/**
 * 操作对像基类
 * 
 * @author wujin.zzq
 *
 */
@Service
public interface Action<T> {
	static final Log log = LogFactory.getLog(Action.class);

	public MarketingResponse<T> execute(RequestContext<T> context)
			throws MarketingException;

	public String getName();
}
