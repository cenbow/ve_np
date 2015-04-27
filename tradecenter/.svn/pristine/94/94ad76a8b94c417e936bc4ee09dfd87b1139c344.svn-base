package com.ve.tradecenter.core.service.action.cart;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionTemplate;

import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.CartDTO;
import com.ve.tradecenter.common.domain.CartItemDTO;
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
/**
 * 未登入用户添加购物车 
 * 1 根据商品id和供应商id查询商品平台获取最新的价格、名称等信息
 * 2 查询所有的购物车商品 ，判断是否有重复 （重复则更新为最新的价格、数目累加）,不重复则新加入
 * 3 根据所有的商品列表促销平台查询优惠信息（是否包邮、优惠金额、赠品）
 * 4 返回邮费、优惠、赠品给调用方 
 * @author cwr
 */
public class AddUserCartItem implements Action {
	private static final Logger log = LoggerFactory.getLogger(AddUserCartItem.class);
	
	private static final int CART_MAX_NUMER = 20;
	
	@Resource
	private TransactionTemplate transactionTemplate;

	@Resource
	private UserCartItemManager userCartItemManager;
	
	@Resource
	private CartItemManager cartItemManager;
	
	@Resource
	private ItemManager itemManager;
	
	@Resource 
	private PromotionManager promotionManager;

	@SuppressWarnings("unchecked")
	@Override
	public TradeResponse<Boolean> execute(RequestContext context){
		TradeRequest request = context.getRequest();
		TradeResponse<CartDTO> response;
		if(request.getParam("cartItemDTO") == null){
			log.error("cartItemDTO is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"cartItemDTO is null");
		}
		CartItemDTO cartItemDTO = (CartItemDTO)request.getParam("cartItemDTO");
		
		// 字段验证
		String errorMsg = this.userCartItemManager.validateCartItemFields4Add(cartItemDTO);
		if(!StringUtils.isEmpty(errorMsg)){
			log.error(errorMsg);
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,errorMsg);
		}
		
		// 必要的字段
		long itemSkuId = cartItemDTO.getItemSkuId().longValue();
		long supplierId = cartItemDTO.getSupplierId().longValue();
		long userId = cartItemDTO.getUserId().longValue(); 
		int number  = cartItemDTO.getNumber().intValue();
		String sessionId = cartItemDTO.getSessionId();
		int source = cartItemDTO.getSource()==null? TradeConstants.OrderSource.PC : cartItemDTO.getSource(); // 默认来自于pc端 	
		boolean isWireless = source!=TradeConstants.OrderSource.PC ? true : false; // 判断是不是无线来源， 需要享受专享价
		
		// 商品平台查询商品详细信息(最新的价格等)
		ItemSkuDTO itemSku = null;
		try{
			itemSku = getItemSku(itemSkuId, supplierId);
			if(itemSku == null){
				log.error("itemSku doesn't exist : itemSkuId:  "+ itemSkuId + ", supplierId: " + supplierId);
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"itemSku doesn't exist ");
			}
		}catch(TradeException e){
			log.error("getItemSku error",e);
			return ResponseUtils.getFailResponse(ResponseCode.SYS_E_REMOTE_CALL_ERROR);
		}
		
		long result = 0;
		List<CartItemDO> cartItems = null; // 数据库购物车的商品的列表
		CartDTO cartDTO = null;
		
		try{
			// 获取已有的购物车列表
			cartItems = this.userCartItemManager.queryUserCartItems(userId);
			int cartSize = cartItems==null ? 0:cartItems.size(); 

			// 判断购物车是否已经有该商品
			int index = -1;
			CartItemDO existingCartItem = null ;
			for(int i =0,len=cartItems.size() ;i<len;i++){
				CartItemDO item = cartItems.get(i);
				if(!item.getIsGift() && item.getItemSkuId().equals(itemSkuId)  && item.getSupplierId().equals(supplierId) ){
					existingCartItem = item;
					index = i;
				}
			}
			if(index > -1){ // 如果是新加入需要判断是不是超过了购物车的最大限制
				if(cartSize == CART_MAX_NUMER){
					log.error("exceed the cart max limitation: " + cartSize);
					return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_CART_MAX_LIMITATION);
				}
			}
			
