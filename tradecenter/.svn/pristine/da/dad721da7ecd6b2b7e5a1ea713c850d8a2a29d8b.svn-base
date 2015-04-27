package com.ve.tradecenter.core.manager.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.ReturnOrderDTO;
import com.ve.tradecenter.core.dao.ReturnOrderDao;
import com.ve.tradecenter.core.domain.ReturnOrderDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.ReturnOrderManager;

public class ReturnOrderManagerImpl implements ReturnOrderManager{
	private static final Logger log = LoggerFactory.getLogger(ReturnOrderManagerImpl.class);

	@Resource
	private ReturnOrderDao returnOrderDao;
	
	@Override
	public long addReturnOrder(ReturnOrderDO returnOrder) throws TradeException{
		log.info("enter addReturnOrder");
		long result = 0;
		try {
			result = this.returnOrderDao.addReturnOrder(returnOrder);
		} catch (Exception e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit addReturnOrder");
		return result;
	}

	@Override
	public String validateFields4Add(ReturnOrderDTO returnOrderDTO) {
		// TODO Auto-generated method stub
		if(returnOrderDTO.getUserId() == null){
			return "userId is null";
		}else if(returnOrderDTO.getOrderId() == null){
			return "orderId is null";
		}else if(returnOrderDTO.getReturnItems() == null || returnOrderDTO.getReturnItems().size() == 0){
			return "returnItems is null";
		}
		return null;
	}
	
}
