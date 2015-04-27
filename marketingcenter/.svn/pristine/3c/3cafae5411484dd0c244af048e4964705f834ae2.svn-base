package com.ve.marketingcenter.core.manager.scope;

import java.util.List;

import com.ve.marketingcenter.common.domain.dto.MarketingScopeDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingScopeQTO;
import com.ve.marketingcenter.core.exception.MarketingException;

/**
 * dto和do的转换放在manager层
 * @author pengfei.zhu
 *
 */
public interface ScopeManager {
	public int addBatchScope(List<MarketingScopeDTO> msdtos) throws MarketingException;
//
//	public int update(BaseDTO baseDto) throws MarketingException;
//	
//	public int updateStatus(Long id,int status) throws MarketingException;
//
//	public int delete(long id) throws MarketingException;

	public List<MarketingScopeDTO> queryActivityScope(MarketingScopeQTO qto) throws MarketingException;
	
//	public BaseDTO getByPK(Long id) throws MarketingException;
//	
//	public int queryForCount(BaseQTO qto) throws MarketingException;
}
