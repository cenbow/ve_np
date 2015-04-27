package com.ve.marketingcenter.core.dao.actualParam.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.core.dao.actualParam.ActualParamDODAO;
import com.ve.marketingcenter.core.domain.ActualParamDO;

public class ActualParamDODAOImpl extends SqlMapClientDaoSupport implements ActualParamDODAO {

	@Override
	public int addActualParams(List<ActualParamDO> records) {
		return getSqlMapClientTemplate().update("market_param_instance.addActualParams", records);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActualParamDO> queryActualParamsByActId(Long actId) {
		ActualParamDO ado = new ActualParamDO();
		ado.setOwnerId(actId);
		ado.setOwnerType(MarketingConstant.PARAM_OWNER_TYPE_ACT);
		return getSqlMapClientTemplate().queryForList("market_param_instance.queryActualParamsByActId", ado);
	}
}