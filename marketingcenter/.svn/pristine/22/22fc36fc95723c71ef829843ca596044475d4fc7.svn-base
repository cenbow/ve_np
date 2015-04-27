package com.ve.marketingcenter.core.service.action.activity;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.fastjson.JSONObject;
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
public class UpdateActivityAction implements Action<MarketingActivityDTO> {
	private static final Logger log = LoggerFactory.getLogger(UpdateActivityAction.class);
	
	@Resource(name = "activityManager")
	private ActivityManager activityManager;
	
	@Resource(name = "transactionTemplate")
	TransactionTemplate transactionTemplate;

	@Override
	public MarketingResponse<MarketingActivityDTO> execute(
			final RequestContext<MarketingActivityDTO> request) {
		
		return transactionTemplate.execute(new TransactionCallback<MarketingResponse<MarketingActivityDTO>>(){
			@Override
			public MarketingResponse<MarketingActivityDTO> doInTransaction(TransactionStatus arg0) {
				MarketingActivityDTO dto = (MarketingActivityDTO) request.getRequest()
						.getParam(MarketingConstant.REQUEST_PARAM_KEY_ENTITY);
				
				Preconditions.checkArgument(dto != null,"活动对象为null!");
				if(log.isDebugEnabled()){
					log.debug("MarketingActivityDTO:"+JSONObject.toJSONString(dto, true));
				}
				try {
					activityManager.updateActivity(dto);
					return MarketingUtils.getSuccessResponse();
				} catch (MarketingException e) {
					arg0.setRollbackOnly();
					log.error("Action:" + request.getRequest().getCommand(), e);
					return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
				}
			}
		});
	}

	@Override
	public String getName() {
		return ActionEnum.ACTIVITY_UPDATE.getActionName();
	}
}
