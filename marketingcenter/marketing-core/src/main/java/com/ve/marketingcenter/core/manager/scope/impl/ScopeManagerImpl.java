package com.ve.marketingcenter.core.manager.scope.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingScopeDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingScopeQTO;
import com.ve.marketingcenter.core.dao.scope.ScopeDODAO;
import com.ve.marketingcenter.core.domain.ActivityDO;
import com.ve.marketingcenter.core.domain.ScopeDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.scope.ScopeManager;
import com.ve.marketingcenter.core.util.MarketingUtils;


public class ScopeManagerImpl implements ScopeManager {
	
	private ScopeDODAO scopeDao;
	
	@Override
	public int addBatchScope(List<MarketingScopeDTO> msdtos) throws MarketingException {
		try {
			List<ScopeDO> sdos = new ArrayList<ScopeDO>();
			
			for(MarketingScopeDTO dto : msdtos){
				ScopeDO sdo = new ScopeDO();
				MarketingUtils.copyProperties(dto, sdo);
				sdos.add(sdo);
			}
			return scopeDao.addBatchScope(sdos);
		} catch (Exception e) {
			e.printStackTrace();
			//CONTINUED exception
			throw new MarketingException();
		}
	}

	@Override
	public List<MarketingScopeDTO> queryActivityScope(MarketingScopeQTO qto) throws MarketingException {
		try {
			return translate(scopeDao.queryActivityScope(qto));
		} catch (Exception e) {
			//TODO exception
			throw new MarketingException();
		}
	}
	
	private static List<MarketingScopeDTO> translate(List<ScopeDO> doList) throws InstantiationException, IllegalAccessException{
		List<MarketingScopeDTO> rtnList = new ArrayList<MarketingScopeDTO>();
		if(CollectionUtils.isEmpty(doList)){
			return rtnList;
		}
		
		for(ScopeDO sdo : doList){
			MarketingScopeDTO dest = new MarketingScopeDTO();
			MarketingUtils.copyProperties(sdo, dest);
			
			ActivityDO ado = sdo.getActivity();
			MarketingActivityDTO mdto = new MarketingActivityDTO();
			MarketingUtils.copyProperties(ado, mdto);
			mdto.setPlatform(MarketingUtils.getDispPlatform(ado.getPlatform()));
			dest.setActivity(mdto);
			
			rtnList.add(dest);
		}
		return rtnList;
	}


	public void setScopeDao(ScopeDODAO scopeDao) {
		this.scopeDao = scopeDao;
	}
}
