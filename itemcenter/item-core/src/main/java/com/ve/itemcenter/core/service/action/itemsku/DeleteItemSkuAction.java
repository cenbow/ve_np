package com.ve.itemcenter.core.service.action.itemsku;

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
import com.ve.itemcenter.common.domain.qto.SkuPropertyQTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemSkuManager;
import com.ve.itemcenter.core.manager.SkuPropertyManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ExceptionUtil;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 删除商品销售属性(ItemSku) Action
 * 
 * @author chen.huang
 *
 */
@Service
public class DeleteItemSkuAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(DeleteItemSkuAction.class);
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
					if (request.getLong("skuId") == null) {
						return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "ItemSkuID is missing");
					}
					if (request.getLong("sellerId") == null) {
						return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "sellerId is missing");
					}
					Long skuId = request.getLong("skuId");// 商品销售属性(ItemSku)ID
					Long sellerId = request.getLong("sellerId");// 供应商ID
					SkuPropertyQTO skuPropertyQTO = new SkuPropertyQTO();
					skuPropertyQTO.setSkuId(skuId);
					skuPropertyQTO.setSellerId(sellerId);
					skuPropertyQTO.setNeedPaging(true);
					// 计算总的条数，在skuPropertyQTO中返回
					skuPropertyManager.querySkuProperty(skuPropertyQTO);
					// 待删除的skuproperty的数量
					int totalCount = skuPropertyQTO.getTotalCount();
					if (totalCount > 0) {
						int number = skuPropertyManager.deleteSkuPropertyListBySkuId(skuId, sellerId);// 已经删除的skuproperty的数量
						if (number != totalCount) {
							throw ExceptionUtil
									.getException(ResCodeNum.SYS_E_DB_DELETE, "delete from sku_property error-->skuId id:"
											+ skuId + " sellerId:" + sellerId);
						}
					}
					itemSkuManager.deleteItemSku(skuId, sellerId);
					response = ResponseUtil.getSuccessResponse(true);
					return response;
				} catch (ItemException e) {
					status.setRollbackOnly();
					log.error(e.toString());
					return ResponseUtil.getErrorResponse(e.getResCodeNum(), e.getMessage());
				}
			}
		});
		return response;

	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_ITEM_SKU.getActionName();
	}
}
