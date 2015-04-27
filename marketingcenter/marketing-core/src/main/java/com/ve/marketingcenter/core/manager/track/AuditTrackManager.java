package com.ve.marketingcenter.core.manager.track;

import com.ve.marketingcenter.common.domain.dto.MarketingTrackDTO;
import com.ve.marketingcenter.core.exception.MarketingException;

/**
 * dto和do的转换放在manager层
 * @author pengfei.zhu
 *
 */
public interface AuditTrackManager {
	public Long addAuditTrack(MarketingTrackDTO baseDto) throws MarketingException;
//
//	public int update(BaseDTO baseDto) throws MarketingException;
//	
//	public int updateStatus(Long id,int status) throws MarketingException;
//
//	public int delete(long id) throws MarketingException;
//
//	public List<BaseDTO> queryForList(BaseQTO qto) throws MarketingException;
//	
//	public BaseDTO getByPK(Long id) throws MarketingException;
//	
//	public int queryForCount(BaseQTO qto) throws MarketingException;
}
