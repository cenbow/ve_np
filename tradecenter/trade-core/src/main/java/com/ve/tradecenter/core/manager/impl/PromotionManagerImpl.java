package com.ve.tradecenter.core.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ve.tradecenter.common.domain.FavorableInfoDTO;
import com.ve.tradecenter.common.domain.ItemSkuQTO;
import com.ve.tradecenter.common.domain.MarketingActivityDTO;
import com.ve.tradecenter.common.domain.PromotionItemDTO;
import com.ve.tradecenter.core.domain.CartItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.PromotionManager;

public class PromotionManagerImpl implements PromotionManager{
	
	static Map<String,PromotionItemDTO> itemMap = new HashMap<String,PromotionItemDTO>();
	static Map<String,PromotionItemDTO> allItemMap = new HashMap<String,PromotionItemDTO>();

	{
		PromotionItemDTO item2 = new PromotionItemDTO();

		item2.setItemSkuId(111L);
		item2.setSupplierId(11L);
		item2.setItemId(11111L);
		item2.setIsGift(false);
		item2.setCurrentPrice(1099L);
		item2.setNumber(100);
		itemMap.put("111-11", item2);
		
		PromotionItemDTO item3 = new PromotionItemDTO();

		item3.setItemSkuId(121L);
		item3.setSupplierId(12L);
		item3.setItemId(22L);
		item3.setIsGift(false);
		item3.setCurrentPrice(1099L);
		item3.setNumber(10);
		itemMap.put("121-12", item3);
		
		PromotionItemDTO item4 = new PromotionItemDTO();

		item4.setItemSkuId(122L);
		item4.setSupplierId(12L);
		item4.setItemId(22L);
		item4.setIsGift(false);
		item4.setCurrentPrice(1099L);
		item4.setNumber(1);
		itemMap.put("122-12", item4);
		
		PromotionItemDTO item5 = new PromotionItemDTO();

		item5.setItemSkuId(131L);
		item5.setSupplierId(13L);
		item5.setItemId(23L);
		item5.setIsGift(false);
		item5.setCurrentPrice(8888L);
		item5.setNumber(2);
//		itemMap.put("131-13", item5);
		
		PromotionItemDTO giftItem = new PromotionItemDTO();
		giftItem.setItemSkuId(131L);
		giftItem.setSupplierId(13L);
		giftItem.setItemId(23L);
		giftItem.setIsGift(true);
		giftItem.setName("[赠品1]");
		giftItem.setCurrentPrice(0L);
		giftItem.setNumber(1);
		itemMap.put("131-13", giftItem);
		
		PromotionItemDTO giftItem2 = new PromotionItemDTO();
		giftItem2.setItemSkuId(141L);
		giftItem2.setSupplierId(14L);
		giftItem2.setItemId(24L);
		giftItem2.setIsGift(true);
		giftItem2.setName("[赠品2]");
		giftItem2.setCurrentPrice(1099L);
		giftItem2.setNumber(1);
		itemMap.put("141-14", giftItem2);
		
		allItemMap.put("111-21", item2);
		allItemMap.put("121-12", item3);
		allItemMap.put("121-12", item4);
		allItemMap.put("131-13", item5);
		
	}
	/*
	 * 测试数据
	 */
	/*static List<FavorableInfoDTO> list = new ArrayList<FavorableInfoDTO>();
	{
		FavorableInfoDTO favorableInfo = new FavorableInfoDTO();
		
		MarketingActivityDTO activity = new MarketingActivityDTO();
		activity.setIsCoupon(false);

		// 活动 一 赠品
		activity.setId(1001L);
		activity.setName("促销活动一");
		PromotionItemDTO giftItem = new PromotionItemDTO();
		giftItem.setItemSkuId(21L);
		giftItem.setSupplierId(12L);
		giftItem.setItemId(11111L);
		giftItem.setSupplierId(99999L);
		giftItem.setIsGift(true);
		giftItem.setName("[赠品1]");
		giftItem.setCurrentPrice(1099L);
		giftItem.setNumber(100);
		List giftList = new ArrayList<PromotionItemDTO>();
		giftList.add(giftItem);

		//
		PromotionItemDTO item2 = new PromotionItemDTO();

		item2.setItemSkuId(21L);
		item2.setSupplierId(11L);
		item2.setItemId(11111L);

		item2.setIsGift(false);
		item2.setCurrentPrice(1099L);
		item2.setNumber(100);

		List items = new ArrayList<PromotionItemDTO>();
		items.add(item2);

		favorableInfo.setActivity(activity);
		favorableInfo.setGiftList(giftList);
		favorableInfo.setItemList(items);

		favorableInfo.setOfferAmount(20);

		this.list.add(favorableInfo);
	}*/

