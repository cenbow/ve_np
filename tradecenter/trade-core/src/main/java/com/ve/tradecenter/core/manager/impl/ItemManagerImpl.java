package com.ve.tradecenter.core.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ve.tradecenter.common.domain.ItemSkuDTO;
import com.ve.tradecenter.common.domain.ItemSkuQTO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.ItemManager;

public class ItemManagerImpl implements ItemManager {
	
	static Map<String,ItemSkuDTO> map = new HashMap<String,ItemSkuDTO>();
	static{
		/*
		 * 测试数据
		 */
		Date now = new Date();
		ItemSkuDTO item = new ItemSkuDTO();
		item.setId(111L);
		item.setSupplierId(11L);
		item.setItemId(21L);
		
		item.setMinBuyAmount(1);
		item.setMaxBuyAmount(10);
		item.setItemName("华为手机");
		
		item.setSupplierType(2);
		item.setStartTime(new Date(now.getTime() - 7L*24*3600*1000));
		item.setEndTime(new Date(now.getTime() + 2L*24*3600*1000));
		item.setWirelessPrice(50L);
		item.setCurrentPrice(69L);
		item.setOriginPrice(88L);
		item.setIsGift(false);
		map.put("111-11", item);
		
		
		ItemSkuDTO item2 = new ItemSkuDTO();
		item2.setId(121L);
		item2.setSupplierId(12L);
		item.setSupplierType(3);
		item2.setItemId(22L);
		
		item2.setMinBuyAmount(1);
		item2.setMaxBuyAmount(10);
		item2.setItemName("魅族手机");
		
		item2.setStartTime(new Date(now.getTime() - 7L*24*3600*1000));
		item2.setEndTime(new Date(now.getTime() + 3L*24*3600*1000));
		item2.setWirelessPrice(28L);
		item2.setCurrentPrice(30L);
		item2.setOriginPrice(50L);
		item2.setIsGift(false);
		map.put("121-12", item2);
		
		
		ItemSkuDTO item3 = new ItemSkuDTO();
		item3.setId(122L);
		item3.setSupplierId(12L);
		item.setSupplierType(1);
		item3.setItemId(22L);
		
		item3.setMinBuyAmount(1);
		item3.setMaxBuyAmount(10);
		item3.setItemName("魅族pro手机");
		
		item3.setStartTime(new Date(now.getTime() - 7L*24*3600*1000));
		item3.setEndTime(new Date(now.getTime() + 3L*24*3600*1000));
		item3.setWirelessPrice(999L);
		item3.setCurrentPrice(1522L);
		item3.setOriginPrice(1888L);
		item3.setIsGift(false);
		map.put("122-12", item2);
		
		ItemSkuDTO item4 = new ItemSkuDTO();
		item4.setId(131L);
		item4.setSupplierId(13L);
		item.setSupplierType(2);
		item4.setItemId(23L);
		
		item4.setMinBuyAmount(1);
		item4.setMaxBuyAmount(10);
		item4.setItemName("sumsang 手机");
		
		item4.setStartTime(new Date(now.getTime() - 7L*24*3600*1000));
		item4.setEndTime(new Date(now.getTime() + 10L*24*3600*1000));
		item4.setWirelessPrice(4999L);
		item4.setCurrentPrice(5999L);
		item4.setOriginPrice(6999L);
		item4.setIsGift(false);
		map.put("131-13", item4);
		
		ItemSkuDTO item5 = new ItemSkuDTO();
		item5.setId(141L);
		item5.setSupplierId(14L);
		item5.setSupplierType(2);
		item5.setItemId(23L);
		
		item5.setMinBuyAmount(1);
		item5.setMaxBuyAmount(10);
		item5.setItemName("sumsang 手机");
		
		item5.setStartTime(new Date(now.getTime() - 7L*24*3600*1000));
		item5.setEndTime(new Date(now.getTime() + 10L*24*3600*1000));
		item5.setWirelessPrice(4999L);
		item5.setCurrentPrice(5999L);
		item5.setOriginPrice(6999L);
		item5.setIsGift(false);
		map.put("141-14", item5);
		
	}
	
	@Override
	public ItemSkuDTO getItemSku(Long itemSkuId, Long supplierId)
			throws TradeException {
		return map.get(itemSkuId + "-" + supplierId);
	}

	@Override
	public List<ItemSkuDTO> getItemSkus(List<ItemSkuQTO> itemSkus)
			throws TradeException {
		
		// TODO 待完善 
		
		// 测试数据
		
		List<ItemSkuDTO> result = new ArrayList<ItemSkuDTO>();
		for(ItemSkuQTO itemSku : itemSkus){
			if(map.get(itemSku.getId() + "-" + itemSku.getSupplierId()) != null){
				result.add(this.map.get(itemSku.getId() + "-" + itemSku.getSupplierId()));
			}
		}
		return  result;
	}
	
	@Override
	public List<ItemSkuDTO> getItemSkus(List<ItemSkuQTO> items,Long supplierId)throws TradeException{
		List<ItemSkuDTO> result = new ArrayList<ItemSkuDTO>();
		for(ItemSkuQTO itemSku : items){
			if(map.get(itemSku.getId() + "-" + itemSku.getSupplierId()) != null){
				ItemSkuDTO item = this.map.get(itemSku.getId() + "-" + itemSku.getSupplierId());
				item.setSupplierId(supplierId); 
				result.add(item);
			}
		}
		return  result;
	}

}
