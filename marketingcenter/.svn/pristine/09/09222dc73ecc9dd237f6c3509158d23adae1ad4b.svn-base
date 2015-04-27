package com.ve.marketingcenter.core.service.action.activity;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingActivityQTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.activity.ActivityManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class QueryActivityAction implements Action<List<MarketingActivityDTO>> {
	private static final Logger log = LoggerFactory.getLogger(QueryActivityAction.class);
	
	@Resource(name = "activityManager")
	private ActivityManager activityManager;

	@Override
	public MarketingResponse<List<MarketingActivityDTO>> execute(
			RequestContext<List<MarketingActivityDTO>> request) {
		MarketingActivityQTO qto = (MarketingActivityQTO) request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_KEY_ENTITY);
		
		if(qto == null){//为null则默认为分页查询
			qto = new MarketingActivityQTO();
			qto.setStart(0);
			qto.setOffset(MarketingConstant.DEFAULT_PAGE_SIZE);
		}else{
			String platform = qto.getPlatform();
			if(StringUtils.isNotBlank(platform)){
				qto.setPlateformDBValue(MarketingUtils.getCombinedPlatformDBValue(platform));
			}
		}
		if(log.isDebugEnabled()){
			log.debug("MarketingActivityQTO:"+JSONObject.toJSONString(qto, true));
		}
		int total = 0;
		try {
			total = activityManager.queryActivityCount(qto);
			List<MarketingActivityDTO> result = activityManager.queryActivity(qto);
			return MarketingUtils.getSuccessResponse(result,total);
		} catch (MarketingException e) {
			log.error("Action:" + request.getRequest().getCommand(), e);
			return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
		}
	}

	@Override
	public String getName() {
		return ActionEnum.ACTIVITY_QUERY.getActionName();
	}
}
