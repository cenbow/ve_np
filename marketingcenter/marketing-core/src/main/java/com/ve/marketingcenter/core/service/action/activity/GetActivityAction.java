package com.ve.marketingcenter.core.service.action.activity;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.activity.ActivityManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class GetActivityAction implements Action<MarketingActivityDTO> {
	private static final Logger log = LoggerFactory.getLogger(GetActivityAction.class);
	
	@Resource(name = "activityManager")
	private ActivityManager activityManager;

	@Override
	public MarketingResponse<MarketingActivityDTO> execute(
			RequestContext<MarketingActivityDTO> request) {
		String actId = String.valueOf(request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_PRIMARY_KEY));
		
		Preconditions.checkArgument(StringUtils.isNotBlank(actId),"活动id不能为空!");
		if(log.isDebugEnabled()){
			log.debug("activity id:"+actId);
		}
		try {
			return MarketingUtils.getSuccessResponse(activityManager.getActivity(Long.valueOf(actId)));
		} catch (MarketingException e) {
			log.error("Action:" + request.getRequest().getCommand(), e);
			return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
		}
	}

	@Override
	public String getName() {
		return ActionEnum.ACTIVITY_GET.getActionName();
	}
}
