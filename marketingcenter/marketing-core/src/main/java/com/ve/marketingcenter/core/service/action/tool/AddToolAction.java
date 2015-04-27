package com.ve.marketingcenter.core.service.action.tool;

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
import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.tool.ToolManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.MarketingUtils;
@Service
public class AddToolAction implements Action<MarketingToolDTO> {
	private static final Logger log = LoggerFactory.getLogger(AddToolAction.class);
	
	@Resource(name = "toolManager")
	private ToolManager toolManager;

	@Resource(name = "transactionTemplate")
	TransactionTemplate transactionTemplate;
	
	@Override
	public MarketingResponse<MarketingToolDTO> execute(
				final RequestContext<MarketingToolDTO> request) {
		
		return transactionTemplate.execute(new TransactionCallback<MarketingResponse<MarketingToolDTO>>(){
			@Override
			public MarketingResponse<MarketingToolDTO> doInTransaction(TransactionStatus arg0) {
				MarketingToolDTO dto = (MarketingToolDTO) request.getRequest()
						.getParam(MarketingConstant.REQUEST_PARAM_KEY_ENTITY);
				Preconditions.checkArgument(dto != null,"工具对象为null!");
				if(log.isDebugEnabled()){
					log.debug("MarketingToolDTO:"+JSONObject.toJSONString(dto, true));
				}
				try {
					dto.setId(toolManager.addTool(dto));
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
		return ActionEnum.TOOL_ADD.getActionName();
	}
}
