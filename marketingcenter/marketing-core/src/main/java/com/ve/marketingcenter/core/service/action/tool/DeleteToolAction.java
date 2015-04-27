package com.ve.marketingcenter.core.service.action.tool;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

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
public class DeleteToolAction implements Action<MarketingToolDTO> {
	private static final Logger log = LoggerFactory.getLogger(DeleteToolAction.class);
	
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
				String paramId = String.valueOf(request.getRequest()
						.getParam(MarketingConstant.REQUEST_PARAM_PRIMARY_KEY));
				
				if(StringUtils.isBlank(paramId)){
					//TODO exception
//					return MarketingUtils.getFailResponse(e.getCode(), e.getMessage());
				}
				Long id = Long.valueOf(paramId);
				try {
					toolManager.deleteTool(id);
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
		return ActionEnum.TOOL_DELETE.getActionName();
	}
}
