package com.ve.tradecenter.core.service.action.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.DeliveryNoticeDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.domain.DeliveryNoticeDO;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.domain.OrderItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.DeliveryNoticeManager;
import com.ve.tradecenter.core.manager.OrderItemManager;
import com.ve.tradecenter.core.manager.OrderLogManager;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.manager.SellerOrderManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

/**
 * 整单发货
 * @author cwr
 */
public class DeliveryGoods implements Action {
	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);
	
	@Resource 
	private DeliveryNoticeManager deliveryNoticeManager;
	
	@Resource
	private OrderManager orderManager;	
	
	@Resource
	private SellerOrderManager sellerOrderManager;

	@Resource
	private OrderItemManager orderItemManager;
	
	@Resource
	private OrderLogManager orderLogManager;
	
	public TradeResponse<Boolean> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<Boolean> response = null;
		if(request.getParam("deliveryNoticeDTO") == null){
			log.error("deliveryNoticeDTO is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"deliveryNoticeDTO is null");
		}
		
		DeliveryNoticeDTO deliveryNoticeDTO = (DeliveryNoticeDTO)request.getParam("deliveryNoticeDTO");
		
		// 字段验证
		String errorMsg = deliveryNoticeManager.validateFields(deliveryNoticeDTO);
		if(!StringUtils.isEmpty(errorMsg)){
			log.error(errorMsg);
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,errorMsg); 
		}
		
		long orderId = deliveryNoticeDTO.getOrderId();
		long userId = deliveryNoticeDTO.getUserId();
		String express = deliveryNoticeDTO.getExpress();
		String expressNo =deliveryNoticeDTO.getExpressNo();
		String memo = deliveryNoticeDTO.getMemo();
		String operator = deliveryNoticeDTO.getOperator(); 
		
		OrderDO order = this.orderManager.getActiveOrder(orderId, userId);
		if(order == null){
			log.error("order doesn't exist");
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST, "order doesn't exist");
		}
		long supplierId = order.getSupplierId();

		// 订单的商品明细
		List<OrderItemDO> allOrderItems = this.orderItemManager.getOrderItems(orderId, userId);
		
		// 已发货的商品明细
		List<OrderItemDTO> deliveriedItems = deliveryNoticeDTO.getOrderItems();
		
		Map<String,OrderItemDTO> orderItemMap = new HashMap<String,OrderItemDTO>();
		for(OrderItemDTO item : deliveriedItems){
			orderItemMap.put(item.getId() + "-" + userId,item);
		}
		
		boolean isPartialDelivery = false;
		Date now =new Date();
		int orderItemResult =0,orderResult =0,sellerOrderResult = 0;
		
		// 需要保存的临时存储  后续统一写入
		List<DeliveryNoticeDO> toSaveList =new ArrayList<DeliveryNoticeDO>();
		for(OrderItemDO orderItem : allOrderItems){
			long orderItemId = orderItem.getId();
			int orderItemNumber = orderItem.getNumber().intValue();
			
			// 如果该商品没有发货 
			if(orderItemMap.get(orderItemId + "-" + userId) == null){
				if(!isPartialDelivery){
					isPartialDelivery = true;
				}
			}else{
				OrderItemDTO deliveryItem = orderItemMap.get(orderItemId + "-" + userId);
				DeliveryNoticeDO notice = new DeliveryNoticeDO();
				int deliveryNumber = deliveryItem.getNumber();
				
				notice.setExpressNo(expressNo); // 快递单号
				notice.setDeliveryTime(now);
				notice.setIsArrival(false);
				notice.setExpress(deliveryNoticeDTO.getExpress()); // 快递公司
				notice.setOrderItemId(deliveryItem.getId()); // 订单明细id
				notice.setUserId(deliveryNoticeDTO.getUserId()); 
				notice.setUserName(deliveryNoticeDTO.getUserName());
				notice.setNumber(deliveryNumber);
				notice.setExpress(express);
				
				if(!isPartialDelivery){
					// 如果该商品的发货商品数量小于订单明细中的数量  则是部分发货
					if(deliveryNumber < orderItemNumber){ 
						isPartialDelivery = true;
					}
				}
				toSaveList.add(notice);
			}
		}
		
		for(DeliveryNoticeDO item :toSaveList){
			this.deliveryNoticeManager.addDeliveryNotice(item);
		}
		// 是否还需要更新订单明细表的发货状态
		//TODO
		
		// 区分是全部发货还是部分发货
		int orderDeliveryStatus = isPartialDelivery ? TradeConstants.DeliveryStatus.PARTIAL_DELIVERIED : TradeConstants.DeliveryStatus.DELIVERIED;
		// 同步操作买家和卖家订单表
		orderResult = this.orderManager.deliveryGoods(orderId, userId, orderDeliveryStatus, now);
		sellerOrderResult = this.sellerOrderManager.deliveryGoods(orderId, supplierId, orderDeliveryStatus, now);
		
		//TODO 日志完善
		String logMsg = TradeConstants.OrderLog.DELIVERIED + " " + express + " " + expressNo + " " + (memo==null ? "": memo);
//		this.orderLogManager.addOrderLog(logMsg, now, orderId, userId, operator);
		
		boolean module = (orderResult>0) && (sellerOrderResult>0); // 同时有更新了order表和selle_order
		if(module){
			response = ResponseUtils.getSuccessResponse(true);
		}else{
			log.error("updated failed");
			response = ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST);
		}
		return response;
	}

	@Override
	public String getName() {
		return ActionEnum.DELIVERY_GOODS.getActionName();
	}
	
}
