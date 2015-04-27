package com.ve.marketingcenter.core.service.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.util.ResponseUtil;

@Service
public abstract class TransAction implements Action {
	@Resource
	TransactionTemplate transactionTemplate;

	protected abstract MarketingResponse doTransaction(RequestContext context)
			throws MarketingException;

	@SuppressWarnings("unchecked")
	@Override
	public MarketingResponse execute(final RequestContext context)
			throws MarketingException {
		return (MarketingResponse) transactionTemplate
				.execute(new TransactionCallback() {
					@Override
					public Object doInTransaction(TransactionStatus status) {
						try {
							return doTransaction(context);
						} catch (MarketingException e) {
							log.error(e.getMessage(), e);
							status.setRollbackOnly();
							return ResponseUtil.getResponse(e.getCode(),
									e.getMessage());
						}
					}
				});
	}
}