	@Override
	public List<FavorableInfoDTO> getPromotionItems(List<ItemSkuQTO> itemSkuQTOList)
			throws TradeException {
		
		List<FavorableInfoDTO> result = new ArrayList<FavorableInfoDTO>();
		// 活动一
		FavorableInfoDTO favorableInfo = new FavorableInfoDTO();
		MarketingActivityDTO activity = new MarketingActivityDTO();
		
		activity.setId(1001L);
		activity.setName("春节大促 满200-10");
		activity.setIsCoupon(false);
		
		List giftList = new ArrayList<PromotionItemDTO>();
		List items = new ArrayList<PromotionItemDTO>();
		
		for(ItemSkuQTO item : itemSkuQTOList){
			PromotionItemDTO dto = itemMap.get(item.getId() + "-" + item.getSupplierId());
			if(dto != null){
				dto.setNumber(item.getNumber());
				items.add(dto);
			}
		}
		
		// 赠品
		giftList.add(itemMap.get("131-13"));
		
		favorableInfo.setActivity(activity);
		favorableInfo.setGiftList(giftList);
//		favorableInfo.setItemList(items);

		// 节省金额
		favorableInfo.setOfferAmount(10L);
		result.add(favorableInfo);
		
		
		// 活动一
				FavorableInfoDTO favorableInfo2 = new FavorableInfoDTO();
				MarketingActivityDTO activity2 = new MarketingActivityDTO();
				
				activity2.setId(1001L);
				activity2.setName("新春优惠券满300 - 50");
				activity2.setIsCoupon(true);
				
				List giftList2 = new ArrayList<PromotionItemDTO>();
				List items2 = new ArrayList<PromotionItemDTO>();
				
				for(ItemSkuQTO item2 : itemSkuQTOList){
					PromotionItemDTO dto2 = allItemMap.get(item2.getId() + "-" + item2.getSupplierId());
					if(dto2 != null){
						items2.add(dto2);
					}
				}
				
				favorableInfo2.setActivity(activity2);
				favorableInfo2.setGiftList(giftList2);
//				favorableInfo2.setItemList(items2);

				// 节省金额
				favorableInfo2.setOfferAmount(50L);
				result.add(favorableInfo2);
		
		return result;
		//TODO
		// 调用促销模块
		
	}
	
	/**
	 * 
	 * @param itemList
	 * @param userId
	 * @param couponId
	 * @return
	 * @throws TradeException
	 */
	@Override
	public List<FavorableInfoDTO> getPromotionItems(List<ItemSkuQTO> itemList,long userId,List<Long> couponId,int source)
			throws TradeException {
		
		List<FavorableInfoDTO> result = new ArrayList<FavorableInfoDTO>();
		// 活动一
		FavorableInfoDTO favorableInfo = new FavorableInfoDTO();
		MarketingActivityDTO activity = new MarketingActivityDTO();
		
		activity.setId(1001L);
		activity.setName("春节大促 满200-10");
		activity.setIsCoupon(false);
		
		List<PromotionItemDTO> giftList = new ArrayList<PromotionItemDTO>();
		List<PromotionItemDTO> items = new ArrayList<PromotionItemDTO>();
		
		for(ItemSkuQTO item : itemList){
			PromotionItemDTO dto = itemMap.get(item.getId() + "-" + item.getSupplierId());
			if(dto != null){
				dto.setNumber(item.getNumber());
				items.add(dto);
			}
		}
		
		// 赠品
		giftList.add(itemMap.get("131-13"));
		
		favorableInfo.setActivity(activity);
		favorableInfo.setGiftList(giftList);
		favorableInfo.setItemList(items);

		// 节省金额
		favorableInfo.setOfferAmount(10L);
		result.add(favorableInfo);
		
		
		// 活动一
				FavorableInfoDTO favorableInfo2 = new FavorableInfoDTO();
				MarketingActivityDTO activity2 = new MarketingActivityDTO();
				
				activity2.setId(1001L);
				activity2.setName("新春优惠券满300 - 50");
				activity2.setIsCoupon(true);
				
				List giftList2 = new ArrayList<PromotionItemDTO>();
				List items2 = new ArrayList<PromotionItemDTO>();
				
				for(ItemSkuQTO item2 : itemList){
					PromotionItemDTO dto2 = itemMap.get(item2.getId() + "-" + item2.getSupplierId());
					if(dto2 != null){
						items2.add(dto2);
					}
				}
				
				favorableInfo2.setActivity(activity2);
				favorableInfo2.setGiftList(giftList2);
				favorableInfo2.setItemList(items2);

				// 节省金额
				favorableInfo2.setOfferAmount(50L);
				result.add(favorableInfo2);
		
		return result;
		
		//TODO
		// 调用促销模块
		
	}

	
	@Override
	public List<ItemSkuQTO> getPromotionQueryCondition(List<CartItemDO> cartItems){
		List<ItemSkuQTO> promotionQueryList = new ArrayList<ItemSkuQTO>();
		
		for(CartItemDO item : cartItems){
			if(!item.getIsGift()){// 将已有的是礼品的排除在外
				ItemSkuQTO itemSkuQTO  = new ItemSkuQTO(); 
				itemSkuQTO.setNumber(item.getNumber()); //
				itemSkuQTO.setSupplierId(item.getSupplierId()); //
				itemSkuQTO.setId(item.getItemSkuId()); // 
				itemSkuQTO.setPrice(item.getUnitPrice()); //单价
				promotionQueryList.add(itemSkuQTO);
			}
		}
		return promotionQueryList;
	}
	
}
