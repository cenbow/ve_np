package com.ve.tradecenter.core.service.action.payment;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.PaymentDTO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.PaymentManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

public class AddPayment implements Action {

	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);
	 
	@Resource
	private PaymentManager paymentManager;
	
	public TradeResponse<Boolean> execute(RequestContext context)
			throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		
		if(request.getParam("paymentDTO") == null){
			log.error("paymentDTO is null");
			response = ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"paymentDTO is null");
		}
		
		// 字段验证
		PaymentDTO paymentDTO = (PaymentDTO)request.getParam("paymentDTO");
		int result =0;
		boolean module = result > 0 ? true : false; 
		response = ResponseUtils.getSuccessResponse(module);
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.ADD_PAYMENT.getActionName();
	}
	
}
