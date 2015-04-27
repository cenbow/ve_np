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
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.manager.SellerOrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;

/** 
 * 取消订单处理类
 * @author cwr
 */
public class CancelOrder implements Action { 
	private static final Logger log = LoggerFactory.getLogger(CancelOrder.class);
	
	@Resource 
	private OrderManager orderManager;
	
	@Resource
	private SellerOrderManager sellerOrderManager;

	public com.ve.tradecenter.common.api.TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		
		if(request.getParam("userId") == null ){
			log.error("userId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}else if(request.getParam("orderId") == null){
			log.error("orderId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}
		
		// orderId也就是卖家表的订单id
		long orderId = (Long) request.getParam("orderId");
		long userId = (Long) request.getParam("userId");
		
		OrderDO order = this.orderManager.getActiveOrder(orderId, userId);
		if(order == null){
			log.error("order doesn't exist orderId:" +orderId + " userId:" + userId );
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order doesn't exist");
		}
		
		// 需要根据卖家id同步卖家订单表状态
//		long supplierId = order.getSupplierId();
				// 只有未支付的订单才可以取消
		if(order.getPayStatus() !=null && order.getPayStatus() != TradeConstants.PaymentStatus.UNPAID){
			log.error("order paid cannot be canceled");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ORDER_STATUS_ERROR,"paid order cannot be canceled");
		}
		int result =0,result2 = 0;
		Date now = new Date();
		try{
			//TODO 后续可能在支付后才来拆单  所以考虑不需要同步卖家订单
			result = this.orderManager.cancelOrder(orderId, userId,now);
//			result2 = this.sellerOrderManager.cancelOrder(orderId, supplierId, now);
		}catch(TradeException e){
			log.error("db error: " + e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		if(result > 0){
			return ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("order doesn't exist");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order doesn't exist");
		}
	}
	
	@Override
	public String getName() {
		return ActionEnum.CANCEL_ORDER.getActionName();
	}
}
