package com.ve.itemcenter.core.service.action.itempropertytmpl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemPropertyTmplDTO;
import com.ve.itemcenter.common.domain.qto.ItemPropertyTmplQTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemPropertyTmplManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查询增加商品属性模板列表Action
 * 
 * @author chen.huang
 *
 */
@Service
public class QueryItemPropertyTmplAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(QueryItemPropertyTmplAction.class);
	@Resource
	private ItemPropertyTmplManager itemPropertyTmplManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		if (request.getParam("itemPropertyTmplQTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "itemPropertyTmplQTO is null");
		}
		ItemPropertyTmplQTO itemPropertyTmplQTO = (ItemPropertyTmplQTO) request.getParam("itemPropertyTmplQTO");

		try {
			List<ItemPropertyTmplDTO> ItemPropertyTmplDTOList = itemPropertyTmplManager
					.queryItemPropertyTmpl(itemPropertyTmplQTO);
			response = ResponseUtil.getSuccessResponse(ItemPropertyTmplDTOList, itemPropertyTmplQTO
					.getTotalCount());
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_ITEM_PROPERTY_TMPL.getActionName();
	}
}
