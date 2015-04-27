package com.ve.marketingcenter.core.manager.actualParam.impl;

import java.util.ArrayList;
import java.util.List;

import com.ve.marketingcenter.common.domain.dto.MarketingActualParamDTO;
import com.ve.marketingcenter.core.dao.actualParam.ActualParamDODAO;
import com.ve.marketingcenter.core.domain.ActualParamDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.actualParam.ActualParamManager;
import com.ve.marketingcenter.core.util.MarketingUtils;


public class ActualParamManagerImpl implements ActualParamManager {
	
	private ActualParamDODAO actualParamDao;

	@Override
	public int addActualParams(List<MarketingActualParamDTO> madtos)
			throws MarketingException {
		try {
			return actualParamDao.addActualParams(getBatchList(madtos));
		} catch (Exception e) {
			// TODO exception
			e.printStackTrace();
			throw new MarketingException();
		}
	}
	
	@Override
	public List<ActualParamDO> queryActualParamsByActId(Long actId) throws MarketingException {
		try {
			return actualParamDao.queryActualParamsByActId(actId);
		} catch (Exception e) {
			// TODO exception
			e.printStackTrace();
			throw new MarketingException();
		}
	}

	private List<ActualParamDO> getBatchList(List<MarketingActualParamDTO> madtos){
		List<ActualParamDO> rtnList = new ArrayList<ActualParamDO>();
		for(MarketingActualParamDTO dto : madtos){
			ActualParamDO ado = new ActualParamDO();
			MarketingUtils.copyProperties(dto, ado);
			rtnList.add(ado);
		}
		return rtnList;
	}
	
	public void setActualParamDao(ActualParamDODAO actualParamDao) {
		this.actualParamDao = actualParamDao;
	}
}
