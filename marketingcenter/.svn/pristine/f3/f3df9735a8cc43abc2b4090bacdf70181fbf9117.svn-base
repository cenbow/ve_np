package com.ve.marketingcenter.core.dao.track.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.marketingcenter.core.dao.track.AuditTrackDODAO;
import com.ve.marketingcenter.core.domain.AuditTrackDO;

public class AuditTrackDODAOImpl extends SqlMapClientDaoSupport implements AuditTrackDODAO {
	@Override
	public Long addTrack(AuditTrackDO record) {
		return (Long)getSqlMapClientTemplate().insert("market_audit_track.addTrack", record);
	}
}