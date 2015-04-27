package com.ve.tradecenter.core.service.action.order;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.DeliveryNoticeManager;
import com.ve.tradecenter.core.manager.OrderLogManager;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

/**
 * 整单签收处理类
 * @author cwr
 */
public class ConfirmReceipt implements Action{

	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);
	
	@Resource 
	private DeliveryNoticeManager deliveryNoticeManager;
	
	@Resource
	private OrderManager orderManager;	

	@Resource
	private OrderLogManager orderLogManager;
	
	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		if(request.getParam("userId") == null){
			log.error("userId is missing ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is missing");
		}else if(request.getParam("orderId") == null){
			log.error("orderId is missing");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is missing");
		}
			
		long userId =(Long)request.getParam("userId");
		long orderId = (Long)request.getParam("orderId");
		
		// 按照整单发货 整单签收处理
		int result = 0,result2 = 0;
		try {
			// 更新配送单表的配送状态
			Date operateTime = new Date();
			boolean isArrival = true;  // 已经到达
			
			// 更新物流单的状态
			result = this.deliveryNoticeManager.confirmReceival(orderId,userId,isArrival,operateTime);
			
			// 更新订单主表的配送状态
			int deliveryStatus = TradeConstants.DeliveryStatus.ALL_RECEIVAL;  // 全部签收
			result2 = this.orderManager.confirmReceival(orderId, userId, deliveryStatus,operateTime);
			
			long result3 = this.orderLogManager.addOrderLog(TradeConstants.OrderLog.SIGN_OFF, operateTime, orderId,userId, userId+"");
		} catch (TradeException e) {
			log.error("db error： " + e);
			response = ResponseUtils.getFailResponse(e.getResponseCode());
		}
		if(result > 0 && result2> 0){
			response = ResponseUtils.getSuccessResponse(true);
		}else {
			log.error("updated failed");
			response = ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST);
		}
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_ORDER.getActionName();
	}
	
}
