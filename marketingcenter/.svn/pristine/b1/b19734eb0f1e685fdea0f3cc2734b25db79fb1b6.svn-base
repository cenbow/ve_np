package com.ve.marketingcenter.core.dao.formalParam.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.marketingcenter.common.domain.qto.MarketingFormalParamQTO;
import com.ve.marketingcenter.core.dao.formalParam.FormalParamDODAO;
import com.ve.marketingcenter.core.domain.FormalParamDO;


public class FormalParamDODAOImpl extends SqlMapClientDaoSupport implements FormalParamDODAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<FormalParamDO> queryFormalParam(MarketingFormalParamQTO qto) {
		 return getSqlMapClientTemplate().queryForList("market_param_template.queryFormalParam", qto);
	}
}