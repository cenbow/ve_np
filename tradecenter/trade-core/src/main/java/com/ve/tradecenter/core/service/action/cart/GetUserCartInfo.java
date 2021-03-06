package com.ve.tradecenter.core.service.action.cart;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.CartDTO;
import com.ve.tradecenter.common.domain.CartItemDTO;
import com.ve.tradecenter.core.domain.CartItemDO;
import com.ve.tradecenter.core.manager.UserCartItemManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.TradeRequest;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.util.TradeUtils;

public class GetUserCartInfo implements Action{
	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);

	@Resource
	private UserCartItemManager userCartItemManager;
	
	@Override
	public TradeResponse<CartDTO> execute(RequestContext context){
		TradeRequest request = context.getRequest();
		TradeResponse<CartDTO> response;
		if(request.getParam("userId") == null){
			response = ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING);
			return response;
		}
		Long userId = (Long)request.getParam("userId");
		
		// 获取用户购物车的列表
		List<CartItemDO> cartItemList = null;
		try{
			cartItemList = this.userCartItemManager.queryUserCartItems(userId);
		}catch(Exception e){
			response = ResponseUtils.getFailResponse(ResponseCode.SYS_E_DATABASE_ERROR);
			log.error("db error " + e.getMessage());
			return response;
		}
		//计算总价格
		Long totalPrice = this.getCartTotalPrice(cartItemList);  
		//计算总优惠金额
		Long cartCoupon = this.getCartCoupon(cartItemList);
		//计算运费
		Long deliveryFee = this.getCartCoupon(cartItemList);
		//应付总额
		Long toPayMoney = (totalPrice - deliveryFee - cartCoupon);
		toPayMoney = toPayMoney < 0 ? 0: toPayMoney;
		
		List<CartItemDTO> cartItemDTOList = new ArrayList<CartItemDTO>();
		for(CartItemDO item : cartItemList){
			CartItemDTO cartItemDTO = new CartItemDTO();
			TradeUtils.convert2DTO(item, cartItemDTO);
			cartItemDTOList.add(cartItemDTO);
		}
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCartItems(cartItemDTOList);
		cartDTO.setTransportFee(deliveryFee);
		cartDTO.setPromotionSave(cartCoupon);
		cartDTO.setToPayMoney(toPayMoney);
		
		response = ResponseUtils.getSuccessResponse(cartDTO);
		return response;
	}

	@Override
	public String getName(){
		return ActionEnum.GET_USER_CART_INFO.getActionName();
	}
	
	/**
	 * 计算整个购物车的列表的商品价格
	 * @param cartItemDOList
	 * @return
	 */
	public Long getCartTotalPrice(List<CartItemDO> cartItemList){
		Long totalPrice = 0L;
		for(CartItemDO item : cartItemList){
			if(!item.getIsGift()){ // 如果是礼品则不计入价格
				if(item.getTotalPrice()>=0){
					totalPrice += item.getTotalPrice();
				}
			}
		}
		return totalPrice;
	}
	
	/**
	 * 根据item_sku_id列表调用营销平台，返回购物车总的优惠金额
	 * @param itemSkuList
	 * @return
	 */
	public Long getCartCoupon(List<CartItemDO> cartItemList){
		List<Long> cartItemSkuIdList = new ArrayList<Long>();
		for(CartItemDO item : cartItemList){
			if(!item.getIsGift()){ // 如果是礼品则不计入价格
				cartItemSkuIdList.add(item.getItemSkuId());
			}
		}
		//TODO
		/*
		 * 调用营销平台的优惠金额
		 */
		return 0L;
	}
	
	/**
	 * 查询物流平台运费
	 */
	public Long getCartDeliveryFee(List<Long> itemSkuIdList){
		//TODO
		/*
		 *调用物流平台运费计算 
		 */
		return 0L;
	}
}
