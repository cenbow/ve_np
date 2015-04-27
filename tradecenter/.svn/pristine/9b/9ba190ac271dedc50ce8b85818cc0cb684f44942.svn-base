package com.ve.tradecenter.core.manager;

import com.ve.tradecenter.common.domain.ReturnOrderDTO;
import com.ve.tradecenter.core.domain.ReturnOrderDO;
import com.ve.tradecenter.core.exception.TradeException;


public interface ReturnOrderManager {
	
	/**
	 * 生成退货申请单
	 * @return
	 */
	public long addReturnOrder(ReturnOrderDO returnOrder)throws TradeException;
	
	/**
	 * 字段验证
	 * @param returnOrderDTO
	 * @return
	 */
	public String validateFields4Add(ReturnOrderDTO returnOrderDTO);
	
}
