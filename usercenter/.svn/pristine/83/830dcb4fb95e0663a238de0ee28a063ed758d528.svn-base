package com.ve.usercenter.client;

import java.util.List;

import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.dto.ConsigneeDTO;

public interface ConsigneeClient {
	/**
	 * 添加收货地址
	 * */
	Response<ConsigneeDTO> addConsignee(ConsigneeDTO consigneeDto);

	/**
	 * 删除收货地址
	 */
	Response<Boolean> deleteConsignee(Long userId, Long consigneeId);

	/**
	 * 查询用户的收货地址列表
	 */
	Response<List> queryConsignee(Long userId);

	/**
	 * 设置默认地址
	 */
	Response<Boolean> setDefConsignee(Long consigneeId);

	/**
	 * 修改用户的收货地址
	 */
	Response<Boolean> updateConsignee(ConsigneeDTO consigneeDto);

	/**
	 * 根据id获取收货地址
	 */
	public Response<ConsigneeDTO> getConsigneeById(Long userId, Long consigneeId);
}
