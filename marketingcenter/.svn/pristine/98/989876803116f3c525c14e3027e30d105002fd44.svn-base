package com.ve.marketingcenter.core.service.action.activity;

import java.util.List;

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
import com.ve.marketingcenter.common.domain.dto.MarketingActualParamDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingScopeDTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.activity.ActivityManager;
import com.ve.marketingcenter.core.manager.actualParam.ActualParamManager;
import com.ve.marketingcenter.core.manager.scope.ScopeManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class AddActivityAction implements Action<MarketingActivityDTO> {
	private static final Logger log = LoggerFactory.getLogger(AddActivityAction.class);
	
	@Resource(name = "activityManager")
	private ActivityManager activityManager;
	
	@Resource(name = "scopeManager")
	private ScopeManager scopeManager;
	
//	@Resource(name = "formalParamManager")
//	private FormalParamManager formalParamManager;
	
	@Resource(name = "actualParamManager")
	private ActualParamManager actualParamManager;

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
					//保存活动
					dto.setId(activityManager.addActivity(dto));
					//保存活动的范围
					scopeManager.addBatchScope(setActIdToScopes(dto));
					//XXX 保存活动实参(形参挂在活动使用的工具上)，
					actualParamManager.addActualParams(setActIdToParams(dto));
					return MarketingUtils.getSuccessResponse();
				} catch (MarketingException e) {
					arg0.setRollbackOnly();
					log.error("Action:" + request.getRequest().getCommand(), e);
					return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
				}
			}
		});
	}
	
	private List<MarketingScopeDTO> setActIdToScopes(MarketingActivityDTO dto){
		List<MarketingScopeDTO> scopes = dto.getMarketScopes();
		for(MarketingScopeDTO scope:scopes){
			scope.setActId(dto.getId());
		}
		return scopes;
	}
	
	private List<MarketingActualParamDTO> setActIdToParams(MarketingActivityDTO dto){
		List<MarketingActualParamDTO> params = dto.getMarketParams();
		for(MarketingActualParamDTO param:params){
			param.setOwnerId(dto.getId());
		}
		return params;
	}
	
	/**
	 * 获取工具实参
	 * @param mdto
	 * @return
	 * @throws MarketingException
	 */
//	private List<MarketingActualParamDTO> getToolActualParams(MarketingActivityDTO mdto) throws MarketingException{
//		List<MarketingActualParamDTO> apdtos = new ArrayList<MarketingActualParamDTO>();
//		Long toolId = mdto.getToolId();
//		
//		MarketingFormalParamQTO qto = new MarketingFormalParamQTO();
//		qto.setOwnerId(toolId);
//		qto.setOwnerType(MarketingConstant.PARAM_OWNER_TYPE_TOOL);
//		
//		List<MarketingFormalParamDTO> formalDtos = formalParamManager.queryFormalParam(qto);
//		
//		Map<String,String> map = mdto.getToolParams();
//		for(MarketingFormalParamDTO fpdto : formalDtos){
//			String pName = fpdto.getParamName();
//			
//			if(!map.containsKey(pName)){
//				//TODO exception
//				throw new MarketingException();
//			}
//			MarketingActualParamDTO apdto = new MarketingActualParamDTO();
//			apdto.setActId(mdto.getId());
//			apdto.setOwnerId(toolId);
//			apdto.setOwnerType(MarketingConstant.PARAM_OWNER_TYPE_TOOL);
//			apdto.setParamName(pName);
//			apdto.setParamValue(map.get(pName));
//			apdtos.add(apdto);
//		}
//		return apdtos;
//	}

//	private List<MarketingScopeDTO> getScopeDtos(MarketingActivityDTO mdto){
//		List<MarketingScopeDTO> msdtos = new ArrayList<MarketingScopeDTO>();
//		
//		Map<String,List<Long>> scope_in = 
//				(Map<String,List<Long>>)(mdto.getScopeParams().get(MarketingConstant.ACT_SCOPE_PARAM_IN));
//		
//		Map<String,List<Long>> scope_ex = 
//				(Map<String,List<Long>>)(mdto.getScopeParams().get(MarketingConstant.ACT_SCOPE_PARAM_EX));
//		//是全场活动
//		if(scope_in.containsKey(MarketingConstant.ACT_PARAM_ALL)){
//			MarketingScopeDTO sdto = new MarketingScopeDTO();
//			sdto.setActId(mdto.getId());
//			sdto.setCludeType(MarketingConstant.GLOBAL_FLAG_YES);
//			sdto.setMarketType(MarketingConstant.ACTIVITY_SCOPE_ALL);
//			msdtos.add(sdto);
//		}else{
//			//包含的专场
//			List<Long> specialIds = scope_in.get(MarketingConstant.ACT_PARAM_SPECIAL);
//			if(CollectionUtils.isNotEmpty(specialIds)){
//				for(Long specialId:specialIds){
//					MarketingScopeDTO sdto = new MarketingScopeDTO();
//					sdto.setActId(mdto.getId());
//					sdto.setCludeType(MarketingConstant.GLOBAL_FLAG_YES);
//					sdto.setMarketType(MarketingConstant.ACTIVITY_SCOPE_SPC);
//					sdto.setCludeId(specialId);
//					msdtos.add(sdto);
//				}
//			}
//			
//			//包含的单品
//			List<Long> itemIds = scope_in.get(MarketingConstant.ACT_PARAM_ITEM);
//			if(CollectionUtils.isNotEmpty(itemIds)){
//				for(Long itemId:itemIds){
//					MarketingScopeDTO sdto = new MarketingScopeDTO();
//					sdto.setActId(mdto.getId());
//					sdto.setCludeType(MarketingConstant.GLOBAL_FLAG_YES);
//					sdto.setMarketType(MarketingConstant.ACTIVITY_SCOPE_SIG);
//					sdto.setCludeId(itemId);
//					msdtos.add(sdto);
//				}
//			}
//		}
//		
//		if(scope_ex != null && !scope_ex.isEmpty()){
//			//不包含的专场
//			List<Long> specialIds = scope_ex.get(MarketingConstant.ACT_PARAM_SPECIAL);
//			if(CollectionUtils.isNotEmpty(specialIds)){
//				for(Long specialId:specialIds){
//					MarketingScopeDTO sdto = new MarketingScopeDTO();
//					sdto.setActId(mdto.getId());
//					sdto.setCludeType(MarketingConstant.GLOBAL_FLAG_NO);
//					sdto.setMarketType(MarketingConstant.ACTIVITY_SCOPE_SPC);
//					sdto.setCludeId(specialId);
//					msdtos.add(sdto);
//				}
//			}
//			
//			//不包含的单品
//			List<Long> itemIds = scope_ex.get(MarketingConstant.ACT_PARAM_ITEM);
//			if(CollectionUtils.isNotEmpty(itemIds)){
//				for(Long itemId:itemIds){
//					MarketingScopeDTO sdto = new MarketingScopeDTO();
//					sdto.setActId(mdto.getId());
//					sdto.setCludeType(MarketingConstant.GLOBAL_FLAG_NO);
//					sdto.setMarketType(MarketingConstant.ACTIVITY_SCOPE_SIG);
//					sdto.setCludeId(itemId);
//					msdtos.add(sdto);
//				}
//			}
//		}
//		return msdtos;
//	}
	
	@Override
	public String getName() {
		return ActionEnum.ACTIVITY_ADD.getActionName();
	}
}
