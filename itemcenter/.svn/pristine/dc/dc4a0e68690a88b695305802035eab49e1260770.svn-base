package com.ve.itemcenter.core.service.action.skuproperty;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;
import com.ve.itemcenter.common.domain.qto.SkuPropertyQTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.SkuPropertyManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查询增加商品属性列表Action
 * 
 * @author chen.huang
 *
 */
@Service
public class QuerySkuPropertyAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(QuerySkuPropertyAction.class);
	@Resource
	private SkuPropertyManager skuPropertyManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		if (request.getParam("skuPropertyQTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "skuPropertyQTO is null");
		}
		SkuPropertyQTO skuPropertyQTO = (SkuPropertyQTO) request.getParam("skuPropertyQTO");

		try {
			List<SkuPropertyDTO> SkuPropertyDTOList = skuPropertyManager.querySkuProperty(skuPropertyQTO);
			response = ResponseUtil.getSuccessResponse(SkuPropertyDTOList, skuPropertyQTO.getTotalCount());
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_SKU_PROPERTY.getActionName();
	}
}
