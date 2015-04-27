package com.ve.marketingcenter.core.service.action.engine;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.FavorableInfo;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
/**
 * 此接口只计算购物车阶段的优惠，购物车阶段是没有优惠券的，
 * 所以，此阶段只能计算不需要优惠券的活动
 * @author Administrator
 *
 */
@Service
public class ComputeCartFavorable extends ComputeFavorable implements Action<List<FavorableInfo>>{
	private static final Logger log = LoggerFactory.getLogger(ComputeCartFavorable.class);
	
	@Override
	public MarketingResponse<List<FavorableInfo>> execute(
			RequestContext<List<FavorableInfo>> request) throws MarketingException {
		@SuppressWarnings("unchecked")
		List<MarketingItemDTO> items = (List<MarketingItemDTO>)request.getRequest().
				getParam(MarketingConstant.REQUEST_PARAM_ITEM_LIST);
		String puid = String.valueOf(request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_USER_ID));
		String utype = String.valueOf(request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_USER_TYPE));
		String plat = String.valueOf(request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_PLATFORM));
		
		Preconditions.checkArgument(CollectionUtils.isNotEmpty(items), "商品列表不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(utype), "用户类型不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(plat), "用户平台不能为空!");
		if(log.isDebugEnabled()){
			log.debug("item list:"+JSONObject.toJSONString(items,true));
			log.debug("user id:"+puid);
			log.debug("log in type:"+utype);
			log.debug("log in platform:"+plat);
		}
		
		//缓存活动对象列表
		Cache<Long,MarketingActivityDTO> marketCache = CacheBuilder.newBuilder().build();
		try {
			Map<Long,Set<Long>> actContainsItems = super.getActivityMap(items,marketCache);
			List<FavorableInfo> infos = null;
			if(super.checkActivityMap(actContainsItems,utype,plat,marketCache,null,null)){
				infos = super.parseAngCompute(actContainsItems,marketCache,super.putItemsCache(items),utype,null);
			}
			return MarketingUtils.getSuccessResponse(infos);
		} catch (MarketingException e) {
			log.error("Action:" + request.getRequest().getCommand(), e);
			return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
		}
	}
	
	@Override
	public String getName() {
		return ActionEnum.COMPUTE_CART_FAVORABLE.getActionName();
	}
}
