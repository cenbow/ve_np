package com.ve.usercenter.core.service.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.service.RequestContext;

@Service
public abstract class TransAction implements Action {
	@Resource
	TransactionTemplate transactionTemplate;

	protected abstract UserResponse doTransaction(RequestContext context)
			throws UserException;

	@SuppressWarnings("unchecked")
	@Override
	public UserResponse execute(final RequestContext context)
			throws UserException {
		return (UserResponse) transactionTemplate
				.execute(new TransactionCallback() {
					@Override
					public Object doInTransaction(TransactionStatus status) {
						try {
							return doTransaction(context);
						} catch (UserException e) {
							log.error(e.getMessage(), e);
							status.setRollbackOnly();
							return new UserResponse(e.getResponseCode().getCode(),
									e.getMessage());
						}
					}
				});
	}
}
