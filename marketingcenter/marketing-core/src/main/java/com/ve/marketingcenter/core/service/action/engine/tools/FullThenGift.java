package com.ve.marketingcenter.core.service.action.engine.tools;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.FavorableInfo;
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;
import com.ve.marketingcenter.core.domain.ActualParamDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.actualParam.ActualParamManager;
/**
 * 满赠工具
 * @author pengfei.zhu
 *
 */
@Service("gift-with-purchase")
public class FullThenGift implements Tool {
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
	 * 赠品列表
	 */
	private List<MarketingItemDTO> gifts;
	
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
		
//		info.setOfferAmount(Long.valueOf(getAction()));
//		info.setNoPostage();
		info.setGiftList(getGifts());
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
			}else if(StringUtils.equals(apdo.getParamName(), MarketingConstant.ACTIVITY_COM_TYPE_PRESENT)){
//				Iterable<String> itemIds = Splitter.on(",").omitEmptyStrings().trimResults().split(apdo.getParamValue());
				List<MarketingItemDTO> items = Lists.newArrayList();
//				for(String itemId:itemIds){
					//CONTINUED 调用dubbo查询商品
//					items.add(new MarketingItemDTO());
//				}
				setGifts(items);
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

	public List<MarketingItemDTO> getGifts() {
		return gifts;
	}

	public void setGifts(List<MarketingItemDTO> gifts) {
		this.gifts = gifts;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
}
