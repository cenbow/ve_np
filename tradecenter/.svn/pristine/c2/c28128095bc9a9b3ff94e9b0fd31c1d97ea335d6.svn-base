package com.ve.tradecenter.core.manager;

import java.util.List;

import com.ve.tradecenter.common.domain.ItemSkuDTO;
import com.ve.tradecenter.common.domain.ItemSkuQTO;
import com.ve.tradecenter.core.exception.TradeException;

public interface ItemManager {

	/**
	 * 获取商品信息--价格、名称等
	 * @param itemSkuId
	 * @return
	 */
	public ItemSkuDTO getItemSku(Long itemSkuId,Long supplierId)throws TradeException;
	
	/**
	 * 	
	 * @return
	 */
	public List<ItemSkuDTO> getItemSkus(List<ItemSkuQTO> itemSkus)throws TradeException;
	
	/**
	 * 
	 * @param items
	 * @param supplierId
	 * @return
	 * @throws TradeException
	 */
	public List<ItemSkuDTO> getItemSkus(List<ItemSkuQTO> items,Long supplierId)throws TradeException;
	
}
