package com.ve.marketingcenter.core.dao.scope;

import java.util.List;

import com.ve.marketingcenter.common.domain.qto.MarketingScopeQTO;
import com.ve.marketingcenter.core.domain.ScopeDO;


public interface ScopeDODAO{
	public int addBatchScope(List<ScopeDO> records);
	public List<ScopeDO> queryActivityScope(MarketingScopeQTO qto);
}