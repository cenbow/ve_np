package com.ve.tradecenter.client.impl;

import com.ve.tradecenter.client.OrderClient;
import com.ve.tradecenter.common.api.BaseRequest;
import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.Response;
import com.ve.tradecenter.common.api.TradeService;
import com.ve.tradecenter.common.domain.OrderDTO;

public class OrderClientImpl implements OrderClient{
	
	private TradeService tradeService;

	@Override
	public Response<OrderDTO> addOrder(OrderDTO orderDTO) {
		Request request = new BaseRequest();
		request.setParam("xxx", "xxx");
		Response response = tradeService.execute(request);
		return response;
	}
}
