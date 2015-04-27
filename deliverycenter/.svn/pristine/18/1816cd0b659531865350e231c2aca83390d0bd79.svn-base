package com.ve.deliverycenter.client.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ve.deliverycenter.client.FeeClient;
import com.ve.deliverycenter.common.api.BaseRequest;
import com.ve.deliverycenter.common.api.DeliveryService;
import com.ve.deliverycenter.common.api.Request;
import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.fee.RegionDTO;
import com.ve.deliverycenter.common.dto.fee.RegionFeeDTO;
import com.ve.deliverycenter.common.dto.fee.StdFeeDTO;
import com.ve.deliverycenter.common.qto.fee.DeliveryFeeQTO;
import com.ve.deliverycenter.common.qto.fee.RegionQTO;
import com.ve.deliverycenter.common.qto.fee.StdFeeQTO;

public class FeeClientImpl implements FeeClient {
	@Resource
	private DeliveryService deliveryService;

	@Override
	public Response<RegionDTO> addRegion(RegionDTO regionDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_REGION.getActionName());
		request.setParam("regionDTO", regionDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<List<RegionFeeDTO>> addRegionFee(
			List<RegionFeeDTO> regionFeeDTOList) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_REGION_FEE.getActionName());
		request.setParam("regionFeeDTOList", regionFeeDTOList);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<StdFeeDTO> addStdFee(StdFeeDTO stdFeeDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_STDFEE.getActionName());
		request.setParam("stdFeeDTO", stdFeeDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> deleteRegion(Integer id) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_REGION.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> deleteRegionFee(List<Integer> regionFeeIdList) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_REGION_FEE.getActionName());
		request.setParam("regionFeeIdList", regionFeeIdList);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> deleteStdFee(Integer id) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_STDFEE.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<RegionDTO> getRegion(Integer id) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GET_REGION.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Long> queryDeliveryFee(DeliveryFeeQTO deliveryFeeQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_DELIVERYFEE.getActionName());
		request.setParam("deliveryFeeQTO", deliveryFeeQTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<List<RegionDTO>> queryRegion(RegionQTO regionQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_REGION.getActionName());
		request.setParam("regionQTO", regionQTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<List<StdFeeDTO>> queryStdFee(StdFeeQTO stdFeeQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_STDFEE.getActionName());
		request.setParam("stdFeeQTO", stdFeeQTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> updateRegion(RegionDTO regionDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_REGION.getActionName());
		request.setParam("regionDTO", regionDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> updateStdFee(StdFeeDTO stdFeeDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_STDFEE.getActionName());
		request.setParam("stdFeeDTO", stdFeeDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

}
