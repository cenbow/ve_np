package com.ve.itemcenter.core.service.action.comment;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemCommentManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 删除商品评论Action
 * 
 * @author chen.huang
 *
 */
@Service
public class DeleteItemCommentAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(DeleteItemCommentAction.class);
	@Resource
	private ItemCommentManager itemCommentManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证ID
		if (request.getLong("ID") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "ItemCommentID is missing");
		}
		// 验证sellerId
		if (request.getLong("sellerId") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "sellerId is missing");
		}
		Long itemCommentId = request.getLong("ID");// 商品评论ID
		Long sellerId = request.getLong("sellerId");// 供应商ID
		try {
			Boolean isDeletedSuccessfully = itemCommentManager.deleteItemComment(itemCommentId, sellerId);
			response = ResponseUtil.getSuccessResponse(isDeletedSuccessfully);
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_ITEMCOMMENT.getActionName();
	}
}