			Date now = new Date();
			// 拼接购物车商品参数
			CartItemDO newCartItem = new CartItemDO();
			//newCartItem.setName(itemSku.getName()); // 商品名称
			newCartItem.setItemSkuId(itemSkuId); // sku的Id
			newCartItem.setSupplierId(supplierId); // 供应商id
			newCartItem.setUserId(userId); // 未登入时候无用户id
			newCartItem.setItemId(itemSku.getItemId());
			newCartItem.setSubName(itemSku.getItemName()); // 
			newCartItem.setSessionId(sessionId); 
			newCartItem.setOriginPrice(itemSku.getOriginPrice()); // 市场价
			if(isWireless){ //如果是无线端  取无线价格 
				if(itemSku.getWirelessPrice() != null){
					newCartItem.setUnitPrice(itemSku.getWirelessPrice());
				}else{
					newCartItem.setUnitPrice(itemSku.getCurrentPrice()); 
				}
			}else{
				newCartItem.setUnitPrice(itemSku.getCurrentPrice());
			}
			newCartItem.setNumber(number);
			newCartItem.setTotalPrice(newCartItem.getUnitPrice() * number);
			long savePrice = newCartItem.getUnitPrice()-newCartItem.getOriginPrice();
			if(savePrice < 0){
				savePrice =0; //防止小于0
			}
			newCartItem.setSavePrice(savePrice);
			newCartItem.setTotalSave(savePrice * number);
			newCartItem.setIsGift(false); // 都不是礼品
			newCartItem.setSource(source);  
			
			newCartItem.setGmtModified(now);
			newCartItem.setGmtCreated(now);
			
			if(index > -1){  // 如果新添加的商品已经在购物车存在    则更新购物车该商品数量
				int totalNumber = existingCartItem.getNumber() + number;
				newCartItem.setId(existingCartItem.getId()); // id赋值用于更新条件
				newCartItem.setNumber(totalNumber);
				newCartItem.setTotalPrice(totalNumber * newCartItem.getUnitPrice());
				newCartItem.setTotalSave(savePrice * totalNumber);
				result = this.userCartItemManager.updateUserCartItem(newCartItem); // 更新数量和总价
				//cartItems.set(index, newCartItem);  // 
			}else{
				result = userCartItemManager.addUserCartItem(newCartItem); //如果数据库不存在 则新写入
				//cartItems.add(newCartItem);
			}
			
			/*List<ItemSkuQTO> promotionQueryList = new ArrayList<ItemSkuQTO>();
			for(CartItemDO item : cartItems){
				if(item!= null && !item.getIsGift()){// 根据商品id去促销平台查询
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
			activityList = this.promotionManager.getPromotionItems(promotionQueryList);
			
			cartDTO = this.cartItemManager.handlePromotionInfo(activityList, cartItems);
			*/
			
		}catch(TradeException e){
			log.error("db error: ",e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		
		if(result == 0){
			return ResponseUtils.getSuccessResponse(true);
		}else{
			return ResponseUtils.getSuccessResponse(false);
		}
	}

	@Override
	public String getName() {
		return ActionEnum.ADD_USER_CART_ITEM.getActionName();
	}
	
	/**
	 * 查询商品平台获取商品的价格等信息
	 * @param itemSkuId
	 * @param supplierID
	 * @return
	 */
	private ItemSkuDTO getItemSku(Long itemSkuId,Long supplierId)throws TradeException{
		/*
		 * 测试数据
		 */
		return this.itemManager.getItemSku(itemSkuId, supplierId);
	}
}	
