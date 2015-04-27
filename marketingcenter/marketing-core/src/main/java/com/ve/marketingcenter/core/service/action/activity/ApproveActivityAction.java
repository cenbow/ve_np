package com.ve.marketingcenter.core.service.action.activity;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.google.common.base.Preconditions;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingTrackDTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.activity.ActivityManager;
import com.ve.marketingcenter.core.manager.track.AuditTrackManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class ApproveActivityAction implements Action<MarketingActivityDTO> {
	private static final Logger log = LoggerFactory.getLogger(ApproveActivityAction.class);
	
	@Resource(name = "activityManager")
	private ActivityManager activityManager;


	@Resource(name = "auditTrackManager")
	private AuditTrackManager auditTrackManager;
	
	@Resource(name = "transactionTemplate")
	TransactionTemplate transactionTemplate;
	
	@Override
	public MarketingResponse<MarketingActivityDTO> execute(
			final RequestContext<MarketingActivityDTO> request) {
		
		return transactionTemplate.execute(new TransactionCallback<MarketingResponse<MarketingActivityDTO>>(){
			@Override
			public MarketingResponse<MarketingActivityDTO> doInTransaction(TransactionStatus arg0) {
				String actId = String.valueOf(request.getRequest()
						.getParam(MarketingConstant.REQUEST_PARAM_PRIMARY_KEY));
				String paramUserId = String.valueOf(request.getRequest()
						.getParam(MarketingConstant.REQUEST_PARAM_USER_ID));
				
				Preconditions.checkArgument(StringUtils.isNotBlank(actId),"活动id不能为空!");
				Preconditions.checkArgument(StringUtils.isNotBlank(paramUserId),"审核者id不能为空!");
				if(log.isDebugEnabled()){
					log.debug("activity id:"+actId);
					log.debug("audit user id:"+paramUserId);
				}
				Long id = Long.valueOf(actId);
				Long userId = Long.valueOf(paramUserId);
				try {
					activityManager.updateActivityStatus(id,MarketingConstant.ACT_STATUS_APPROVED);
					auditTrackManager.addAuditTrack(getTrackDto(id,userId));
					return MarketingUtils.getSuccessResponse();
				} catch (MarketingException e) {
					arg0.setRollbackOnly();
					log.error("Action:" + request.getRequest().getCommand(), e);
					return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
				}
			}
		});
	}
	
	private MarketingTrackDTO getTrackDto(Long id,Long userId){
		MarketingTrackDTO track = new MarketingTrackDTO();
		track.setRecordedId(id);
		track.setOperatorId(userId);
		track.setAuditType(MarketingConstant.AUDIT_TYPE_CHECK);
		track.setRecordedType(MarketingConstant.PARAM_OWNER_TYPE_ACT);
		return track;
	}

	@Override
	public String getName() {
		return ActionEnum.ACTIVITY_AUDIT_APPROVED.getActionName();
	}
}
