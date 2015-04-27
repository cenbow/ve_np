package com.ve.usercenter.client;

import java.util.List;

import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.common.dto.UserInfoDTO;
import com.ve.usercenter.common.qto.UserQTO;

public interface UserClient {

	/**
	 * 激活用户
	 */
	Response<Boolean> activeUser(Long userId);

	/**
	 * 删除用户
	 */
	Response<Boolean> deletedUser(Long userId);

	/**
	 * 冻结用户
	 */
	Response<Boolean> freezeUser(Long userId);

	/**
	 * 根据邮箱获取用户
	 */
	Response<UserDTO> getUserByEmail(String email);

	/**
	 * 根据id获取用户
	 */
	Response<UserDTO> getUserById(Long userId);

	/**
	 * 根据电话获取用户
	 */
	Response<UserDTO> getUserByMobile(String mobile);

	/**
	 * 根据用户名获取用户
	 */
	Response<UserDTO> getUserByName(String name);

	/**
	 * 添加用户
	 */
	Response<UserDTO> addUser(UserDTO userDto);

	/**
	 * 将用户移入回收站
	 */
	Response<Boolean> moveUserIntoRecycle(Long userId);

	/**
	 * 将用户从回收站还原
	 */
	Response<Boolean> restoreUser(Long userId);

	/**
	 * 设置用户角色
	 */
	Response<Boolean> setUserRole(Long userId, Byte role);

	/**
	 * 修改邮箱
	 */
	Response<Boolean> updateEmail(Long userId, String email);

	/**
	 * 修改手机
	 */
	Response<Boolean> updateMobile(Long userId, String mobile);

	/**
	 * 修改密码
	 */
	Response<Boolean> updatePwd(Long userId, String newPwd, String oldPwd);

	/**
	 * 修改用户头像
	 */
	Response<Boolean> updateHeadImg(Long userId, String headImg);

	/**
	 * 查询用户
	 */
	Response<List> queryUser(UserQTO userQto);

	/**
	 * 第三方用户登陆
	 */
	Response<UserDTO> apiUserLogin(UserInfoDTO userInfoDto);

	/**
	 * 用户登陆
	 */
	Response<UserDTO> userLogin(String loginName, String loginPwd);

}
