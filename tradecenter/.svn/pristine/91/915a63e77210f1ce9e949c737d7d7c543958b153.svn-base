package com.ve.tradecenter.core.manager.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.core.dao.ReturnOrderItemDao;
import com.ve.tradecenter.core.domain.ReturnOrderItemDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.ReturnOrderItemManager;

public class ReturnOrderItemManagerImpl implements ReturnOrderItemManager {
	private static final Logger log = LoggerFactory.getLogger(OrderManagerImpl.class);
	
	@Resource
	private ReturnOrderItemDao returnOrderItemDao;
	
	@Override
	public long addReturnOrderItem(ReturnOrderItemDO returnOrderItem)
		throws TradeException {
		long result = 0;
		result = this.returnOrderItemDao.addReturnOrderItemDao(returnOrderItem);
		return result;
	}

	/*@Override
	public int updateOrderReturnItem(ReturnOrderItemDO returnOrderItem) {
		int result = 0;
		log.info("enter updateOrderReturnItem : ");
		result = this.returnOrderItemDao.up
	}*/

	
}
