package com.ve.tradecenter.core.service.action.cart;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.CartDTO;
import com.ve.tradecenter.common.domain.FavorableInfoDTO;
import com.ve.tradecenter.common.domain.ItemSkuDTO;
import com.ve.tradecenter.common.domain.ItemSkuQTO;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.domain.CartItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.CartItemManager;
import com.ve.tradecenter.core.manager.ItemManager;
import com.ve.tradecenter.core.manager.PromotionManager;
import com.ve.tradecenter.core.manager.UserCartItemManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.TradeRequest;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;

public class QueryUserCartItems implements Action{
	private static final Logger log = LoggerFactory.getLogger(QueryUserCartItems.class);

	@Resource
	private UserCartItemManager userCartItemManager;
	
	@Resource
	private ItemManager itemManager;
	
	@Resource 
	private CartItemManager cartItemManager;
	
	@Resource
	private PromotionManager promotionManager;
	
	public TradeResponse<CartDTO> execute(RequestContext context){
		TradeRequest request = context.getRequest();
		TradeResponse<CartDTO> response = null;
		if(request.getParam("userId") == null){
			log.error("userId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}
		
		long userId= (Long)request.getParam("userId"); // 
		int source = request.getParam("source")==null ? TradeConstants.OrderSource.PC : (Integer)request.getParam("source");  // 渠道来源
		if(source != TradeConstants.OrderSource.ANDROID && source != TradeConstants.OrderSource.IOS && source!=TradeConstants.OrderSource.HTML5){
			source = TradeConstants.OrderSource.PC ; // 默认当做pc端处理
		}
		// 是不是pc渠道
		boolean isPc = source==TradeConstants.OrderSource.PC ? true : false; 
		List<CartItemDO> cartItems = null;
		List<ItemSkuDTO> itemSkuList = null;
		try{
			// 查询购物车表的商品列表
			cartItems = this.userCartItemManager.queryUserCartItems(userId);
			List<ItemSkuQTO> queryCondition = new ArrayList<ItemSkuQTO>();
			Map<Long,List<ItemSkuQTO>> supplierItemMap = new HashMap<Long,List<ItemSkuQTO>>();
			
			for(CartItemDO item : cartItems){
				ItemSkuQTO itemSkuQTO = new ItemSkuQTO();
				itemSkuQTO.setId(item.getItemSkuId()); 
				itemSkuQTO.setSupplierId(item.getSupplierId());
				//queryCondition.add(itemSkuQTO);
				
				if(supplierItemMap.get(item.getSupplierId()) != null){
					supplierItemMap.get(item.getSupplierId()).add(itemSkuQTO);
				}else{
					List<ItemSkuQTO> items = new ArrayList<ItemSkuQTO>();
					items.add(itemSkuQTO);
					supplierItemMap.put(item.getSupplierId(),items);
				}
			}
			
			// 去商品平台查询
			Iterator<Entry<Long,List<ItemSkuQTO>>> it = supplierItemMap.entrySet().iterator(); 
			while(it.hasNext()){
				Long supplierId = it.next().getKey();
				List<ItemSkuQTO> supplierItems = it.next().getValue();
				this.itemManager.getItemSkus(supplierItems, supplierId);
			}
			
			//itemSkuList = this.itemManager.getItemSkus(queryCondition);
		}catch(TradeException e){
			log.error("queryCartItems error: ",e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		
		/*
		 * 如果是有需要更新价格或是渠道的 则需要更新
		 */
		List<CartItemDO> toUpdateList = new ArrayList<CartItemDO>();
		boolean isChanged = false;
		Date now =new Date();
		for(CartItemDO cartItem : cartItems){
			isChanged = false;
			
			for(ItemSkuDTO itemSku : itemSkuList){
				System.out.println("itemSku: " + itemSku.getId() + " " + itemSku.getSupplierId());
				if(itemSku.getSupplierId().equals(cartItem.getSupplierId()) && itemSku.getId().equals(cartItem.getItemSkuId())){
					CartItemDO cartItem2 = null;
					if(cartItem.getSource() != null || cartItem.getSource() != source){ // 更新为本次的渠道
						isChanged = true;
						cartItem2 = new CartItemDO();
						cartItem2.setSource(source);
					}
					long sourcePrice = isPc ? itemSku.getCurrentPrice() : itemSku.getWirelessPrice(); // pc价格还是无线价格
					if(!cartItem.getUnitPrice().equals(sourcePrice)){ // 如果是跟当前的渠道价格不同
						if(!isChanged){
							isChanged = true;
							cartItem2 = new CartItemDO();
						}
						cartItem2.setUnitPrice(sourcePrice); // 更新为最新的渠道价格
						cartItem2.setTotalPrice(sourcePrice * cartItem.getNumber());
						cartItem2.setOriginPrice(itemSku.getOriginPrice());
						cartItem2.setSavePrice(itemSku.getOriginPrice() - itemSku.getCurrentPrice());
						cartItem2.setTotalSave(cartItem2.getSavePrice() * cartItem.getNumber());
					}
					if(isChanged){
						cartItem2.setGmtModified(now);
						cartItem2.setUserId(cartItem.getUserId());
						cartItem2.setId(cartItem.getId());
						toUpdateList.add(cartItem2);
					}
					break; 
				}
			}
		}
		//构造参数去查询促销平台
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
		
		// 根据商品列表、平台   去促销系统查询赠品  优惠金额  和是否包邮
		List<FavorableInfoDTO> activityList= null; // 促销活动列表
		
		try {
			activityList = this.promotionManager.getPromotionItems(promotionQueryList);
		} catch (TradeException e) {
			log.error("queryCartItems error: ",e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		
		CartDTO cartDTO = null;
		cartDTO = this.cartItemManager.handlePromotionInfo(activityList, cartItems);
		
		// 需要同时更新数据库
		/*try{
			if(toUpdateList != null && toUpdateList.size()!=0){
				System.out.println("updated: " + toUpdateList.size());
				for(CartItemDO cartItemDO : toUpdateList){
					this.userCartItemManager.updateUserCartItem(cartItemDO);
				}
			}
		}catch(TradeException e){
			log.error("db error :",e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}*/
		return ResponseUtils.getSuccessResponse(cartDTO);
	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_USER_CART_ITEMS.getActionName();
	}
}
