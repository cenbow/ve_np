package com.ve.tradecenter.core.manager;

import com.ve.tradecenter.core.exception.TradeException;

public interface DeliveryManager {
	
	/**
	 * 根据地址判断是否支持货到付款
	 * @return
	 */
	public boolean isCodSupported(long regionId);
	
	/** 
	 * 根据yon
	 * @param addressId
	 * @param userId
	 * @return
	 */
	public long getDeliveryFee(Long addressId,Long weight);
	
}