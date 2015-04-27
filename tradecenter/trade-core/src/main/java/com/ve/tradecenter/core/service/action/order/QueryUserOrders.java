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
import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.util.TradeUtils;

public class QueryUserOrders implements Action{
	private static final Logger log = LoggerFactory.getLogger(QueryUserOrders.class);

	private static final int DEFAULT_START = 0;
	private static final int DEFAULT_PAGE_SIZE = 20;
	
	@Resource 
	private OrderManager orderManager;

	public TradeResponse<List<OrderDTO>> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<List<OrderDTO>> response = null;
		if(request.getParam("orderQTO") == null){
			log.error("orderQTO is null ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderQTO is null");
		}
		OrderQTO orderQTO = (OrderQTO)request.getParam("orderQTO");
		List<OrderDO> result ;
		int totalCount = 0;
		try{
			result = this.orderManager.queryUserOrders(orderQTO);
			// 相同条件的总数
			totalCount = this.orderManager.getTotalCount(orderQTO);
		}catch(TradeException e){
			log.error("db error: " ,e);
			response = ResponseUtils.getFailResponse(e.getResponseCode());
			return response;
		}
		
		List<OrderDTO> module = new ArrayList<OrderDTO>();
		for(OrderDO orderDO : result){
			/*OrderDTO orderDTO = new OrderDTO();
			TradeUtils.convert2DTO(orderDO, orderDTO);*/
			module.add(TradeUtils.convert2OrderDTO(orderDO));
		}
		response = ResponseUtils.getSuccessResponse(module);
		response.setTotalCount(totalCount); // 总记录数
		return response;
	}
	
	@Override
	public String getName() {
		return ActionEnum.QUERY_USER_ORDER.getActionName();
	}
}
