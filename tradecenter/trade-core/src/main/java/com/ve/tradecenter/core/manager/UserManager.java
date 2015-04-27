package com.ve.tradecenter.core.manager;

import com.ve.tradecenter.common.domain.UserDTO;
import com.ve.tradecenter.core.exception.TradeException;

public interface UserManager {
	
	/**
	 * 根据用户id和用户地址id来获取用户的收货地址信息
	 * @param userId
	 * @return
	 */
	public UserDTO getUserDTO(Long userId);
	
	/**
	 * 
	 * @param userId
	 * @param addressId
	 * @return
	 */
	public String getUserAddress(long userId,long addressId)throws TradeException;
	
	/**
	 * 
	 * @return
	 */
	public long getVeSupplierId();
}
