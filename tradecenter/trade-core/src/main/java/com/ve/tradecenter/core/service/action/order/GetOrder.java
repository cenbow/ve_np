package com.ve.tradecenter.core.service.action.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.OrderDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.domain.OrderItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderItemManager;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;
import com.ve.tradecenter.core.util.TradeUtils;

public class GetOrder implements Action{
	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);
	
	@Resource 
	private OrderManager orderManager;
	
	@Resource
	private OrderItemManager orderItemManager;
	
	public TradeResponse<OrderDTO> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<OrderDTO> response = null;
		if(request.getParam("userId") == null){
			log.error("userId is null ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}else if(request.getParam("orderId") == null){
			log.error("userId is null ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}
		
		long orderId = (Long) request.getParam("orderId");
		long userId = (Long) request.getParam("userId");
		
		OrderDO orderDO = null;
		List<OrderItemDO> orderItems = null;
		try{
			orderDO = this.orderManager.getOrder(orderId, userId);
			// 查询订单明细
			orderItems = this.orderItemManager.getOrderItems(orderId, userId);
		}catch(TradeException e){
			log.error("getOrder error: ",e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		if(orderDO != null && orderItems != null && orderItems.size() >0){
			OrderDTO orderDTO = new OrderDTO();
			orderDTO = TradeUtils.convert2OrderDTO(orderDO);
			
			List<OrderItemDTO> orderItems2 = new ArrayList<OrderItemDTO>();
			for(OrderItemDO item: orderItems){
				/*OrderItemDTO orderItem = new OrderItemDTO();
				TradeUtils.convert2DTO(item, orderItem);*/
				orderItems2.add(TradeUtils.convert2OrderItemDTO(item));
			}
			orderDTO.setOrderItems(orderItems2);
			response = ResponseUtils.getSuccessResponse(orderDTO);
		}else{
			log.error("order doesn't exist");
			response = ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order doesn't exist");
		}
		return response;
	}
	
	@Override
	public String getName() {
		return ActionEnum.GET_ORDER.getActionName();
	}
}
