package com.ve.marketingcenter.core.manager.actualParam;

import java.util.List;

import com.ve.marketingcenter.common.domain.dto.MarketingActualParamDTO;
import com.ve.marketingcenter.core.domain.ActualParamDO;
import com.ve.marketingcenter.core.exception.MarketingException;


/**
 * dto和do的转换放在manager层
 * @author pengfei.zhu
 *
 */
public interface ActualParamManager {
	public int addActualParams(List<MarketingActualParamDTO> madtos) throws MarketingException;
	
	public List<ActualParamDO> queryActualParamsByActId(Long actId) throws MarketingException;
}
