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
import com.google.common.collect.Maps;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.FavorableInfo;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class ComputeOrderFavorable extends ComputeFavorable implements Action<List<FavorableInfo>>{
	
	private static final Logger log = LoggerFactory.getLogger(ComputeOrderFavorable.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public MarketingResponse<List<FavorableInfo>> execute(
			RequestContext<List<FavorableInfo>> request) throws MarketingException {
		
		List<MarketingItemDTO> items = (List<MarketingItemDTO>)request.getRequest().
				getParam(MarketingConstant.REQUEST_PARAM_ITEM_LIST);
		
		List<ActivityCouponDTO> coupons = (List<ActivityCouponDTO>)request.getRequest().
				getParam(MarketingConstant.REQUEST_PARAM_COUPON_LIST);
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
			if(CollectionUtils.isNotEmpty(coupons)){
				log.debug("item list:"+JSONObject.toJSONString(coupons,true));
			}
		}
		
		//缓存活动对象列表
		Cache<Long,MarketingActivityDTO> marketCache = CacheBuilder.newBuilder().build();
		try {
			Map<Long,Set<Long>> actContainsItems = super.getActivityMap(items,marketCache);
			List<FavorableInfo> infos = null;
			Map<Long,ActivityCouponDTO> usedCoupon = Maps.newHashMap();
			if(super.checkActivityMap(actContainsItems,utype,plat,marketCache,putCouponCache(coupons),usedCoupon)){
				infos = super.parseAngCompute(actContainsItems,marketCache,super.putItemsCache(items),utype,usedCoupon);
			}
			return MarketingUtils.getSuccessResponse(infos);
		} catch (MarketingException e) {
			log.error("Action:" + request.getRequest().getCommand(), e);
			return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
		}
	
	}
	
	/**
	 * 同一用户，一个活动只能使用一个优惠券
	 * @param coupons
	 * @return
	 */
	private static Map<Long,ActivityCouponDTO> putCouponCache(List<ActivityCouponDTO> coupons){
		Map<Long,ActivityCouponDTO> couponCache = Maps.newHashMap();
		if(CollectionUtils.isEmpty(coupons)){
			return couponCache;
		}
		for(ActivityCouponDTO coupon : coupons){
			couponCache.put(coupon.getActivityId(), coupon);
		}
		return couponCache;
	}

	@Override
	public String getName() {
		return ActionEnum.COMPUTE_ORDER_FAVORABLE.getActionName();
	}
}
