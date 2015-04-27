package com.ve.marketingcenter.core.manager.track.impl;

import com.ve.marketingcenter.common.domain.dto.MarketingTrackDTO;
import com.ve.marketingcenter.core.dao.track.AuditTrackDODAO;
import com.ve.marketingcenter.core.domain.AuditTrackDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.track.AuditTrackManager;
import com.ve.marketingcenter.core.util.MarketingUtils;


public class AuditTrackManagerImpl implements AuditTrackManager {
	
	private AuditTrackDODAO auditTrackDao;
	
	@Override
	public Long addAuditTrack(MarketingTrackDTO baseDto) throws MarketingException{
		try {
			AuditTrackDO ado = new AuditTrackDO();
			MarketingUtils.copyProperties(baseDto,ado);
			return auditTrackDao.addTrack(ado);
		} catch (Exception e) {
			//CONTINUED exception
			throw new MarketingException();
		}
	}
	
	public void setAuditTrackDao(AuditTrackDODAO auditTrackDao) {
		this.auditTrackDao = auditTrackDao;
	}
}
