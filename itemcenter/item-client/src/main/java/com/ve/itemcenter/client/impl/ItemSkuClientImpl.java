package com.ve.itemcenter.client.impl;

import javax.annotation.Resource;

import com.ve.itemcenter.client.ItemSkuClient;
import com.ve.itemcenter.common.api.BaseRequest;
import com.ve.itemcenter.common.api.ItemService;
import com.ve.itemcenter.common.api.Request;
import com.ve.itemcenter.common.api.Response;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;

public class ItemSkuClientImpl implements ItemSkuClient {

	@Resource
	private ItemService itemService;

	public Response<ItemSkuDTO> getItemSku(Long id, Long sellerId) {
		Request request = new BaseRequest();
		request.setParam("ID", 12L);
		request.setParam("sellerId", 1L);
		request.setCommand(ActionEnum.GET_ITEM_SKU.getActionName());
		return itemService.execute(request);
	}

}
