package com.ve.tradecenter.core.service.action.order;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.manager.SellerOrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
/**
 * 更新备注信息
 * @author cwr
 */
public class UpdateOrderMemo implements Action{
	private static final Logger log = LoggerFactory.getLogger(UpdateOrderMemo.class);
	
	@Resource 
	private OrderManager orderManager;
	
	@Resource
	private SellerOrderManager sellerOrderManager;

	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		if(request.getParam("orderId") == null){
			log.error("orderId is null ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}else if(request.getParam("userId") == null){
			log.error("userId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}else if(request.getParam("newMemo")==null){
			log.error("newMemo is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"newMemo is null");
		}else if(request.getParam("memoType") == null){
			log.error("memoType is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"memoType is null");
		}
		
		long orderId = (Long) request.getParam("orderId");
		long userId = (Long) request.getParam("userId");
		String newMemo = (String) request.getParam("newMemo");
		int memoType = (Integer)request.getParam("memoType");
		
		OrderDO order = this.orderManager.getActiveOrder(orderId, userId);
		if(order == null){
			log.error("order doesn't exist orderId:" +orderId + " userId:" + userId );
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order doesn't exist");
		}
		
//		long supplierId = order.getSupplierId();
		int result =0,result2 = 0;
		Date now = new Date();
		try{
			//同步更新卖家和买家订单表
			// TODO 后续可能在支付成功后才拆单所以在未支付前不需要同步
			result = this.orderManager.updateOrderMemo(orderId, userId, newMemo, memoType,now);
//			result2 = this.sellerOrderManager.updateOrderMemo(orderId, supplierId, newMemo, memoType,now);
			
		}catch(TradeException e){
			log.error("db error : " + e);
			throw new TradeException(e.getResponseCode());
		}
		
		if(result > 0 && result2 > 0){
			response = ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("updated failed ");
			response = ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST);
		}
		return response;
	}
	
	@Override
	public String getName() {
		return ActionEnum.UPDATE_ORDER_MEMO.getActionName();
	}
}
