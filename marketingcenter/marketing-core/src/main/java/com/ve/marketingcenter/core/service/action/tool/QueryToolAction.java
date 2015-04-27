package com.ve.marketingcenter.core.service.action.tool;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingToolQTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.tool.ToolManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class QueryToolAction implements Action<List<MarketingToolDTO>> {
	private static final Logger log = LoggerFactory.getLogger(QueryToolAction.class);
	
	@Resource(name = "toolManager")
	private ToolManager toolManager;

	@Override
	public MarketingResponse<List<MarketingToolDTO>> execute(
			RequestContext<List<MarketingToolDTO>> request) {
		MarketingToolQTO qto = (MarketingToolQTO) request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_KEY_ENTITY);
		
		if(qto == null){
			qto = new MarketingToolQTO();
			qto.setOffset(MarketingConstant.DEFAULT_PAGE_SIZE);
		}
		
		if(log.isDebugEnabled()){
			log.debug("MarketingToolDTO:"+JSONObject.toJSONString(qto, true));
		}
		
		int total = 0;
		List<MarketingToolDTO> result = null;
		try {
			total = toolManager.queryToolCount(qto);
			result = toolManager.queryTool(qto);
		} catch (MarketingException e) {
			log.error("Action:" + request.getRequest().getCommand(), e);
			return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
		}
		return MarketingUtils.getSuccessResponse(result,total);
	}

	@Override
	public String getName() {
		return ActionEnum.TOOL_QUERY.getActionName();
	}
}
