package com.ve.itemcenter.core.service.action.itemextrainfo;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemExtraInfoDTO;
import com.ve.itemcenter.common.domain.qto.ItemExtraInfoQTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemExtraInfoManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查询商品品牌列表Action
 * 
 * @author chen.huang
 *
 */
@Service
public class QueryItemExtraInfoAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(QueryItemExtraInfoAction.class);
	@Resource
	private ItemExtraInfoManager itemExtraInfoManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		if (request.getParam("itemExtraInfoQTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "itemExtraInfoQTO is null");
		}
		ItemExtraInfoQTO itemExtraInfoQTO = (ItemExtraInfoQTO) request.getParam("itemExtraInfoQTO");
		try {
			List<ItemExtraInfoDTO> itemExtraInfoDTOList = itemExtraInfoManager
					.queryItemExtraInfo(itemExtraInfoQTO);
			response = ResponseUtil.getSuccessResponse(itemExtraInfoDTOList, itemExtraInfoQTO.getTotalCount());
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_ITEM_EXTRA_INFO.getActionName();
	}
}
