package com.ve.tradecenter.core.manager.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.OrderDTO;
import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.dao.OrderDao;
import com.ve.tradecenter.core.dao.OrderLogDao;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.domain.OrderLogDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderManager;

public class OrderManagerImpl implements OrderManager{
	private static final Logger log = LoggerFactory.getLogger(OrderManagerImpl.class);
	
	@Resource
	private OrderDao orderDao;
	
	@Resource
	private OrderLogDao orderLogDao;
	
	@Override
	public long addOrder(OrderDO orderDO) throws TradeException {
		log.info("enter addOrder");
		long result= 0;
		try{
			result = (Long)this.orderDao.addOrder(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit addOrder: " + result);
		return result;
	}

	@Override
	public int cancelOrder(Long orderId ,Long userId,Date date) throws TradeException {
		log.info("enter cancelOrder: " + orderId + " , " + userId );
		OrderDO orderDO = new OrderDO();
		orderDO.setUserId(userId);
		orderDO.setId(orderId);
		orderDO.setGmtModified(date);
		int result = 0;
		try{
			result = orderDao.cancelOrder(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit cancelOrder updated ： " + result);
		return result ;
	}
	
	@Override
	public Integer deleteOrder(Long userId,Long orderId,Date operateTime)throws TradeException{
		log.info("enter deleteOrder: " + orderId + " , " + userId );
		OrderDO order = new OrderDO();
		
		order.setUserId(userId);
		order.setId(orderId);
		order.setGmtModified(operateTime);
		
		int result = 0;
		try{
			result = orderDao.deleteOrder(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit deleteOrder updated：" + result);
		return result ;

	}
	
	@Override
	public int updateConsigneeInfo(Long orderId,Long userId,String consignee,String phone,String address)throws TradeException{
		log.info("enter updateConsigneeInfo : "+ orderId + " , " + userId + " , "+ consignee + " , "+phone+ " , "+address);
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setUserId(userId);
		orderDO.setConsignee(consignee);
		orderDO.setMobile(phone);
		orderDO.setAddress(address);
		int result = 0;
		try{
			result = (int)this.orderDao.updateConsigneeInfo(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit updateConsigneeInfo updated :  " + result);
		return result;
	}
		
	@Override
	public int updateOrderMemo(Long orderId,Long userId,String newMemo,Integer memoType,Date date)throws TradeException{
		log.info("enter updateOrderMemo :" + orderId + " , " + userId + " , " + newMemo + " , " + memoType);
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setUserId(userId);
		orderDO.setGmtModified(date);
		if(newMemo == null || memoType == null){
			throw new TradeException(ResponseCode.PARAM_E_PARAM_MISSING,"memoType or memoType is null");
		}
		if(memoType == 1){
			orderDO.setUserMemo(newMemo);
		}else if(memoType == 2){
			orderDO.setSellerMemo(newMemo);
		}else if(memoType == 3){
			orderDO.setAdminMemo(newMemo);
		}else{
			throw new TradeException(ResponseCode.PARAM_E_PARAM_INVALID,"memoType is invalid");
		}
		int result = 0;
		try{
			result = this.orderDao.updateOrderMemo(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit updateOrderMemo updated: " + result);
		return result;
	}
	
	@Override
	public List<OrderDO> queryUserOrders(OrderQTO orderQTO)throws TradeException{
		if(orderQTO.getUserId() == null){// 需要根据买家id进行分表查询
			throw new TradeException(ResponseCode.PARAM_E_PARAM_MISSING,"orderQTO.userId is null");
		}
		log.info("enter queryUserOrders,userId : " + orderQTO.getUserId());
		List<OrderDO> result=null;
		try{
			result = (List<OrderDO>)this.orderDao.queryUserOrders(orderQTO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit queryUserOrders result size : " + (result==null? null :result.size()));
		return result;
	}
	
	@Override
	public int getTotalCount(OrderQTO orderQTO)throws TradeException{
		log.info("enter getSellerTotalCount:  " + orderQTO);
		int result = 0;
		try{
			result = this.orderDao.getTotalCount(orderQTO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit getTotalCount: " + result);
		return result;
	}
	
	@Override
	public long addOrderLog(OrderLogDO orderLogDO)throws TradeException{
		log.info("enter addOrderLog : " + orderLogDO.getLogInfo());
		long id ;
		try{
			id = this.orderLogDao.addOrderLog(orderLogDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit addOrderLog  id: " + id);
		return id;
	}
	
	@Override
	public int confirmReceival(long orderId,long userId,int deliveryStatus,Date operateTime)throws TradeException{
		log.info("enter confirmArrival" +orderId + " , " + userId + " , " + deliveryStatus + " , " + operateTime );
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setUserId(userId);
		orderDO.setDeliveryStatus(deliveryStatus);
		orderDO.setGmtModified(operateTime);
		
		int result = 0;
		try{
			result = this.orderDao.confirmArrival(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit confirmArrival updated : " + result);
		return result;
	}
	
	@Override
	public int deliveryGoods(long orderId,long userId,int deliveryStatus,Date date) throws TradeException{
		log.info("enter deliveryGoods: " + orderId + "," + userId + "," +  deliveryStatus);
		int result = 0;
		OrderDO order = new OrderDO();
		
		order.setDeliveryStatus(deliveryStatus);
		order.setId(orderId);
		order.setUserId(userId);
		order.setGmtModified(date);
		
		try{
			result = this.orderDao.deliveryGoods(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit deliveryGoods , updated  " + result);
		return result ;
	}

	@Override
	public OrderDO getActiveOrder(Long orderId ,Long userId) throws TradeException {
		log.info("enter getActiveOrder: " + orderId + " ," + userId);
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setUserId(userId);
		OrderDO order;
		try{
			order = (OrderDO) this.orderDao.getActiveOrder(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit getActiveOrder : " + (order));
		return order;
	}

	@Override
	public OrderDO getOrder(long orderId ,Long userId)throws TradeException{
		log.info("enter getOrder : " +orderId + "," + userId);
		OrderDO order = new OrderDO();
		order.setId(orderId);
		order.setUserId(userId);
		try{
			order = this.orderDao.getOrder(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit getOrder: " + order);
		return order;
	}
	
	@Override
	public int orderPaySuccess(int payStatus,Long orderId,Long userId)throws TradeException{
		log.info("enter orderPaySuccess :" + orderId + " , " + userId);
		int result = 0;
		OrderDO order= new OrderDO();
		order.setPayStatus(payStatus);
		order.setId(orderId);
		order.setUserId(userId);
		try{
			result = this.orderDao.orderPaySuccess(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit orderPaySuccess ,updated: " + result);
		return result ;
	}

	@Override
	public int closeOrder(Long orderId ,Long userId,int orderStatus,Date operateTime)throws TradeException{
		log.info("enter closeOrder : " + orderId + " ," + userId);
		int result =0;
		OrderDO order= new OrderDO();
		
		order.setId(orderId);
		order.setUserId(userId);
		order.setOrderStatus(orderStatus);
		order.setGmtModified(operateTime);
		
		try{
			result = this.orderDao.closeOrder(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit closeOrder , updated : " + result);
		return result;
	}
	
	@Override
	public int applyReturn(long orderId,long userId,int afterSale,Date date)throws TradeException{
		log.info("enter returnApply :" + orderId + "," + userId);
		int result=0;
		OrderDO order = new OrderDO();
		order.setId(orderId);
		order.setUserId(userId);
		order.setAfterSale(afterSale);
		order.setGmtModified(date);
		try{
			result = this.orderDao.returnApply(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit returnApply ,updated : " + result);
		return result;
	}
	
	@Override
	public int auditReturnApply(long orderId,long userId,int afterSale,Date date)throws TradeException{
		log.info("enter auditReturnApply: " + orderId + " ," + userId + " ," + afterSale);
		int result = 0;
		OrderDO order = new OrderDO();
		/*if(auditResult != 0 && auditResult != 1){
			throw new TradeException(ResponseCode.PARAM_E_PARAM_INVALID,"auditResult is invalid");
		}
		if(auditResult == 0){ // 退货申请不通过
			order.setAfterSale(TradeConstants.AfterSale.RETURN_REFUSE);
		}else if(auditResult == 1){ // 退货申请通过
			order.setAfterSale(TradeConstants.AfterSale.RETURN_AGREE);
		}*/
		
		order.setId(orderId);
		order.setUserId(userId);
		order.setAfterSale(afterSale);
		order.setGmtModified(date);
		
		try{
			result = this.orderDao.auditReturnApply(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit auditReturnApply,updated :" +result);
		return result;
	}
	
	@Override
	public int refund(Long orderId,Long userId,int afterSale,Date date)throws TradeException{
		log.info("enter returnFund: " + orderId + " ," + userId);
		int result = 0;
		OrderDO order= new OrderDO();
		order.setId(orderId);
		order.setUserId(userId);
		order.setAfterSale(afterSale);
		order.setGmtModified(date);
		
		try{
			result = this.orderDao.refund(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit refund,updated:  "+ result );
		return result;
	} 
	
	@Override
	public String validateFields4Add(OrderDTO orderDTO){
		if(orderDTO.getUserId() == null){
			return "userId is null";
		}else if(orderDTO.getAddressId() == null){
			return "addressId is null";
		}else if(orderDTO.getPaymentId() ==null ){
			return "paymentId is null";  
		}else if(orderDTO.getOrderItems() == null){ 
			return "orderItems is null";
		}else if(orderDTO.getOrderItems().size() == 0){
			return "orderItems is empty";
		}else if(orderDTO.getNumber() == null){
			return "number is null";
		}else if(orderDTO.getNumber() <= 0){
			return "number must be greater than 0";
		}
		return null;
	}
	
}
