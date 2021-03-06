package com.ve.itemcenter.core.service.action.itemsku;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemSkuManager;
import com.ve.itemcenter.core.manager.SkuPropertyManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 增加商品销售属性(ItemSku) Action
 * 
 * @author chen.huang
 *
 */
@Service
public class AddItemSkuAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(AddItemSkuAction.class);
	@Resource
	private ItemSkuManager itemSkuManager;

	@Resource
	private SkuPropertyManager skuPropertyManager;

	@Resource
	TransactionTemplate transactionTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public ItemResponse execute(final RequestContext context) throws ItemException {
		@SuppressWarnings("rawtypes")
		ItemResponse response = transactionTemplate.execute(new TransactionCallback() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					ItemResponse response = null;
					ItemRequest request = context.getRequest();
					// 验证DTO是否为空
					if (request.getParam("itemSkuDTO") == null) {
						return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "itemSkuDTO is null");
					}
					if (request.getParam("skuPropertyDTOList") == null) {
						return ResponseUtil
								.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "skuPropertyDTOList is null");
					}

					// 1.新增ItemSku记录
					ItemSkuDTO itemSkuDTO = (ItemSkuDTO) request.getParam("itemSkuDTO");
					List<SkuPropertyDTO> skuPropertyDTOList = (List<SkuPropertyDTO>) request
							.getParam("skuPropertyDTOList");

					itemSkuDTO = itemSkuManager.addItemSku(itemSkuDTO);// 新增加的itemSkuDO
					Long skuId = itemSkuDTO.getId();
					Long sellerId = itemSkuDTO.getSellerId();

					// 2.新增SkuProperty列表
					List<SkuPropertyDTO> list = skuPropertyManager
							.addSkuProperty(skuId, sellerId, skuPropertyDTOList);
					// 3.将SkuProperty列表中的val值以 "17g-蓝色-XXL"的形式更新到ItemSku表中
					itemSkuManager.updateItemSkuCodeValue(skuId, sellerId, skuPropertyDTOList);

					itemSkuDTO.setSkuPropertyDTOList(list);
					response = ResponseUtil.getSuccessResponse(itemSkuDTO);
					return response;
				} catch (ItemException e) {
					status.setRollbackOnly();
					log.error(e.getMessage());
					return ResponseUtil.getErrorResponse(e.getResCodeNum(), e.getMessage());
				}
			}
		});
		return response;

	}

	@Override
	public String getName() {
		return ActionEnum.ADD_ITEM_SKU.getActionName();
	}
}
