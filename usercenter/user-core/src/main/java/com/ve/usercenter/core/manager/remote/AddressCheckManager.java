package com.ve.usercenter.core.manager.remote;


import org.springframework.stereotype.Service;

import com.ve.usercenter.common.constant.ResponseCode;
import com.ve.usercenter.common.dto.ConsigneeDTO;
import com.ve.usercenter.core.exception.UserException;

@Service
public interface AddressCheckManager {

	/**
	 * 用户收货地址校验
	 * */
	public ResponseCode addressCheck(ConsigneeDTO consigneeDto) throws UserException;
}
