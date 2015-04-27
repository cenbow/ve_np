package com.ve.marketingcenter.core.service.action.engine.tools;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.cache.Cache;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;
import com.ve.marketingcenter.core.domain.ActualParamDO;

class ToolsHelper {
	static boolean isUsertypeInTarget(Set<String> utypes,String utype){
		return utypes.contains(MarketingConstant.USER_TYPE_ALL) || utypes.contains(utype);
	}
	
	static boolean isAmountGEGivenValue(Set<Long> itemIds,Map<Long, MarketingItemDTO> itemsCache,String condition){
		long givenValue = Long.valueOf(condition);
		if(givenValue == 0){
			return true;
		}
		
		long amount = 0;
		MarketingItemDTO item;
		for(Long itemId : itemIds){
			item = itemsCache.get(itemId);
			amount +=(item.getNumber() * item.getUnitPrice());
		}
		return amount >= givenValue;
	}
	
	static boolean isNuberGEGivenValue(List<ActualParamDO> apdos,Set<Long> itemIds,Cache<Long, MarketingItemDTO> itemsCache){
		long givenValue = 0;
		for(ActualParamDO apdo : apdos){
			if(StringUtils.equals(apdo.getParamName(), MarketingConstant.CONDITION_COM_TYPE_GE) ){
				givenValue = Long.valueOf(apdo.getParamValue());
				break;
			}
		}
		return itemIds.size() >= givenValue;
	}
}
