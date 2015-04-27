package com.ve.marketingcenter.core.service.action.tool;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;
import com.ve.marketingcenter.core.domain.ToolDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.tool.ToolManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class GetToolAction implements Action<MarketingToolDTO> {
	private static final Logger log = LoggerFactory.getLogger(GetToolAction.class);
	
	@Resource(name = "toolManager")
	private ToolManager toolManager;

	@Override
	public MarketingResponse<MarketingToolDTO> execute(
			RequestContext<MarketingToolDTO> request) {
		String toolId = String.valueOf(request.getRequest()
				.getParam(MarketingConstant.REQUEST_PARAM_PRIMARY_KEY));
		Preconditions.checkArgument(StringUtils.isNotBlank(toolId),"工具id不能为空!");
		if(log.isDebugEnabled()){
			log.debug("tool id:"+toolId);
		}
		try {
			return MarketingUtils.getSuccessResponse(translate(toolManager.getTool(Long.valueOf(toolId))));
		} catch (MarketingException e) {
			log.error("Action:" + request.getRequest().getCommand(), e);
			return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
		}
	}
	
	private MarketingToolDTO translate(ToolDO toolDo){
		MarketingToolDTO dto = new MarketingToolDTO();
		MarketingUtils.copyProperties(toolDo, dto);
		return dto;
	}

	@Override
	public String getName() {
		return ActionEnum.TOOL_GET.getActionName();
	}
}
