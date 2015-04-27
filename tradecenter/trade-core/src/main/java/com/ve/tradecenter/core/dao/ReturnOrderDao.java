package com.ve.tradecenter.core.dao;

import com.ve.tradecenter.core.domain.ReturnOrderDO;

public interface ReturnOrderDao {
	
	/**
	 * 写入退货申请主表
	 * @param returnOrderDO
	 * @return
	 */
	public long addReturnOrder(ReturnOrderDO returnOrderDO);
	
	
}
