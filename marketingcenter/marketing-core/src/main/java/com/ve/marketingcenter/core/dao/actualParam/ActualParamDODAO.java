package com.ve.marketingcenter.core.dao.actualParam;

import java.util.List;

import com.ve.marketingcenter.core.domain.ActualParamDO;


public interface ActualParamDODAO {
	public int addActualParams(List<ActualParamDO> records);
	
	public List<ActualParamDO> queryActualParamsByActId(Long actId);
}