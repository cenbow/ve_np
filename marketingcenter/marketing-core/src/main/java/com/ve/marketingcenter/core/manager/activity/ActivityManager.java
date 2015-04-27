package com.ve.marketingcenter.core.manager.activity;

import java.util.List;

import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingActivityQTO;
import com.ve.marketingcenter.core.exception.MarketingException;

/**
 * dto和do的转换放在manager层
 * @author pengfei.zhu
 *
 */
public interface ActivityManager {
	public Long addActivity(MarketingActivityDTO mdto) throws MarketingException;

	public int updateActivity(MarketingActivityDTO mdto) throws MarketingException;
	
	public int updateActivityStatus(Long id,int status) throws MarketingException;

	public int deleteActivity(long id) throws MarketingException;

	public List<MarketingActivityDTO> queryActivity(MarketingActivityQTO qto) throws MarketingException;
	
	public MarketingActivityDTO getActivity(Long id) throws MarketingException;
	
	public int queryActivityCount(MarketingActivityQTO qto) throws MarketingException;
}
