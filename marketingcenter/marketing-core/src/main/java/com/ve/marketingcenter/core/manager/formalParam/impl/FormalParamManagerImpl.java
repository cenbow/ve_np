package com.ve.marketingcenter.core.manager.formalParam.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.ve.marketingcenter.common.domain.dto.MarketingFormalParamDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingFormalParamQTO;
import com.ve.marketingcenter.core.dao.formalParam.FormalParamDODAO;
import com.ve.marketingcenter.core.domain.FormalParamDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.formalParam.FormalParamManager;
import com.ve.marketingcenter.core.util.MarketingUtils;

public class FormalParamManagerImpl implements FormalParamManager {

	private FormalParamDODAO formalParamDao;

	@Override
	public List<MarketingFormalParamDTO> queryFormalParam(
			MarketingFormalParamQTO qto) throws MarketingException {
		
		try {
			return translate(formalParamDao.queryFormalParam(qto));
		} catch (Exception e) {
			// TODO exception
			throw new MarketingException();
		}
	}

	private List<MarketingFormalParamDTO> translate(List<FormalParamDO> doList)
			throws InstantiationException, IllegalAccessException {
		List<MarketingFormalParamDTO> rtnList = new ArrayList<MarketingFormalParamDTO>();
		if(CollectionUtils.isEmpty(doList)){
			return rtnList;
		}
		
		for (FormalParamDO bdo : doList) {
			MarketingFormalParamDTO dest = new MarketingFormalParamDTO();
			MarketingUtils.copyProperties(bdo, dest);
			rtnList.add(dest);
		}
		return rtnList;
	}

	public void setFormalParamDao(FormalParamDODAO formalParamDao) {
		this.formalParamDao = formalParamDao;
	}
}
