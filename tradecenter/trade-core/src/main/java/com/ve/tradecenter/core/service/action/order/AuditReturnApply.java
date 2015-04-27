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
 * 审核用户退货申请
 * @author cwr
 */
public class AuditReturnApply implements Action {
	private static final Logger log = LoggerFactory.getLogger(ApplyReturn.class);
	
	@Resource
	private OrderManager orderManager;
	
	@Resource 
	private SellerOrderManager sellerOrderManager;
	
	@SuppressWarnings("unchecked")
	public TradeResponse<Boolean> execute(RequestContext context){
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		
		if(request.getParam("orderId") == null){
			log.error("orderId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}else if(request.getParam("userId") == null){
			log.error("userId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}else if(request.getParam("auditResult") == null){
			log.error("auditResult is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"auditResult is null");
		}
		
		// 必要的字段
		long orderId = (Long)request.getParam("orderId");
		long userId = (Long)request.getParam("userId");
		int auditResult = (Integer)request.getParam("auditResult"); // 审核结果 0：审核不通过  1: 审核通过
		String memo = (String)request.getParam("memo");

		OrderDO order = null;
		try{
			order = this.orderManager.getActiveOrder(orderId, userId);
		}catch(TradeException e){
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		
		if(order ==null){
			log.error("order doesn't exist");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order not exist");
		}
		
		long supplierId = order.getSupplierId();
		
		// 如果不是待审核状态 则提示状态错误-- 只有待审核状态才可以审核
		if(order.getAfterSale() != TradeConstants.AfterSale.RETURN_APPLY){
			log.error("aftersale status error");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ORDER_STATUS_ERROR);
		}
		
		int result = 0,result2=0;
		Date now =new Date();
		try{
			int afterSale = auditResult == 1 ? TradeConstants.AfterSale.RETURN_AGREE : TradeConstants.AfterSale.RETURN_REFUSE;
			
			// 同步操作卖家和买家订单
			result = this.orderManager.auditReturnApply(orderId, userId, afterSale, now);
			result2 = this.sellerOrderManager.auditReturnApply(orderId, supplierId, afterSale,now);
			
			// TODO 订单日志完善 
			
		}catch(TradeException e){
			log.error("db error : " + e);
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
		return ActionEnum.AUDIT_RETURN_APPLY.getActionName();
	}
	
}
