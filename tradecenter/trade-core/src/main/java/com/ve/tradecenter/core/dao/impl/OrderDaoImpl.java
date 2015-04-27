package com.ve.tradecenter.core.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.dao.OrderDao;
import com.ve.tradecenter.core.domain.OrderDO;

public class OrderDaoImpl extends SqlMapClientDaoSupport implements OrderDao{
	
	@Override
	public long addOrder(OrderDO orderDO){
		long id = (Long)this.getSqlMapClientTemplate().insert("user_order.addOrder",orderDO);
		return id;
//		return (OrderDO)this.getSqlMapClientTemplate().queryForObject("user_order.getOrder",order);
	}
	
	@Override
	public int cancelOrder(OrderDO orderQTO){
		return (int)this.getSqlMapClientTemplate().update("user_order.cancelOrder",orderQTO);
	}
	
	@Override
	public int deleteOrder(OrderDO orderQTO){
		return (int)this.getSqlMapClientTemplate().update("user_order.deleteOrder",orderQTO);
	}
	
	@Override
	public OrderDO getOrder(OrderDO orderQTO){
		return (OrderDO)this.getSqlMapClientTemplate().queryForObject("user_order.getOrder",orderQTO);
	}
	
	@Override
	public int updateConsigneeInfo(OrderDO orderDO){
		return (int)this.getSqlMapClientTemplate().update("user_order.updateConsigneeInfo",orderDO);
	}
	
	@Override
	public int updateOrderMemo(OrderDO orderDO){
		return this.getSqlMapClientTemplate().update("user_order.updateOrderMemo",orderDO);
	}
	
	@Override
	public List<OrderDO> queryUserOrders(OrderQTO orderQTO){
		return (List<OrderDO>)this.getSqlMapClientTemplate().queryForList("user_order.queryUserOrders",orderQTO);
	}
	
	@Override
	public int confirmArrival(OrderDO orderDO){
		return this.getSqlMapClientTemplate().update("user_order.confirmArrival",orderDO);
	}

	@Override
	public int deliveryGoods(OrderDO order){
		return this.getSqlMapClientTemplate().update("user_order.deliveryGoods",order);
	}

	@Override
	public OrderDO getActiveOrder(OrderDO orderDO) {
		return (OrderDO)this.getSqlMapClientTemplate().queryForObject("user_order.getActiveOrder",orderDO);
	}
	
	@Override
	public int orderPaySuccess(OrderDO orderDO){
		return this.getSqlMapClientTemplate().update("user_order.orderPaySuccess",orderDO);
	}
	
	@Override
	public int closeOrder(OrderDO orderDO){
		return this.getSqlMapClientTemplate().update("user_order.closeOrder",orderDO);
	}
	
	@Override
	public int returnApply(OrderDO orderDO){
		return this.getSqlMapClientTemplate().update("user_order.applyReturn",orderDO);
	}

	@Override
	public int auditReturnApply(OrderDO orderDO){
		return this.getSqlMapClientTemplate().update("user_order.auditReturnApply",orderDO);
	}

	@Override
	public int refund(OrderDO orderDO){
		return this.getSqlMapClientTemplate().update("user_order.refund",orderDO);
	}

	@Override
	public int getTotalCount(OrderQTO orderQTO) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("user_order.getTotalCount",orderQTO);
	}
	
}
