package com.ve.usercenter.core.dao;

import org.springframework.stereotype.Service;

import com.ve.usercenter.core.domain.UserAuthInfoDO;

@Service
public interface UserAuthInfoDao {

	Long addAuthInfo(UserAuthInfoDO userAuthInfoDo);

	/**
	 * 根据id查询指定的认证信息
	 * */
	UserAuthInfoDO getAuthInfoById(Long id);

	/**
	 * 根据user_id查询指定用户的认证信息
	 * */
	UserAuthInfoDO getAuthInfoByUserId(Long userId);

	/**
	 * 用户实名认证通过
	 * */
	int passUserIden(Long userId, String remark);

	/**
	 * 用户实名认证不通过
	 * */
	int refuseUserIden(Long userId, String remark);

	/**
	 * 修改用户的实名认证信息
	 * */
	int updateAuthInfo(UserAuthInfoDO authInfoDo);

	/**
	 * 删除指定用户的实名认证消息
	 * */
	int deleteUserAuth(Long userId);

	int restoreUserAuth(Long userId);
}
