package com.ve.tradecenter.core.service.action.order;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.DeliveryReturnDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.domain.DeliveryReturnDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.DeliveryReturnManager;
import com.ve.tradecenter.core.manager.OrderItemManager;
import com.ve.tradecenter.core.manager.OrderLogManager;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.manager.ReturnOrderItemManager;
import com.ve.tradecenter.core.manager.ReturnOrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

/**
 * 顾客写入单号退货
 * 
 * @author cwr
 */
public class ReturnGoods implements Action {

	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);
	
	@Resource
	private OrderManager orderManager;
	
	@Resource
	private OrderItemManager orderItemManager;
	
	@Resource
	private ReturnOrderItemManager returnOrderItemManager;
	
	@Resource
	private ReturnOrderManager returnOrderManager;
	
	@Resource
	private DeliveryReturnManager deliveryReturnManager;
	
	@Resource 
	private OrderLogManager orderLogManager;
	
	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		
		if(request.getParam("deliveryReturnDTO") == null){
			log.error("deliveryReturnDTO is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"deliveryReturnDTO is null");
		}
		
		DeliveryReturnDTO deliveryReturnDTO = (DeliveryReturnDTO)request.getParam("deliveryReturnDTO");
		
		String errorMsg = this.deliveryReturnManager.validateFields(deliveryReturnDTO);
		if(!StringUtils.isEmpty(errorMsg)){
			log.error(errorMsg);
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,errorMsg); 
		}
		
		long orderId = deliveryReturnDTO.getOrderId();
		long userId = deliveryReturnDTO.getUserId();
		String memo = deliveryReturnDTO.getMemo();
		String expressNo = deliveryReturnDTO.getExpressNo();
		String userName = deliveryReturnDTO.getUserName();
		int deliveryId = deliveryReturnDTO.getDeliveryId();
		String returnUser = deliveryReturnDTO.getReturnUser();
		String returnPhone = deliveryReturnDTO.getReturnPhone();
		String returnAddress = deliveryReturnDTO.getReturnAddress();
		
		List<OrderItemDTO> returnItems = deliveryReturnDTO.getReturnItems();
		
		Date now = new Date();
		int returnStatus = TradeConstants.ReturnStatus.RETURNING ; // 退货中  客户写入单号寄回
		if(returnItems== null || returnItems.size() == 0){
			log.error("returnItems is null ");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"returnItems is null"); 
		}
		int addResult = 0,updateResult=0,count=0;
		for(OrderItemDTO item : returnItems){
			count++;
			long itemId = item.getId();
			DeliveryReturnDO deliveryReturnDO = new DeliveryReturnDO();
			deliveryReturnDO.setExpressNo(expressNo);
			deliveryReturnDO.setDeliveryTime(now);
			deliveryReturnDO.setOrderId(orderId);
			deliveryReturnDO.setOrderItemId(itemId);
			deliveryReturnDO.setUserId(userId);
			deliveryReturnDO.setUserName(userName);
			deliveryReturnDO.setMemo(memo);
			deliveryReturnDO.setDeliveryId(deliveryId);
			deliveryReturnDO.setReturnUser(returnUser);
			deliveryReturnDO.setReturnPhone(returnPhone);
			deliveryReturnDO.setReturnAddress(returnAddress);
			
			long result = this.deliveryReturnManager.addDeliveryReturn(deliveryReturnDO);
			if(result > 0){
				addResult ++;
			}
			
			// 
			//int result2 = this.returnOrderManager.
			/*int result2 = this.orderItemManager.updateItemReturnStatus(returnStatus, orderId, itemId, userId,now);
			if(result2 > 0){
				updateResult++;
			}*/
		}
		
		// TODO
		//订单操作日志需要完善
		
		String operator= userId + ""; 
		String logInfo = TradeConstants.OrderLog.RETURN_GOODS; //顾客已退货
		
		// TODO 日志完善
//		this.orderLogManager.addOrderLog(logInfo, now, orderId, userId, operator);
		
		boolean module = (addResult == count ) && (updateResult == count);  // 添加和修改成功后才返回成功
		if(module){
			response = ResponseUtils.getSuccessResponse(module);
		}else{
			log.error("updated failed ");
			response = ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST);
		}
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.DELETE_ORDER.getActionName();
	}
}
