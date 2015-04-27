package com.ve.itemcenter.core.service.action.spuproperty;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.SpuPropertyDTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.SpuPropertyManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 更新商品属性Action
 * 
 * @author chen.huang
 *
 */

@Service
public class UpdateSpuPropertyAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(UpdateSpuPropertyAction.class);
	@Resource
	private SpuPropertyManager spuPropertyManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证DTO是否为空
		if (request.getParam("spuPropertyDTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "spuPropertyDTO is null");
		}
		SpuPropertyDTO spuPropertyDTO = (SpuPropertyDTO) request.getParam("spuPropertyDTO");
		try {
			Boolean isSuccessfullyUpdated = spuPropertyManager.updateSpuProperty(spuPropertyDTO);
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
		return ActionEnum.UPDATE_SPU_PROPERTY.getActionName();
	}
}
