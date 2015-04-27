package com.ve.tradecenter.core.dao;

import java.util.List;

import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.domain.OrderDO;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param orderDO
	 * @return
	 */
	public long addOrder(OrderDO orderDO);
	
	/**
	 * 取消订单
	 * @param orderQTO
	 * @return
	 */
	public int cancelOrder(OrderDO orderDO);
	
	/**
	 * 删除订单 （逻辑删除）
	 * 只有取消的订单才可以删除
	 */
	public int deleteOrder(OrderDO orderDO); 
	
	/**
	 * 根据订单ID和用户ID查询订单
	 * @param orderQTO
	 * @return
	 */
	public OrderDO getOrder(OrderDO orderDO);
	
	/**
	 * 更新订单的收货人信息
	 * @param orderDO
	 * @return
	 */
	public int updateConsigneeInfo(OrderDO orderDO);
	
	/**
	 * 更新订单备注
	 * @param orderDO
	 * @return
	 */
	public int updateOrderMemo(OrderDO orderDO);
	
	/**
	 * 顾客签收更改订单状态
	 * @param orderDO
	 * @return
	 */
	public int confirmArrival(OrderDO orderDO);
	
	/**
	 * 整单发货
	 * @param order
	 * @return
	 */
	public int deliveryGoods(OrderDO order);
	
	/**
	 * 查询有效订单
	 * @return
	 */
	public OrderDO getActiveOrder(OrderDO orderDO);
	
	/**
	 * 标志订单的支付状态为已成功
	 * @return
	 */
	public int orderPaySuccess(OrderDO orderDO);
	
	/**
	 * 结单 ，表示订单的生命周期结束不能再对订单做其他状态相关的操作
	 * @param order
	 * @return
	 */
	public int closeOrder(OrderDO orderDO);
	
	/**
	 * 顾客退货申请 更改售后状态
	 * @param orderDO
	 * @return
	 */
	public int returnApply(OrderDO orderDO);
	
	/**
	 * 审核用户退货申请 更改对应的状态标志
	 * @param orderDO
	 * @return
	 */
	public int auditReturnApply(OrderDO orderDO);
	
	/**
	 * 退款操作标记售后状态为--已退款
	 * @param orderDO
	 * @return
	 */
	public int refund(OrderDO orderDO);
	
	/**
	 * 复合条件查询订单
	 * @param orderQTO
	 * @return
	 */
	public List<OrderDO> queryUserOrders(OrderQTO orderQTO);

	/**
	 * 复合条件查询订单
	 * @param orderQTO
	 * @return
	 */
	public int getTotalCount(OrderQTO orderQTO);
	
	/** 
	public int closeOrder(OrderDO orderDO);
	/*public OrderDO readOrder(OrderDO orderDO)throws DAOException;
	
	public OrderDO deleteOrder(OrderDO orderDO)throws DAOException;
	
	public OrderDO findOrder(OrderDO orderDO)throws DAOException;*/
	
}
