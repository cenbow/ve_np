package com.ve.tradecenter.core.manager;

import java.sql.Date;

import com.ve.tradecenter.core.domain.OrderSeqDO;
import com.ve.tradecenter.core.exception.TradeException;

public interface OrderSeqManager {
	
	/**
	 * 更新订单一天的流水
	 * @return
	 * @throws TradeException
	 */
	public Integer updateOrderSeq()throws TradeException;
	
	/**
	 * 获取订单一天的流水
	 * @param date
	 * @return
	 * @throws TradeException
	 */
	public OrderSeqDO getOrderSeq()throws TradeException;
	
	/**
	 * 获取订单的一天的流水
	 * @param date
	 * @return
	 * @throws TradesException
	 */
	public OrderSeqDO addOrderSeq(OrderSeqDO orderSeqDO)throws TradeException;
	
	/**
	 * 生成订单编号
	 * @param source
	 * @return
	 */
	public String getOrderSn(int source)throws TradeException;
	
}
