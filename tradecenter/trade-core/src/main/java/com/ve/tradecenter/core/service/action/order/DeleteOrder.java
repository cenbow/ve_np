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
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

/**
 * 根据订单ID删除订单处理类
 * @author cwr
 */
public class DeleteOrder implements Action{
	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);
	
	@Resource 
	private OrderManager orderManager;

	@Resource 
	private SellerOrderManager sellerOrderManager;
	
	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		if(request.getParam("userId") == null){
			log.error("userId is null ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}else if( request.getParam("orderId") == null){
			log.error("orderId is null ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}/*else if(request.getParam("supplierId") == null){
			log.error("supplierId is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"supplierId is null");
		}*/
		
		long userId =(Long)request.getParam("userId");
		long orderId = (Long)request.getParam("orderId");
//		long supplierId = (Long)request.getParam("supplierId");
		
		/*OrderDO order = this.orderManager.getActiveOrder(orderId, userId);
		if(order == null){
			log.error("order doesn't exist :  " + orderId+ " ," +userId);
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order doesn't exit");
		}*/
		int result = 0;
		Date now = new Date();
		try {
			// TODO 后续可能在支付后才来拆单  所以考虑不需要同步卖家订单
			result = this.orderManager.deleteOrder(orderId, userId,now);
			/*result2 = this.sellerOrderManager.deleteOrder(orderId, supplierId, now);*/
		} catch (Exception e) {
			log.error(e.getMessage());
			response = ResponseUtils.getFailResponse(ResponseCode.SYS_E_DATABASE_ERROR);
		}
		if(result > 0){
			return  ResponseUtils.getSuccessResponse(true);
		}else{
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"the order doesn't exist");
		}
	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_ORDER.getActionName();
	}
	
}
