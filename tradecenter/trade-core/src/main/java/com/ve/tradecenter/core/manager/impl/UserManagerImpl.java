package com.ve.tradecenter.core.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.UserDTO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.UserManager;
import com.ve.usercenter.client.ConsigneeClient;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.dto.ConsigneeDTO;

public class UserManagerImpl implements UserManager{
	
//	@Resource
	private ConsigneeClient consigneeClient;
	
	/*
	 * 测试数据
	 */
	private Map<Long,UserDTO> map = new HashMap<Long,UserDTO>();
	{
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(1L);
		userDTO.setAddressId(121L);
		userDTO.setAddress("浙江省杭州市西湖区文三路478号");
		map.put(1L, userDTO);
		
		UserDTO userDTO2 = new UserDTO();
		userDTO.setUserId(2L);
		userDTO.setAddressId(121L);
		userDTO.setAddress("浙江省杭州市余杭区");
		map.put(2L, userDTO2);
		
		UserDTO userDTO3 = new UserDTO();
		userDTO.setUserId(3L);
		userDTO.setAddressId(121L);
		userDTO.setAddress("福建省福州市");
		map.put(3L, userDTO3);
		
		UserDTO userDTO4 = new UserDTO();
		userDTO.setUserId(4L);
		userDTO.setAddressId(121L);
		userDTO.setAddress("广东省广州市");
		map.put(4L, userDTO4);
	}
	

	@Override
	public UserDTO getUserDTO(Long userId) {
		return map.get(userId);
	}
	
	public String getUserAddress(long userId,long addressId)throws TradeException{
		UserResponse<List> result = null;
		try{
			result = (UserResponse<List>)consigneeClient.queryConsignee(userId);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_REMOTE_CALL_ERROR,e);
		}
		ConsigneeDTO consignee = null;
		if(result.getCode().equals(ResponseCode.RESPONSE_SUCCESS.getCode())){
			for(int i=0;i<result.getModule().size();i++){
				consignee = (ConsigneeDTO)result.getModule().get(i);
				if(consignee.getIsDefault()){
					return consignee.getAddress();
				}
			}
		}else{
			return null;
		}
		return null;
	}
	
	@Override
	public long getVeSupplierId(){
		return 1L;
	}
}
