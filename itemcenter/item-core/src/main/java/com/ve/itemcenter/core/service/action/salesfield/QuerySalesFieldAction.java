package com.ve.itemcenter.core.service.action.salesfield;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.SalesFieldDTO;
import com.ve.itemcenter.common.domain.qto.SalesFieldQTO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.SalesFieldManager;
import com.ve.itemcenter.core.service.ItemRequest;
import com.ve.itemcenter.core.service.RequestContext;
import com.ve.itemcenter.core.service.action.Action;
import com.ve.itemcenter.core.util.ResponseUtil;

/**
 * 查询专场列表Action
 * 
 * @author chen.huang
 *
 */
@Service
public class QuerySalesFieldAction implements Action {
	private static final Logger log = LoggerFactory.getLogger(QuerySalesFieldAction.class);
	@Resource
	private SalesFieldManager salesFieldManager;

	@Override
	public ItemResponse execute(RequestContext context) throws ItemException {
		ItemResponse response = null;
		ItemRequest request = context.getRequest();
		if (request.getParam("salesFieldQTO") == null) {
			return ResponseUtil.getErrorResponse(ResCodeNum.PARAM_E_MISSING, "salesFieldQTO is null");
		}
		SalesFieldQTO salesFieldQTO = (SalesFieldQTO) request.getParam("salesFieldQTO");

		try {
			List<SalesFieldDTO> salesFieldDTOList = salesFieldManager.querySalesField(salesFieldQTO);
			response = ResponseUtil.getSuccessResponse(salesFieldDTOList, salesFieldQTO.getTotalCount());
			return response;
		} catch (ItemException e) {
			response = ResponseUtil.getErrorResponse(e.getErrorCode(), e.getMessage());
			log.error("do action:" + request.getCommand() + " occur Exception:" + e.getMessage(), e);
			return response;
		}

	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_SALES_FIELD.getActionName();
	}
}
