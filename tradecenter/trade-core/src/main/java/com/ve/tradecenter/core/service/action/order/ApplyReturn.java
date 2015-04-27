package com.ve.tradecenter.core.service.action.order;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.ReturnOrderDTO;
import com.ve.tradecenter.common.domain.ReturnOrderItemDTO;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.domain.OrderItemDO;
import com.ve.tradecenter.core.domain.ReturnOrderDO;
import com.ve.tradecenter.core.domain.ReturnOrderItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderItemManager;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.manager.ReturnOrderItemManager;
import com.ve.tradecenter.core.manager.ReturnOrderManager;
import com.ve.tradecenter.core.manager.SellerOrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;

/**
 * 顾客申请退货--支付部分退货
 * 
 * 超过默认的订单到期时间(14天)不能申请退货
 * 
 * @author cwr
 */
public class ApplyReturn implements Action{
	private static final Logger log = LoggerFactory.getLogger(ApplyReturn.class);
	
	private static final int DEFUALT_TIMEOUT_DAYS = 14 ;
	
	@Resource
	private OrderManager orderManager;
	
	@Resource 
	private SellerOrderManager sellerOrderManager;
	
	@Resource
	private OrderItemManager orderItemManager;
	
	@Resource
	private ReturnOrderManager returnOrderManager;
	
	@Resource
	private ReturnOrderItemManager returnOrderItemManager;
	
	public TradeResponse<Boolean> execute(RequestContext context){
		
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		
		/*if(request.getParam("orderId") == null){
			log.error("orderId is null");
			response = ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderId is null");
		}else if(request.getParam("userId") == null){
			log.error("alipaymentDTO is null");
			return  ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"userId is null");
		}*/
		if(request.getParam("returnOrderDTO") == null){
			log.error("returnOrderDTO is null");
			return  ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"returnOrderDTO is null");
		}
		
		ReturnOrderDTO returnOrderDTO = (ReturnOrderDTO)request.getParam("returnOrderDTO");
		
		String errorMsg = this.returnOrderManager.validateFields4Add(returnOrderDTO);
		if(!StringUtils.isEmpty(errorMsg)){
			log.error(errorMsg);
			return  ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,errorMsg);
		}
		
		long orderId = returnOrderDTO.getOrderId();
		long userId = returnOrderDTO.getUserId();
		List<ReturnOrderItemDTO>  returnItems = returnOrderDTO.getReturnItems(); // 退货申请商品明细
		
		OrderDO order =null;
		try{
			order = this.orderManager.getActiveOrder(orderId, userId);
			if(order == null){
				log.error("order is null");
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"order not exist");
			}
		}catch(TradeException e){
			log.error("db error:" + e);
			return ResponseUtils.getFailResponse(ResponseCode.SYS_E_DATABASE_ERROR);
		}
		
		// 如果是订单已经结单 无法申请退货
		if(order.getOrderStatus() != null && order.getOrderStatus().intValue() == TradeConstants.OrderStatus.FINISHED){
			log.error("order already closed");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ORDER_STATUS_ERROR,"order closed,cannot apply return");
		}
		
		long supplierId = order.getSupplierId(); // 供应商id
		String orderSn = order.getOrderSn();  // 原始订单号
		
		// TODO 
		// 如果是订单已经超期14天则无法退货   发货时间判断还是下单时间判断
	
		int result = 0,result2= 0;
		Date now =new Date();
		// 如果订单超时不能申请退货
		if(now.getTime() > (order.getGmtCreated().getTime() + DEFUALT_TIMEOUT_DAYS * 24 * 3600 * 1000)){
			log.error("order timeout :" + orderId + "," + supplierId);
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ORDER_TIMEOUT);
		}
		
		// 已经进入售后程序不能再申请
		if(order.getAfterSale() != null && (order.getAfterSale() >= TradeConstants.AfterSale.RETURN_APPLY)){
			log.error("aftersale already in process");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ORDER_AFTERSALE);
		}
		
		try{
			// 查询原订单明细价格  用于计算退款金额
			List<OrderItemDO> orderItems = this.orderItemManager.getOrderItems(orderId, userId);
			
			if(orderItems == null || orderItems.size() == 0){
				log.error("orderItems doesn't exist");
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"orderItems doesn't exist");
			}
			List<ReturnOrderItemDO> toSaveList = new ArrayList<ReturnOrderItemDO>();
			
			long itemsReturnMoney = 0L,totalReturnMoney = 0L; // 总的退款金额为单品的退款金额累加
			for(OrderItemDO item : orderItems){
				for(ReturnOrderItemDTO item2 : returnItems){
					if(item.getItemSkuId().equals(item2.getItemSkuId())){
						//由于允许部分退货
						int number = item2.getNumber()>item.getNumber() ? item.getNumber(): item2.getNumber();
						itemsReturnMoney = item.getReturnMoney()*(number/item.getNumber()); // 单品的退款金额
						totalReturnMoney += itemsReturnMoney; // 累加为整个退款单的退款金额 
						
						ReturnOrderItemDO returnItem = new ReturnOrderItemDO();
						returnItem.setSupplierId(supplierId);
						returnItem.setGmtCreated(now);
						returnItem.setGmtModified(now);
						returnItem.setIsReturned(false); 
						returnItem.setItemName(item.getItemName());
						returnItem.setItemSkuId(item2.getItemSkuId());
						returnItem.setNumber(number);
						returnItem.setReturnMoney(itemsReturnMoney); // 该商品的退款金额
						returnItem.setIsDelete(false);
						returnItem.setReturnDesc(item2.getReturnDesc());
						returnItem.setReturnReason(item2.getReturnReason());
						returnItem.setReturnAttach(item2.getReturnAttach());
					
						toSaveList.add(returnItem);
					}
				}
			}
			
			// 退货申请单主表
			ReturnOrderDO returnOrder = new ReturnOrderDO();
			returnOrder.setOrderId(orderId);
			returnOrder.setUserId(userId);
			returnOrder.setGmtCreated(now);
			returnOrder.setGmtModified(now); 
			returnOrder.setIsDelete(false); 
			returnOrder.setReturnMoney(totalReturnMoney); // 单品的退款金额
			returnOrder.setOrderSn(order.getOrderSn()); // 原始订单号	
			returnOrder.setReturnStatus(TradeConstants.AfterSale.RETURN_APPLY); // 退款申请状态
			// 写入退货申请表
			long returnOrderId = this.returnOrderManager.addReturnOrder(returnOrder);
			
			// 写入退货申请单明细表  关联主表
			for(ReturnOrderItemDO returnOrderItem : toSaveList){
				returnOrderItem.setReturnOrderId(returnOrderId);
				long returnOrderItemId = this.returnOrderItemManager.addReturnOrderItem(returnOrderItem);
			}
			
			// 同步操作卖家和买家订单表状态
			int afterSale = TradeConstants.AfterSale.RETURN_APPLY;
			result = this.orderManager.applyReturn(orderId, userId,afterSale, now);
			result2 = this.sellerOrderManager.applyReturn(orderId, supplierId, afterSale,now);
			
		}catch(TradeException e){
			log.error("db operation error : " + e);
			return ResponseUtils.getFailResponse(e.getResponseCode());
		}
		
		if(result > 0 && result2 > 0){
			response = ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("applyReturn failed,record doesn't exist");
			response = ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST, "order doesn't exist");
		}
		return response;
	}
	
	@Override
	public String getName() {
		return ActionEnum.APPLY_RETURN.getActionName();
	}
}
