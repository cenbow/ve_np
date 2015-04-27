package com.ve.itemcenter.core.service.action.globalproperty;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.GlobalPropertyDTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.GlobalPropertyManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查看全局属性Action
 * 
 * @author chen.huang
 *
 */
@Service
public class GetGlobalPropertyAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(GetGlobalPropertyAction.class);

	@Resource
	private GlobalPropertyManager globalPropertyManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		GlobalPropertyDTO globalPropertyDTO = null;
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证ID
		if (request.getLong("ID") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "globalPropertyID is missing");
		}
		Long globalPropertyId = request.getLong("ID");// SKU属性模板ID
		try {
			globalPropertyDTO = globalPropertyManager.getGlobalProperty(globalPropertyId);
			
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}
		response = ResponseUtil.getSuccessResponse(globalPropertyDTO);
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.GET_GLOBAL_PROPERTY.getActionName();
	}
}
