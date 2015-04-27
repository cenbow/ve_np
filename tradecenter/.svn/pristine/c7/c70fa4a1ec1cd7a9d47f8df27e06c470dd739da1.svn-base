package com.ve.tradecenter.core.manager.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.dao.SellerOrderDao;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.SellerOrderManager;

public class SellerOrderManagerImpl implements SellerOrderManager {
	private static final Logger log = LoggerFactory.getLogger(SellerOrderManagerImpl.class);

	@Resource
	private SellerOrderDao sellerOrderDao;

	@Override
	public long addOrder(OrderDO orderDO) throws TradeException {
		log.info("enter addSellerOrder,id: " + orderDO.getId());
		long id=0;
		try {
			id = this.sellerOrderDao.addOrder(orderDO);
		} catch (Exception e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit addSellerOrder: "  + id);
		return id;
	}

	@Override
	public int cancelOrder(Long orderId, Long supplierId, Date date)
			throws TradeException {
		log.info("enter cancelSellerOrder: " + orderId +  "," + supplierId + "," +date);
		OrderDO order = new OrderDO();
		order.setId(orderId);
		order.setSupplierId(supplierId);
		order.setGmtModified(date);
		int result;
		try {
			result = this.sellerOrderDao.cancelOrder(order);
		} catch (Exception e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit cancelSellerOrder: " + result);
		return result;
	}

	@Override
	public int deleteOrder(Long orderId, Long supplierId, Date date)
			throws TradeException {
		log.info("enter deleteSellerOrder: " + orderId  + "," + supplierId + "," +date);
		OrderDO order = new OrderDO();
		order.setId(orderId);
		order.setSupplierId(supplierId);
		order.setGmtModified(date);
		int result;
		try {
			result = this.sellerOrderDao.deleteOrder(order);
		} catch (Exception e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit deleteSellerOrder: " + result);
		return result;
	}

	@Override
	public OrderDO getOrder(Long orderId, Long supplierId) throws TradeException {
		log.info("enter getSellerOrder : " +  orderId + " ," + supplierId);
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setSupplierId(supplierId);
		orderDO = this.sellerOrderDao.getOrder(orderDO);
		return orderDO;
	}
	
	@Override
	public int getTotalCount(OrderQTO orderQTO){
		log.info("enter getSellerTotalCount:  " + orderQTO);
		int result = this.sellerOrderDao.getTotalCount(orderQTO);
		log.info("exit getTotalCount: " + result);
		return result;
	}
	
	@Override
	public List<OrderDO> querySellerOrder(OrderQTO orderQTO)throws TradeException{
		log.info("enter querySellerOrder: " + orderQTO);
		List<OrderDO> result = this.sellerOrderDao.querySellerOrders(orderQTO);
		log.info("exit querySellerOrder,result: " + result.size());
		return result;
	}
	
	@Override
	public int closeOrder(Long orderId,Long supplierId,int orderStatus,Date date)throws TradeException{
		log.info("enter closeSellerOrder: " + orderId + "," + supplierId);
		
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setSupplierId(supplierId);
		orderDO.setOrderStatus(orderStatus);
		orderDO.setGmtModified(date);
		
		int result;
		try {
			result = this.sellerOrderDao.closeOrder(orderDO);
		} catch (Exception e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit closeSellerOrder updated : " + result);
		return result;
	}

	@Override
	public int refund(Long orderId, Long supplierId,int afterSale,Date date) throws TradeException {
		log.info("enter refund: " + orderId + "," + supplierId);
		OrderDO orderDO = new OrderDO();
		
		orderDO.setId(orderId);
		orderDO.setSupplierId(supplierId);
		orderDO.setAfterSale(afterSale);
		orderDO.setGmtCreated(date);
		
		int result = 0;
		try {
			result = this.sellerOrderDao.refund(orderDO);
		} catch (Exception e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("enter refund, updated : " + result);
		return result;
	}
	
	@Override
	public int updateConsigneeInfo(Long orderId,Long supplierId,String consignee,String phone,String address)throws TradeException{
		log.info("enter updateConsigneeInfo : "+ orderId + " , " + supplierId + " , "+ consignee + " , "+phone+ " , "+address);
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setSupplierId(supplierId);// 卖家维度更新
		orderDO.setConsignee(consignee);
		orderDO.setMobile(phone);
		orderDO.setAddress(address);
		int result = 0;
		try{
			result = (int)this.sellerOrderDao.updateConsigneeInfo(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit updateConsigneeInfo updated :  " + result);
		return result;
	}
	
	@Override
	public int updateOrderMemo(Long orderId,Long supplierId,String newMemo,Integer memoType,Date date)throws TradeException{
		log.info("enter updateOrderMemo :" + orderId + " , " + supplierId + " , " + newMemo + " , " + memoType);
		OrderDO orderDO = new OrderDO();
		orderDO.setId(orderId);
		orderDO.setSupplierId(supplierId);
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
			result = this.sellerOrderDao.updateOrderMemo(orderDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit updateOrderMemo updated: " + result);
		return result;
	}
	
	@Override
	public int applyReturn(long orderId ,long supplierId,int afterSale, Date date)throws TradeException{
		int result = 0;
		log.info("enter  applyReturn " + orderId + "," + supplierId);
		OrderDO order =new OrderDO();
		
		order.setId(orderId);
		order.setSupplierId(supplierId);
		order.setAfterSale(afterSale);
		order.setGmtModified(date);
		
		result = this.sellerOrderDao.applyReturn(order);
		log.info("exit applyReturn,updated:" + result);
		return result;
	}
	
	@Override
	public int auditReturnApply(long orderId,long supplierId,int auditResult,Date date)throws TradeException{
		int result =0;
		log.info("enter auditReturnApply: " + orderId + "," + supplierId + "," + auditResult);

		OrderDO order = new OrderDO();
		order.setAfterSale(auditResult); //审核退货申请
		order.setSupplierId(supplierId);
		order.setId(orderId);
		order.setGmtCreated(date);
		
		result = this.sellerOrderDao.auditReturnApply(order);
		log.info("exit auditReturnApply,updated :" + result);
		return result;
	}

	@Override
	public int deliveryGoods(long orderId,long supplierId,int deliveryStatus,Date date) throws TradeException{
		log.info("enter sellerDeliveryGoods: " + orderId + "," + supplierId + "," +  deliveryStatus);
		int result = 0;
		OrderDO order = new OrderDO();
		
		order.setDeliveryStatus(deliveryStatus);
		order.setId(orderId);
		order.setSupplierId(supplierId);
		order.setGmtModified(date);
		
		try{
			result = this.sellerOrderDao.deliveryGoods(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit deliveryGoods , updated  " + result);
		return result ;
	}

	@Override
	public int OrderPaySuccess(int payStatus,long orderId,long supplierId)throws TradeException{
		log.info("enter orderPaySuccess :" + orderId + " , " + supplierId);
		int result = 0;
		OrderDO order= new OrderDO();
		order.setPayStatus(payStatus);
		order.setId(orderId);
		order.setSupplierId(supplierId);
		try{
			result = this.sellerOrderDao.orderPaySuccess(order);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit orderPaySuccess ,updated: " + result);
		return result ;
	}
	
}
