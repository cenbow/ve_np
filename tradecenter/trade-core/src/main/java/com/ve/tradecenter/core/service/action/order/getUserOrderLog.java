package com.ve.tradecenter.core.service.action.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.OrderLogDTO;
import com.ve.tradecenter.core.domain.OrderLogDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderLogManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

/**
 * 显示订单操作明细  -- 用于用户的显示
 * @author cwr
 */
public class getUserOrderLog implements Action {
	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);

	@Resource 
	private OrderLogManager orderLogManager;
	
	public TradeResponse<List<OrderLogDTO>> execute(RequestContext context)
			throws TradeException {
		Request request = context.getRequest();
		TradeResponse<List<OrderLogDTO>> response = null;
		if(request.getParam("orderId") == null){
			log.error("orderId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}else if(request.getParam("userId") ==null){
			log.error("userId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}
		
		Long orderId = (Long) request.getParam("userId");
		Long userId = (Long) request.getParam("orderId");
		
		List<OrderLogDO> result = this.orderLogManager.getUserOrderLog(orderId, userId);
		
		List<OrderLogDTO> module = new ArrayList<OrderLogDTO>();
		for(OrderLogDO orderLog : result){
			OrderLogDTO orderLogDTO = new OrderLogDTO();
			orderLogDTO.setLogInfo(orderLog.getLogInfo());
			orderLogDTO.setTimeLog(orderLog.getTimeLog());
			orderLogDTO.setOperator(orderLog.getOperator());
			module.add(orderLogDTO);
		}
		response = ResponseUtils.getSuccessResponse(module);
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.GET_USER_ORDER_LOG.getActionName();
	}
}
