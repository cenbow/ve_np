package com.ve.tradecenter.core.manager;

import com.ve.tradecenter.core.domain.ReturnOrderItemDO;
import com.ve.tradecenter.core.exception.TradeException;

public interface ReturnOrderItemManager {

	/**
	 * 写入退货申请单明细
	 * @param returnOrderItem
	 * @throws TradeException
	 */
	public long addReturnOrderItem(ReturnOrderItemDO returnOrderItem)throws TradeException;
	
	/**
	 * 更新退货商品的退货状态
	 * @return
	 */
	/*public int updateOrderReturnItem(ReturnOrderItemDO returnOrderItem);*/
	
}
