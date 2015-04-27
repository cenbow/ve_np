package com.ve.usercenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.dto.ConsigneeDTO;
import com.ve.usercenter.core.exception.UserException;

@Service
public interface ConsigneeManager {

	ConsigneeDTO addConsignee(ConsigneeDTO consigneeDto) throws UserException;

	/**
	 * 删除指定的收货地址
	 * */
	int deleteConsignee(Long userId, Long consigneeId) throws UserException;

	/**
	 * 修改指定的收货地址
	 * */
	int updateConsignee(ConsigneeDTO consigneeDto) throws UserException;

	/**
	 * 将指定的收货地址设为默认
	 * */
	int setDefConsignee(Long userId, Long consigneeId) throws UserException;

	/**
	 * 将指定用户所有的收货地址修改为非默认
	 * */
	int updateUserDefaultConsignee(Long userId) throws UserException;

	/**
	 * 指定用户的收货地址总数
	 * */
	int getConsigneeCountByUserId(Long userId) throws UserException;

	/**
	 * 查询指定用户的收货地址列表
	 * */
	List<ConsigneeDTO> queryConsignee(Long userId) throws UserException;

	/**
	 * 删除指定用户所有的收货地址
	 * */
	int deleteUserConsignee(Long userId) throws UserException;

	/**
	 * 将删除指定用户的收货地址还原
	 * */
	int restoreUserConsignee(Long userId) throws UserException;

	/**
	 * 
	 * @param userId
	 * @param consigneeId
	 * @return
	 */
	ConsigneeDTO getConsigneeById(Long userId, Long consigneeId)
			throws UserException;

}
