package com.ve.marketingcenter.core.dao.scope.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.marketingcenter.common.domain.qto.MarketingScopeQTO;
import com.ve.marketingcenter.core.dao.scope.ScopeDODAO;
import com.ve.marketingcenter.core.domain.ScopeDO;


public class ScopeDODAOImpl extends SqlMapClientDaoSupport implements ScopeDODAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ScopeDO> queryActivityScope(MarketingScopeQTO qto) {
		 return getSqlMapClientTemplate().queryForList("market_scope.queryActivityScope", qto);
	}

	@Override
	public int addBatchScope(List<ScopeDO> records) {
		return getSqlMapClientTemplate().update("market_scope.addBatchScope", records);
	}
}