package com.ve.deliverycenter.client.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ve.deliverycenter.client.StorageClient;
import com.ve.deliverycenter.common.api.BaseRequest;
import com.ve.deliverycenter.common.api.DeliveryService;
import com.ve.deliverycenter.common.api.Request;
import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.storage.StorageDTO;
import com.ve.deliverycenter.common.dto.storage.StorageSendDTO;
import com.ve.deliverycenter.common.qto.storage.StorageQTO;
import com.ve.deliverycenter.common.qto.storage.StorageSendQTO;

public class StorageClientImpl implements StorageClient {
	@Resource
	private DeliveryService deliveryService;

	@Override
	public Response<StorageDTO> addStorage(StorageDTO storageDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_STORAGE.getActionName());
		request.setParam("storageDTO", storageDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<StorageSendDTO> addStorageSend(StorageSendDTO storageSendDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_STORAGE_SEND.getActionName());
		request.setParam("storageSendDTO", storageSendDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> deleteStorage(Integer id) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_STORAGE.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> deleteStorageSend(Integer id) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_STORAGE_SEND.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<List<StorageDTO>> queryStorage(StorageQTO storageQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_STORAGE.getActionName());
		request.setParam("storageQTO", storageQTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<List<StorageSendDTO>> queryStorageSend(
			StorageSendQTO storageSendQTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_STORAGE_SEND.getActionName());
		request.setParam("storageSendQTO", storageSendQTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> updateStorage(StorageDTO storageDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_STORAGE.getActionName());
		request.setParam("storageDTO", storageDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

	@Override
	public Response<Boolean> updateStorageSend(StorageSendDTO storageSendDTO) {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_STORAGE_SEND.getActionName());
		request.setParam("storageSendDTO", storageSendDTO);
		// 执行分发执行对应Action
		return deliveryService.execute(request);
	}

}
