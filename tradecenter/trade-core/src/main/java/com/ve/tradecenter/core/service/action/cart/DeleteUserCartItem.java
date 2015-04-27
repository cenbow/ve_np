package com.ve.tradecenter.core.service.action.cart;

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
import com.ve.tradecenter.core.manager.UserCartItemManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.TradeRequest;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;

/**
 * 移除用户购物车商品处理类
 * @author cwr
 */
public class DeleteUserCartItem implements Action{
	private static final Logger log = LoggerFactory.getLogger(DeleteCartItem.class);

	@Resource
	private UserCartItemManager userCartItemManager;
	
	@Resource
	private PromotionManager promotionManager;
	
	@Resource
	private CartItemManager cartItemManager;

	@SuppressWarnings("unchecked")
	@Override
	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		TradeRequest request = context.getRequest();
		if(request.getParam("cartItemId") == null){
			log.error("cartItemId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"cartItemId is null");
		}else if(request.getParam("userId") == null){
			log.error("userId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}
		
		long id = (Long)request.getParam("cartItemId");
		long userId = (Long)request.getParam("userId");
		
		int result=0;
		CartItemDO cartItemDO = new CartItemDO();
		cartItemDO.setId(id);
		cartItemDO.setUserId(userId);
		
		try{
			// 先删除该购物车项
			result = userCartItemManager.deleteUserCartItem(cartItemDO);
		}catch(TradeException e){
			log.error("db error : ",e);
			return ResponseUtils.getFailResponse(ResponseCode.SYS_E_DATABASE_ERROR);
		}
		
		
		/*
		List<CartItemDO> cartItems = null;
		// 获取所有的购物项目
		cartItems = this.userCartItemManager.queryUserCartItems(userId);
		// 判断购物车是否已经有该商品
		CartDTO cartDTO = null;
		if(cartItems == null || cartItems.size()==0){
			cartDTO = new CartDTO(); // 返回属性值为空的对象
		}else{
			List<ItemSkuQTO> promotionQueryList = this.promotionManager.getPromotionQueryCondition(cartItems);
			// 根据商品列表、平台   去促销系统查询赠品  优惠金额  和是否包邮
			List<FavorableInfoDTO> activityList= null; // 促销活动列表
			activityList = this.promotionManager.getPromotionItems(promotionQueryList);
			cartDTO = this.cartItemManager.handlePromotionInfo(activityList, cartItems);
		}
		*/	
			
		if(result > 0){
			return ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("cartItem doesn't exist");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"cartItem doesn't exist");
		}
	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_USER_CART_ITEM.getActionName();
	}
}
