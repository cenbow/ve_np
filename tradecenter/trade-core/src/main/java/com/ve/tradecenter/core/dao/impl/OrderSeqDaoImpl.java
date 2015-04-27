package com.ve.tradecenter.core.dao.impl;

import java.sql.Date;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.tradecenter.core.dao.OrderSeqDao;
import com.ve.tradecenter.core.domain.OrderSeqDO;

public class OrderSeqDaoImpl extends SqlMapClientDaoSupport implements OrderSeqDao {

	@Override
	public Integer updateOrderDaySeq() {
		return this.getSqlMapClientTemplate().update("order_seq.updateOrderSeq");
	}

	@Override
	public OrderSeqDO getOrderDaySeq() {
		return (OrderSeqDO)this.getSqlMapClientTemplate().queryForObject("order_seq.getOrderSeq");
	}

	@Override
	public OrderSeqDO AddOrderDaySeq(OrderSeqDO orderDaySeqDO){
		this.getSqlMapClientTemplate().insert("order_seq.addOrderSeq",orderDaySeqDO);
		return this.getOrderDaySeq();
	}
}
