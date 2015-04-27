package com.ve.tradecenter.core.manager.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.dao.OrderItemDao;
import com.ve.tradecenter.core.domain.OrderItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderItemManager;

public class OrderItemManagerImpl implements OrderItemManager {
	private static final Logger log = LoggerFactory.getLogger(OrderItemManagerImpl.class);

	@Resource 
	private OrderItemDao orderItemDao;
	
	@Override
	public long addOrderItem(OrderItemDO orderItem) throws TradeException{
		log.info("enter addOrderItem: " + "orderId :" + orderItem.getOrderId() + " orderSn: " + orderItem.getOrderSn());
		long result = 0;
		try {
			result = this.orderItemDao.addOrderItem(orderItem);
		} catch (DataAccessException e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e.getMessage());
		}
		log.info("exit addOrderItem result :  " + result);
		return result;
	}

	@Override
	public int deliveryOrderItem(long orderItemId,long userId) throws TradeException {
		log.info("enter deliveryOrderItem : ");
		int result = 0;
		OrderItemDO orderItem = new OrderItemDO();
		orderItem.setId(orderItemId);
		orderItem.setUserId(userId);
		
		try {
			result = this.orderItemDao.deliveryOrderItem(orderItem);
		} catch (DataAccessException e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e.getMessage());
		}
		
		log.info("exit deliveryOrderItem ,result :  " + result );
		return result;
	}
	
	@Override
	public List<OrderItemDO> getOrderItems(long orderId,long userId)throws TradeException{
		log.info("enter getOrderItems : " + orderId + " , " +userId);
		OrderItemDO orderItem = new OrderItemDO();
		orderItem.setOrderId(orderId);
		orderItem.setUserId(userId);
		List<OrderItemDO> result = null;
		try{
			result = this.orderItemDao.getOrderItems(orderItem);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit getOrderItems : " + result.size());
		return result ;
	}
	
	@Override
	public int updateItemReturnStatus(int returnStatus,long orderId,long orderItemId,long userId,Date now)throws TradeException{
		OrderItemDO orderItemDO = new OrderItemDO();
		orderItemDO.setOrderId(orderId);
		orderItemDO.setId(orderItemId);
		orderItemDO.setUserId(userId);
		orderItemDO.setGmtModified(now);
		
		int result = this.orderItemDao.updateItemReturnStatus(orderItemDO);
		return result;
	}
	
	/*
	@Override
	public int updateToSubOrder(long orderId ,long supplierId,long userId,long id)throws TradeException{
		log.info("enter updateToSubOrder: ");
		OrderItemDO orderItem = new OrderItemDO();
		orderItem.setOrderId(orderId);
		orderItem.setUserId(userId);
		orderItem.setId(id);
		
		return this.orderItemDao.updateItemReturnStatus(orderItem);
	}*/
	
}
