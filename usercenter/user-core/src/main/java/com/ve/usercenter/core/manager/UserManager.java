package com.ve.usercenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.common.dto.UserInfoDTO;
import com.ve.usercenter.common.qto.UserQTO;
import com.ve.usercenter.core.exception.UserException;

@Service
public interface UserManager {
	/**
	 * 添加用户
	 * */
	UserDTO addUser(UserDTO userDto) throws UserException;

	/**
	 * 根据用户名查找用户
	 * */
	UserDTO getUserByName(String name) throws UserException;

	/**
	 * 根据用户email查找用户
	 * */
	UserDTO getUserByEmail(String email) throws UserException;

	/**
	 * 根据用户手机查找用户
	 * */
	UserDTO getUserByMobile(String mobile) throws UserException;

	/**
	 * 根据用于id查找用户
	 * */
	UserDTO getUserById(Long userId) throws UserException;

	/**
	 * 更新用户密码
	 * */
	int updatePwd(Long userId, String oldPwd, String newPwd)
			throws UserException;

	/**
	 * 跟新用户名
	 * */
	int updateName(Long userId, String name) throws UserException;

	/**
	 * 更新用户email
	 * */
	int updateEmail(Long userId, String email) throws UserException;

	/**
	 * 更新用户手机
	 * */
	int updateMobile(Long userId, String mobile) throws UserException;

	/**
	 * 激活用户
	 * */
	int activeUser(Long userId) throws UserException;

	/**
	 * 冻结用户
	 * */
	int freezeUser(Long userId) throws UserException;

	/**
	 * 将用户移入回收站
	 * */
	int moveToRecycle(Long userId) throws UserException;

	/**
	 * 逻辑删除用户:删除不用户不能恢复
	 * */
	int deleteUser(Long userId) throws UserException;

	/**
	 * 符合查询用户
	 * */
	List<UserDTO> queryUser(UserQTO userQto) throws UserException;

	/**
	 * 设置用户角色
	 * */
	int setUserRole(Long userId, Byte role) throws UserException;

	/**
	 * 将用户从回收站还原
	 * */
	int restoreUser(Long userId) throws UserException;

	/**
	 * 根据id获取在回收站中的用户
	 * */
	UserDTO getRecycleUser(Long userId) throws UserException;

	/**
	 * 用户登陆
	 * */
	UserDTO userLogin(String loginName, String loginPwd) throws UserException;

	/**
	 * 第三方登陆
	 * */
	UserDTO apiUserLogin(UserInfoDTO userInfoDto) throws UserException;

	/**
	 * 修改用户的基本信息
	 * */
	Integer updateUser(UserDTO userDto) throws UserException;

	/**
	 * 查询指定查询条件下的用户总数
	 * */
	Long getTotalCount(UserQTO userQto) throws UserException;

	/**
	 * 修改用户的头像
	 * 
	 * @param userId
	 * @param headImg
	 * @return
	 */
	int updateHeadImg(Long userId, String headImg) throws UserException;

	/**
	 * 根据登录名获取用户
	 */
	UserDTO getUserByLoginName(String loginName) throws UserException;
}
