package com.ve.itemcenter.core.service.action.spuinfo;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.SpuInfoManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 删除商品属性Action
 * 
 * @author chen.huang
 *
 */
@Service
public class DeleteSpuInfoAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(DeleteSpuInfoAction.class);
	@Resource
	private SpuInfoManager spuInfoManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证ID
		if (request.getLong("ID") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "spuInfoID is missing");
		}
		Long spuInfoId = request.getLong("ID");// 商品品牌ID
		try {
			Boolean numOfDeleted = spuInfoManager.deleteSpuInfo(spuInfoId);
			response = ResponseUtil.getSuccessResponse(numOfDeleted);
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_SPU_INFO.getActionName();
	}
}
