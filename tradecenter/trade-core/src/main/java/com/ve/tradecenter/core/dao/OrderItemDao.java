package com.ve.tradecenter.core.dao;

import java.util.List;

import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.domain.OrderItemDO;

public interface OrderItemDao {
	
	/**
	 * 写入订单明细
	 * @param orderItem
	 * @return
	 */
	public long addOrderItem(OrderItemDO orderItem);
	
	/**
	 * 更新订单明细状态为已发货
	 * @param orderItem
	 * @return
	 */
	public int deliveryOrderItem(OrderItemDO orderItem);
	
	/**
	 * 根据orderId和userId查询订单明细
	 * @param orderQTO
	 * @return
	 */
	public List<OrderItemDO> getOrderItems(OrderItemDO orderItem);
	
	/**
	 * 跟新订单明细的退货状态
	 * @param orderItem
	 * @return
	 */
	public int updateItemReturnStatus(OrderItemDO orderItem);

}
