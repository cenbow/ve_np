package com.ve.marketingcenter.core.service.action.engine.tools;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.FavorableInfo;
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;
import com.ve.marketingcenter.core.domain.ActualParamDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.actualParam.ActualParamManager;
/**
 * 满减工具
 * @author pengfei.zhu
 *
 */
@Service("full-reduction")
public class FullThenReduction implements Tool {
	
	@Resource(name = "actualParamManager")
	private ActualParamManager actualParamManager;
	/**
	 * 活动针对的用户类型
	 */
	private Set<String> userTypes;
	/**
	 * 活动需满足的条件
	 */
	private String condition;
	/**
	 * 优惠额
	 */
	private String deduction;
	
	@Override
	public FavorableInfo parse(Entry<Long, Set<Long>> actWithItems, String utype,
			Map<Long, MarketingItemDTO> itemsCache) throws MarketingException {
		FavorableInfo info = new FavorableInfo();
		setToolParams(actualParamManager.queryActualParamsByActId(actWithItems.getKey()));
		if(!ToolsHelper.isUsertypeInTarget(getUserTypes(), utype)){
			return info;
		}
		
		if(!ToolsHelper.isAmountGEGivenValue(actWithItems.getValue(),itemsCache,getCondition())){
			return info;
		}
		
		info.setOfferAmount(Long.valueOf(getDeduction()));
//		info.setNoPostage();
//		info.setGiftList();
		return info;
	}
	

	@Override
	public void setToolParams(List<ActualParamDO> actualParams) {
		Set<String> utypes = Sets.newHashSet();
		for(ActualParamDO apdo : actualParams){
			if(StringUtils.equals(apdo.getParamName(), MarketingConstant.MARKETING_ACTIVITY_TARGET)){
				utypes.add(apdo.getParamValue());
			}else if(StringUtils.equals(apdo.getParamName(), MarketingConstant.CONDITION_COM_TYPE_GE)){
				setCondition(apdo.getParamValue());
			}else if(StringUtils.equals(apdo.getParamName(), MarketingConstant.ACTIVITY_COM_TYPE_SUBSTRACT)){
				setDeduction(apdo.getParamValue());
			}
		}
		setUserTypes(utypes);
	}

	public Set<String> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(Set<String> userTypes) {
		this.userTypes = userTypes;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDeduction() {
		return deduction;
	}

	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}
}
