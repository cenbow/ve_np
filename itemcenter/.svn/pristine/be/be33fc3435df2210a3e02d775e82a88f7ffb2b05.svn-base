package com.ve.itemcenter.client.impl;

import javax.annotation.Resource;

import com.ve.itemcenter.client.ItemClient;
import com.ve.itemcenter.common.api.BaseRequest;
import com.ve.itemcenter.common.api.ItemService;
import com.ve.itemcenter.common.api.Request;
import com.ve.itemcenter.common.api.Response;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.domain.dto.ItemDTO;

public class ItemClientImpl implements ItemClient {

	@Resource
	private ItemService itemService;

	public Response<ItemDTO> getItem(Long id, Long sellerId) {
		Request request = new BaseRequest();
		request.setParam("ID", 22L);
		request.setParam("sellerId", 1L);
		request.setCommand(ActionEnum.GET_ITEM_SKU.getActionName());
		return itemService.execute(request);
	}

}
