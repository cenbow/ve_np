package com.ve.itemcenter.core.service.action.itemsku;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;
import com.ve.itemcenter.common.domain.qto.SkuPropertyQTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemSkuManager;
import com.ve.itemcenter.core.manager.SkuPropertyManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查看商品销售属性(ItemSku) Action
 * 
 * @author chen.huangt
 *
 */
@Service
public class GetItemSkuAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(GetItemSkuAction.class);

	@Resource
	private ItemSkuManager itemSkuManager;

	@Resource
	private SkuPropertyManager skuPropertyManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemSkuDTO itemSkuDTO = null;
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		// 验证ID
		if (request.getLong("ID") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "itemSkuID is missing");
		}
		if (request.getLong("sellerId") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "sellerId is missing");
		}
		Long skuId = request.getLong("ID");// 商品销售属性(ItemSku)ID
		Long sellerId = request.getLong("sellerId");// 供应商ID
		try {
			itemSkuDTO = itemSkuManager.getItemSku(skuId, sellerId);
			// 根据skuId和sellerId获取SkuPropertyList
			SkuPropertyQTO skuPropertyQTO = new SkuPropertyQTO();
			skuPropertyQTO.setSellerId(sellerId);
			skuPropertyQTO.setSkuId(skuId);
			List<SkuPropertyDTO> skuPropertyDTOList = skuPropertyManager.querySkuProperty(skuPropertyQTO);
			itemSkuDTO.setSkuPropertyDTOList(skuPropertyDTOList);
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}
		response = ResponseUtil.getSuccessResponse(itemSkuDTO);
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.GET_ITEM_SKU.getActionName();
	}
}
