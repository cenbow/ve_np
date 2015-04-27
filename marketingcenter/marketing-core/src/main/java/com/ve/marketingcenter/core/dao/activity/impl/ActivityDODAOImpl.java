package com.ve.marketingcenter.core.dao.activity.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.marketingcenter.common.domain.qto.MarketingActivityQTO;
import com.ve.marketingcenter.core.dao.activity.ActivityDODAO;
import com.ve.marketingcenter.core.domain.ActivityDO;
public class ActivityDODAOImpl extends SqlMapClientDaoSupport implements ActivityDODAO {

	@Override
    public Long addActivity(ActivityDO record) {
       return (Long)getSqlMapClientTemplate().insert("market_activity.addActivity", record);
    }
	
    @Override
    public int updateActivity(ActivityDO record) {
        return getSqlMapClientTemplate().update("market_activity.updateActivity", record);
    }
	
    @SuppressWarnings("unchecked")
    @Override
	public List<ActivityDO> queryActivity(MarketingActivityQTO qto) {
        return getSqlMapClientTemplate().queryForList("market_activity.queryActivity", qto);
    }
	
    @Override
    public int queryActivityCount(MarketingActivityQTO qto) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("market_activity.queryActivityCount", qto);
    }
	
    @Override
    public ActivityDO getActivity(Long id) {
        ActivityDO _key = new ActivityDO();
        _key.setId(id);
        return  (ActivityDO) getSqlMapClientTemplate().queryForObject("market_activity.getActivity", _key);
    }
}