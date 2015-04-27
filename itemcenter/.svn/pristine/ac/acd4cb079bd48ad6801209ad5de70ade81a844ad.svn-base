package com.ve.itemcenter.core.service.action.spuinfo;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.SpuInfoDTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.SpuInfoManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查看商品属性Action
 * 
 * @author chen.huang
 *
 */
@Service
public class GetSpuInfoAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(GetSpuInfoAction.class);

	@Resource
	private SpuInfoManager spuInfoManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		SpuInfoDTO spuInfoDTO = null;
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证ID
		if (request.getLong("ID") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "spuInfoID is missing");
		}
		Long spuInfoId = request.getLong("ID");// SKU属性模板ID
		try {
			spuInfoDTO = spuInfoManager.getSpuInfo(spuInfoId);
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}
		response = ResponseUtil.getSuccessResponse(spuInfoDTO);
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.GET_SPU_INFO.getActionName();
	}
}
