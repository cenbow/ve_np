package com.ve.usercenter.core.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.usercenter.core.dao.UserAuthInfoDao;
import com.ve.usercenter.core.domain.UserAuthInfoDO;

@Service
public class UserAuthInfoDaoImpl extends SqlMapClientDaoSupport implements
		UserAuthInfoDao {

	@Override
	public Long addAuthInfo(UserAuthInfoDO userAuthInfoDo) {
		// TODO Auto-generated method stub
		Long id = (Long) getSqlMapClientTemplate().insert(
				"user_auth_info.insert", userAuthInfoDo);
		return id;
	}

	@Override
	public UserAuthInfoDO getAuthInfoById(Long id) {
		// TODO Auto-generated method stub
		UserAuthInfoDO userAuthInfoDo = (UserAuthInfoDO) getSqlMapClientTemplate()
				.queryForObject("user_auth_info.selectById", id);
		return userAuthInfoDo;
	}

	@Override
	public UserAuthInfoDO getAuthInfoByUserId(Long userId) {
		// TODO Auto-generated method stub
		UserAuthInfoDO userAuthInfoDo = (UserAuthInfoDO) getSqlMapClientTemplate()
				.queryForObject("user_auth_info.selectByUserId", userId);
		return userAuthInfoDo;
	}

	@Override
	public int passUserIden(Long userId, String remark) {
		// TODO Auto-generated method stub
		UserAuthInfoDO key = new UserAuthInfoDO();
		key.setUserId(userId);
		key.setRemark(remark);

		return getSqlMapClientTemplate().update("user_auth_info.pass", key);
	}

	@Override
	public int refuseUserIden(Long userId, String remark) {
		// TODO Auto-generated method stub
		UserAuthInfoDO key = new UserAuthInfoDO();
		key.setUserId(userId);
		key.setRemark(remark);

		return getSqlMapClientTemplate().update("user_auth_info.refuse", key);
	}

	@Override
	public int updateAuthInfo(UserAuthInfoDO authInfoDo) {
		// TODO Auto-generated method stub

		return getSqlMapClientTemplate().update("user_auth_info.update",
				authInfoDo);
	}

	@Override
	public int deleteUserAuth(Long userId) {
		// TODO Auto-generated method stub

		return getSqlMapClientTemplate()
				.update("user_auth_info.delete", userId);
	}

	@Override
	public int restoreUserAuth(Long userId) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("user_auth_info.restore",
				userId);
	}

}
