package com.ve.itemcenter.core.service.action.item;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemDTO;
import com.ve.itemcenter.common.domain.qto.ItemQTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查询商品列表Action
 * 
 * @author chen.huang
 *
 */
@Service
public class QueryItemAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(QueryItemAction.class);
	@Resource
	private ItemManager itemManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		if (request.getParam("itemQTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "itemQTO is null");
		}
		ItemQTO itemQTO = (ItemQTO) request.getParam("itemQTO");
		try {
			List<ItemDTO> itemDTOList = itemManager.queryItem(itemQTO);
			response = ResponseUtil.getSuccessResponse(itemDTOList, itemQTO.getTotalCount());
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_ITEM.getActionName();
	}
}
