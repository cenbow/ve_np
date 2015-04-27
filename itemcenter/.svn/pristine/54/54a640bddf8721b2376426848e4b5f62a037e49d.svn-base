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
 * 增加全局属性Action
 * 
 * @author chen.huang
 *
 */
@Service
public class AddGlobalPropertyAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(AddGlobalPropertyAction.class);
	@Resource
	private GlobalPropertyManager globalPropertyManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证DTO是否为空
		if (request.getParam("globalPropertyDTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "globalPropertyDTO is null");
		}
		GlobalPropertyDTO globalPropertyDTO = (GlobalPropertyDTO) request.getParam("globalPropertyDTO");
		try {
			globalPropertyDTO = globalPropertyManager.addGlobalProperty(globalPropertyDTO);// 新增加的globalPropertyDO
			response = ResponseUtil.getSuccessResponse(globalPropertyDTO);
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}
	}

	@Override
	public String getName() {
		return ActionEnum.ADD_GLOBAL_PROPERTY.getActionName();
	}
}
