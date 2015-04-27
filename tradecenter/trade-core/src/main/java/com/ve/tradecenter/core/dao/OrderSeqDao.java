package com.ve.tradecenter.core.dao;


import java.sql.Date;

import com.ve.tradecenter.core.domain.OrderSeqDO;

/**
 * 定义订单流水表DAO接口
 * @author cwr
 */
public interface OrderSeqDao {
	
	public Integer updateOrderDaySeq(); 
	
	public OrderSeqDO getOrderDaySeq();
	
	public OrderSeqDO AddOrderDaySeq(OrderSeqDO orderSeqDO);
	
}
