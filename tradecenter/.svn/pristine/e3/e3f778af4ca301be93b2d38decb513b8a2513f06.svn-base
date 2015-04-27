package com.ve.tradecenter.core.manager.impl;

import javax.annotation.Resource;

import com.ve.tradecenter.common.domain.DeliveryReturnDTO;
import com.ve.tradecenter.core.dao.DeliveryReturnDao;
import com.ve.tradecenter.core.domain.DeliveryReturnDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.DeliveryReturnManager;

public class DeliveryReturnManagerImpl implements DeliveryReturnManager{

	@Resource
	private DeliveryReturnDao deliveryReturnDao;
	
	@Override
	public long addDeliveryReturn(DeliveryReturnDO deliveryReturnDO)
			throws TradeException {
		return this.deliveryReturnDao.addDeliveryReturn(deliveryReturnDO);
	}
	
	@Override
	public String validateFields(DeliveryReturnDTO deliveryReturnDTO)throws TradeException{
		//TODO
		// 字段验证
		return null ;
	}

}
