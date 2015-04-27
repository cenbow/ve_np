package com.ve.tradecenter.core.service.action.cart;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.CartDTO;
import com.ve.tradecenter.common.domain.FavorableInfoDTO;
import com.ve.tradecenter.common.domain.ItemSkuQTO;
import com.ve.tradecenter.core.domain.CartItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.CartItemManager;
import com.ve.tradecenter.core.manager.PromotionManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.TradeRequest;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;

public class UpdateCartItem implements Action {
	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);

	@Resource
	private CartItemManager cartItemManager;
	
	@Resource
	private PromotionManager promotionManager;
	

	@Override
	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		TradeRequest request = context.getRequest();
		TradeResponse<Boolean> response = null;
		if(request.getParam("cartItemId") == null){
			log.error("cartItemId is null");
			return response = ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"cartItemId is null");
		}else if(request.getParam("number") == null){
			log.error("number is null");
			return response = ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"number is null");
		}else if(request.getParam("sessionId") == null){
			log.error("sessionId is null");
			return response = ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"sessionId is null");
		}
		
		long id = (Long)request.getParam("cartItemId");
		int number = (Integer)request.getParam("number");
		String sessionId = (String)request.getParam("sessionId");
		
		Date now = new Date();
		CartItemDO cartItemDO = new CartItemDO();
		cartItemDO.setId(id);
		cartItemDO.setNumber(number);
		cartItemDO.setGmtModified(now);
		
		int result =0;
		try{
			result = this.cartItemManager.updateCartItemNumber(cartItemDO);
		}catch(TradeException e){
			log.error("db error : " ,e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		
		List<CartItemDO> cartItems = null;
		// 获取所有的购物项目
		cartItems = this.cartItemManager.queryCartItems(sessionId);
		
		// 判断购物车是否已经有该商品
		/*CartDTO cartDTO = null;
		if(cartItems == null || cartItems.size()==0){
			cartDTO = new CartDTO(); // 返回属性值为空的对象
		}else{
			List<ItemSkuQTO> promotionQueryList = this.promotionManager.getPromotionQueryCondition(cartItems);
			// 根据商品列表、平台   去促销系统查询赠品  优惠金额  和是否包邮
			List<FavorableInfoDTO> activityList= null; // 促销活动列表
			activityList = this.promotionManager.getPromotionItems(promotionQueryList);
			cartDTO = this.cartItemManager.handlePromotionInfo(activityList, cartItems);
		}*/
		
		if(result > 0){
			response = ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("cartItem doesn't exist");
			response = ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"cartItem doesn't exist");
		}
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.UPDATE_CART_ITEM.getActionName();
	}
	
}
