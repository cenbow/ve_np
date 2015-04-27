package com.ve.marketingcenter.core.service.action.formalParam;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingFormalParamDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingFormalParamQTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.formalParam.FormalParamManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class QueryToolParamAction implements Action<List<MarketingFormalParamDTO>> {
	private static final Logger log = LoggerFactory.getLogger(QueryToolParamAction.class);
	
	@Resource(name = "formalParamManager")
	private FormalParamManager formalParamManager;

	@Override
	public MarketingResponse<List<MarketingFormalParamDTO>> execute(
			RequestContext<List<MarketingFormalParamDTO>> request) {
		
		String param_id = String.valueOf(request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_PRIMARY_KEY));
		
		Preconditions.checkArgument(StringUtils.isNotBlank(param_id),"工具id不能为空!");
		if(log.isDebugEnabled()){
			log.debug("owner id:"+param_id);
		}
		
		MarketingFormalParamQTO qto = new MarketingFormalParamQTO();
		qto.setOwnerId(Long.valueOf(param_id));
		qto.setOwnerType( MarketingConstant.PARAM_OWNER_TYPE_TOOL);
		
	try {
		List<MarketingFormalParamDTO> result = formalParamManager.queryFormalParam(qto);
		return MarketingUtils.getSuccessResponse(result,result.size());
	} catch (MarketingException e) {
		log.error("Action:" + request.getRequest().getCommand(), e);
		return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
	}
}

	@Override
	public String getName() {
		return ActionEnum.ACTIVITY_QUERY_FORMAL_PARAM.getActionName();
	}
}
