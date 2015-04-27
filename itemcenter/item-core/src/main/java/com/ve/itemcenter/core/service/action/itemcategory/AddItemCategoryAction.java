package com.ve.itemcenter.core.service.action.itemcategory;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemCategoryDTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemCategoryManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 增加商品销售属性(ItemCategory) Action
 * 
 * @author chen.huang
 *
 */
@Service
public class AddItemCategoryAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(AddItemCategoryAction.class);
	@Resource
	private ItemCategoryManager itemCategoryManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证DTO是否为空
		if (request.getParam("itemCategoryDTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "itemCategoryDTO is null");
		}
		ItemCategoryDTO itemCategoryDTO = (ItemCategoryDTO) request.getParam("itemCategoryDTO");
		try {
			itemCategoryDTO = itemCategoryManager.addItemCategory(itemCategoryDTO);// 新增加的itemCategoryDO
			response = ResponseUtil.getSuccessResponse(itemCategoryDTO);
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}
	}

	@Override
	public String getName() {
		return ActionEnum.ADD_ITEM_CATEGORY.getActionName();
	}
}
