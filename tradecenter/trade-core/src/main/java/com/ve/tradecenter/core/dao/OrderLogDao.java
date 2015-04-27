package com.ve.tradecenter.core.dao;

import java.util.List;

import com.ve.tradecenter.core.domain.OrderLogDO;

public interface OrderLogDao {
	/**
	 * 写入订单操作日志
	 * @param orderLogDO
	 * @return
	 */
	public long addOrderLog(OrderLogDO orderLogDO);
	
	/**
	 * 根据订单id和用户id查询订单的操作日志供用户查看 需要过滤部分不对用户显示的信息
	 * @param orderLogDO
	 * @return
	 */
	public List<OrderLogDO> getUserOrderLog(OrderLogDO orderLogDO);
	
}
