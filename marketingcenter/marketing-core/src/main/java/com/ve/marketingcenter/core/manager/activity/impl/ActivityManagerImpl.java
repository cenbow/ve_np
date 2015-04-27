package com.ve.marketingcenter.core.manager.activity.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingActualParamDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingScopeDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingActivityQTO;
import com.ve.marketingcenter.core.dao.activity.ActivityDODAO;
import com.ve.marketingcenter.core.domain.ActivityDO;
import com.ve.marketingcenter.core.domain.ActualParamDO;
import com.ve.marketingcenter.core.domain.ScopeDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.activity.ActivityManager;
import com.ve.marketingcenter.core.util.MarketingUtils;
public class ActivityManagerImpl implements ActivityManager {

	private ActivityDODAO activityDao;
	
	@Override
	public Long addActivity(MarketingActivityDTO mdto) throws MarketingException {
		try {
			ActivityDO activity = new ActivityDO();
			MarketingUtils.copyProperties(mdto, activity);
			//前台的platform转换为数据库的platform
			activity.setPlatform(MarketingUtils.getCombinedPlatformDBValue(mdto.getPlatform()));
			return activityDao.addActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
			//CONTINUED exception
			throw new MarketingException();
		}
	}

	@Override
	public int updateActivity(MarketingActivityDTO mdto) throws MarketingException {
		try {
			ActivityDO activity = new ActivityDO();
			MarketingUtils.copyProperties(mdto, activity);
			//前台的platform转换为数据库的platform
			if(StringUtils.isNotBlank(mdto.getPlatform())){
				activity.setPlatform(MarketingUtils.getCombinedPlatformDBValue(mdto.getPlatform()));
			}
			//CONTINUED 营销范围,工具参数暂时不支持修改
			return activityDao.updateActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO exception
			throw new MarketingException();
		}
	
	}

	@Override
	public int deleteActivity(long id) throws MarketingException {
		ActivityDO record = new ActivityDO();
		record.setId(id);
		record.setDeleteFlag(MarketingConstant.GLOBAL_FLAG_YES);
		try{
			return activityDao.updateActivity(record);
		} catch (Exception e) {
			//TODO exception
			throw new MarketingException();
		}
	}
	
	@Override
	public int updateActivityStatus(Long id,int status) throws MarketingException{
		ActivityDO record = new ActivityDO();
		record.setId(id);
		record.setStatus(status);
		try {
			return activityDao.updateActivity(record);
		} catch (Exception e) {
			//TODO exception
			throw new MarketingException();
		}
	}

	@Override
	public List<MarketingActivityDTO> queryActivity(MarketingActivityQTO qto) throws MarketingException {
		try {
			return translate(activityDao.queryActivity(qto),false);
		} catch (Exception e) {
			//TODO exception
			throw new MarketingException();
		}
	}
	
	@Override
	public MarketingActivityDTO getActivity(Long id) throws MarketingException {
		try {
			ActivityDO bdo = activityDao.getActivity(id);
			if(bdo == null){
				return null;
			}
			List<ActivityDO> tmp = new ArrayList<ActivityDO>();
			tmp.add(bdo);
			return translate(tmp,true).get(0);
		} catch (Exception e) {
			//TODO exception
			e.printStackTrace();
			throw new MarketingException();
		}
	}

	@Override
	public int queryActivityCount(MarketingActivityQTO qto) throws MarketingException {
		try {
			return activityDao.queryActivityCount(qto);
		} catch (Exception e) {
			//TODO exception
			throw new MarketingException();
		}
	}
	
	/**
	 * 考虑到关联查询非常耗时，所以只在单个查询时做关联查询
	 * @param adoList
	 * @param ifCascade
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private static List<MarketingActivityDTO> translate(List<ActivityDO> adoList,boolean ifCascade) throws InstantiationException, IllegalAccessException{
		List<MarketingActivityDTO> activityDtos = new ArrayList<MarketingActivityDTO>();
		if(CollectionUtils.isEmpty(adoList)){
			return activityDtos;
		}
		for(ActivityDO ado : adoList){
			MarketingActivityDTO activityDto = new MarketingActivityDTO();
			MarketingUtils.copyProperties(ado, activityDto);
			activityDto.setPlatform(MarketingUtils.getDispPlatform(ado.getPlatform()));
			
			if(ifCascade){
				List<MarketingScopeDTO> marketScopes = new ArrayList<MarketingScopeDTO>();
				for(ScopeDO sdo : ado.getMarketScopes()){
					MarketingScopeDTO scope = new MarketingScopeDTO();
					MarketingUtils.copyProperties(sdo, scope);
					marketScopes.add(scope);
				}
				activityDto.setMarketScopes(marketScopes);
				
				List<MarketingActualParamDTO> marketParams = new ArrayList<MarketingActualParamDTO>();
				for(ActualParamDO apdo : ado.getMarketParams()){
					MarketingActualParamDTO apdto = new MarketingActualParamDTO();
					MarketingUtils.copyProperties(apdo, apdto);
					marketParams.add(apdto);
				}
				activityDto.setMarketParams(marketParams);
			}
			activityDtos.add(activityDto);
		}
		return activityDtos;
	}

	public ActivityDODAO getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDODAO activityDao) {
		this.activityDao = activityDao;
	}
}
