package com.ve.marketingcenter.client.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ve.marketingcenter.client.MarketingClient;
import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.FavorableInfo;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingFormalParamDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingActivityQTO;
import com.ve.marketingcenter.common.domain.qto.MarketingToolQTO;

public class MarketingClientImpl implements MarketingClient {
	
	@Resource
	private  MarketingService<MarketingActivityDTO> marketingService;

	@Override
	public List<FavorableInfo> getCartFavorableInfo(Long userId,
			String userType, List<MarketingItemDTO> items, Integer plateform) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FavorableInfo> getOrderFavorableInfo(Long userId,
			String userType, List<MarketingItemDTO> items, Integer plateform,
			List<ActivityCouponDTO> coupons) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolDTO> addTool(MarketingToolDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolQTO> queryTool(MarketingToolQTO qto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolDTO> getTool(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolDTO> updateTool(MarketingToolDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolDTO> deleteTool(long toolId, long deleteUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolDTO> submitToolAuditing(long toolId,
			long auditUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolDTO> auditToolApproved(long toolId,
			long auditUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingToolDTO> auditToolDenied(long toolId,
			long auditUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityDTO> addActivity(MarketingActivityDTO dto) {
		Request request = getRequest(dto);
		request.setCommand(ActionEnum.ACTIVITY_ADD.getActionName());
		return response4Activity(request);
	}

	@Override
	public List<MarketingFormalParamDTO> getToolParams(long toolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityQTO> queryActivity(MarketingActivityQTO qto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityDTO> updateActivity(
			MarketingActivityDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityDTO> submitActivityAuditing(
			List<Long> ids, long auditUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityDTO> auditActivityApproved(List<Long> ids,
			long auditUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityDTO> auditActivityDenied(List<Long> ids,
			long auditUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityDTO> deleteActivity(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<MarketingActivityDTO> cancelActivity(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	private Request getRequest(Object dto){
		Request request = new BaseRequest();
		request.setParam(MarketingConstant.REQUEST_PARAM_KEY_ENTITY, dto);
		return request;
	}
	
	private Response<MarketingActivityDTO> response4Activity( Request request){
		return marketingService.execute(request);
	}

	public void setMarketingService(
			MarketingService<MarketingActivityDTO> marketingService) {
		this.marketingService = marketingService;
	}
}
