package com.ve.itemcenter.core.service.action.salesfield;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.SalesFieldDTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.SalesFieldManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 更新专场Action
 * 
 * @author chen.huang
 *
 */

@Service
public class UpdateSalesFieldAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(UpdateSalesFieldAction.class);
	@Resource
	private SalesFieldManager salesFieldManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证DTO是否为空
		if (request.getParam("salesFieldDTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "salesFieldDTO is null");
		}
		SalesFieldDTO salesFieldDTO = (SalesFieldDTO) request.getParam("salesFieldDTO");
		try {
			Boolean isSuccessfullyUpdated = salesFieldManager.updateSalesField(salesFieldDTO);
			response = ResponseUtil.getSuccessResponse(isSuccessfullyUpdated);
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.UPDATE_SALES_FIELD.getActionName();
	}
}
