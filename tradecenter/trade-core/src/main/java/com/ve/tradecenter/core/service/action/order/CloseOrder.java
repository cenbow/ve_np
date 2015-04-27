package com.ve.tradecenter.core.service.action.order;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderLogManager;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.manager.SellerOrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

/**
 * 结单操作
 * @author cwr
 */
public class CloseOrder implements Action{

	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);
	
	@Resource
	private OrderManager orderManager;	

	@Resource
	private OrderLogManager orderLogManager;
	
	@Resource
	private SellerOrderManager sellerOrderManager;
	
	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		if(request.getParam("userId") == null ){
			log.error("userId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}else if(request.getParam("orderId") == null){
			log.error("orderId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}
		
		long orderId = (Long) request.getParam("orderId");
		long userId = (Long) request.getParam("userId");
		
		OrderDO order = this.orderManager.getActiveOrder(orderId, userId);
		if(order == null){
			log.error("order doesn't exist orderId:" +orderId + " userId:" + userId );
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order doesn't exist");
		}
		
		// 需要根据卖家id同步卖家订单表状态
		long supplierId = order.getSupplierId();
		
		int result =0,result2 = 0;
		Date now = new Date();
		try{
			// 同步操作卖家和买家订单
			int orderStatus = TradeConstants.OrderStatus.FINISHED;
			result = this.orderManager.closeOrder(orderId, userId,orderStatus,now);
			result2 = this.sellerOrderManager.closeOrder(orderId, supplierId,orderStatus,now);
			// TODO 日志完善
			
		}catch(TradeException e){
			log.error("db error: " , e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		if(result > 0 && result2 > 0){
			return ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("order doesn't exist");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order doesn't exist");
		}
	}

	@Override
	public String getName() {
		return ActionEnum.CLOSE_ORDER.getActionName();
	}
}

