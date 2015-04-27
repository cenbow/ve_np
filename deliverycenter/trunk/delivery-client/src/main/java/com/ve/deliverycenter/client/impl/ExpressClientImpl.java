package com.ve.deliverycenter.client.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ve.deliverycenter.client.ExpressClient;
import com.ve.deliverycenter.common.api.BaseRequest;
import com.ve.deliverycenter.common.api.DeliveryService;
import com.ve.deliverycenter.common.api.Request;
import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.express.ExpressDTO;
import com.ve.deliverycenter.common.dto.express.ExpressPropertyDTO;
import com.ve.deliverycenter.common.dto.express.ExpressRegionDTO;
import com.ve.deliverycenter.common.qto.express.ExpressQTO;

public class ExpressClientImpl implements ExpressClient {
	@Resource
	private DeliveryService deliveryService;

	@Override
	public Response<ExpressDTO> addExpress(ExpressDTO expressDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_EXPRESS.getActionName());
		request.setParam("expressDTO", expressDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<List<ExpressPropertyDTO>> addExpressProperty(
			List<ExpressPropertyDTO> expressPropertyDTOList) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_EXPRESS_PROPERTY.getActionName());
		request.setParam("expressPropertyDTOList", expressPropertyDTOList);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> checkRegionSupported(
			ExpressRegionDTO expressRegionDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CHECK_REGION_SUPPORTED.getActionName());
		request.setParam("expressRegionDTO", expressRegionDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> deleteExpress(Integer id) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_EXPRESS.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> deleteExpressProperty(
			List<Integer> expressPropertyIdList) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_EXPRESS_PROPERTY.getActionName());
		request.setParam("expressPropertyIdList", expressPropertyIdList);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<List<ExpressDTO>> queryExpress(ExpressQTO expressQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_EXPRESS.getActionName());
		request.setParam("expressQTO", expressQTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> updateExpress(ExpressDTO expressDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_EXPRESS.getActionName());
		request.setParam("expressDTO", expressDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

}
