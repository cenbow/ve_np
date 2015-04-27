package com.ve.tradecenter.core.service.action.cart;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
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
 * 同步购物车
 * @author cwr
 */
public class SyncUserCart implements Action{
	private static final Logger log = LoggerFactory.getLogger(SyncUserCart.class);

	/*
	 * 未登入用户购物车处理类
	 */
	@Resource
	private CartItemManager cartItemManager;
	
	/*
	 * 已登入用户购物车处理类
	 */
	@Resource
	private UserCartItemManager userCartItemManager;
	
	/* 
	 * 促销模块接口处理类
	 */
	@Resource
	private PromotionManager promotionManager;
	
	@Override
	public TradeResponse<Boolean> execute(RequestContext context){
		TradeRequest request = context.getRequest();
		TradeResponse<Boolean> response = null;
		if(request.getParam("userId")==null ){
			log.error("userId is missing: " );
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}else if(request.getParam("sessionId") == null){
			log.error("sessionId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"sessionId is null");
		}
		
		String sessionId = (String)request.getParam("sessionId");
		Long userId = (Long)request.getParam("userId");
		List<CartItemDO> toSaveCartItem = new ArrayList<CartItemDO>();
		List<CartItemDO> cartItems,userCartItems;
		int count = 0,result =0; // 统计更新的次数
		try{
			//根据sessionId查出未登入用户的购物车项
			cartItems = this.cartItemManager.queryCartItems(sessionId);
			
			//根据userId查出用户购物车中的商品
			userCartItems = this.userCartItemManager.queryUserCartItems(userId);
			
			/*
			 * 需要将未登入购物车的商品同步到已登入用户购物车中
			 * 有重复的需要合并  
			 */
			for(CartItemDO cartItem: cartItems){
				if(cartItem.getIsGift()!=null && !cartItem.getIsGift()){ // 非礼品才需要同步
					boolean exist = false;
					for(CartItemDO userCartItem : userCartItems){
						// 商品id和供应商id都相同
						if(userCartItem.getSupplierId().equals(cartItem.getSupplierId()) && userCartItem.getItemSkuId().equals(cartItem.getItemSkuId())){
							count++;
							exist = true; // 标记存在
							userCartItem.setNumber(userCartItem.getNumber() + cartItem.getNumber()); //数目累加
							Long unitPrice = cartItem.getUnitPrice();	// 合并购物车时候价格以未登入的渠道为准    更新到已登入用户的购物车价格
							Long originPrice = cartItem.getOriginPrice(); 
							userCartItem.setUnitPrice(unitPrice); 
							userCartItem.setTotalPrice(unitPrice * userCartItem.getNumber());
							userCartItem.setOriginPrice(originPrice);
							Long savePrice = (originPrice - unitPrice)<0? 0 : (originPrice -unitPrice) ; // 防止小于0
							userCartItem.setSavePrice(savePrice);
							userCartItem.setTotalSave(savePrice * userCartItem.getNumber());
								
							int updateResult = this.userCartItemManager.updateUserCartItem(userCartItem);
							if(updateResult > 0){
								result++;
							}
							System.out.println("updateResult : " + updateResult);
							break;  // 跳出里层的循环
						}
					}
					if(!exist){ // 如果用户的购物车没有则新加入
						count++;
						cartItem.setId(null); //清空主键 由ibatis框架指定生成策略
						cartItem.setUserId(userId);
						cartItem.setSessionId(sessionId);
						Long addResult = this.userCartItemManager.addUserCartItem(cartItem);
						System.out.println("addResult: "+ addResult);
						if(addResult > 0){
							result++;
						}
					}
				}
			}
		}catch(TradeException e){
			log.error("db error:" ,e);
			return ResponseUtils.getFailResponse(ResponseCode.SYS_E_DATABASE_ERROR);
		}
		
		if(result == count){
			return ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("sync failed ");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST);
		}
	}

	@Override
	public String getName() {
		return ActionEnum.SYNC_USER_CART.getActionName();
	}
}
