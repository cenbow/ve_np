package com.ve.usercenter.core.manager;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.dto.UserAuthInfoDTO;
import com.ve.usercenter.core.exception.UserException;

@Service
public interface UserAuthInfoManager {

	/**
	 * 添加普通用户的实名认证信息
	 * */
	UserAuthInfoDTO saveUserAuthInfo(UserAuthInfoDTO authInfoDto)
			throws UserException;

	/**
	 * 根据id查询指定的扩展信息
	 * */
	UserAuthInfoDTO getAuthInfoById(Long id) throws UserException;

	/**
	 * 根据user_id查询指定用户的扩展信息
	 * */
	UserAuthInfoDTO getAuthInfoByUserId(Long userId) throws UserException;

	/**
	 * 买家实名认证通过 ，将status改为1
	 * */
	int passUserIden(Long userId, String remark) throws UserException;

	/**
	 * 买家实名认证失败 ，将status改为2
	 * */
	int refuseUserIden(Long userId, String remark) throws UserException;

	/**
	 * 跟新买家的实名认证信息，更新成功将审核状态重置为默认状态
	 * */
	int updateAuthInfo(UserAuthInfoDTO authInfoDto) throws UserException;

	/***
	 * 删除指定用户的认证消息
	 * 
	 * @param userId
	 * @return
	 */
	int deleteUserAuth(Long userId) throws UserException;

	/**
	 * 将删除的用户认证信息还原
	 * 
	 * @param userId
	 * @return
	 */
	int restoreUserAuth(Long userId) throws UserException;

}
