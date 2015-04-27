package com.ve.deliverycenter.client;

import java.util.List;

import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.dto.storage.StorageDTO;
import com.ve.deliverycenter.common.dto.storage.StorageSendDTO;
import com.ve.deliverycenter.common.qto.storage.StorageQTO;
import com.ve.deliverycenter.common.qto.storage.StorageSendQTO;

public interface StorageClient {
	/**
	 * 新增仓库
	 * 
	 * @param storageDTO
	 * @return
	 */
	public Response<StorageDTO> addStorage(StorageDTO storageDTO);

	/**
	 * 新增发货仓库
	 * 
	 * @param storageSendDTO
	 * @return
	 */
	public Response<StorageSendDTO> addStorageSend(StorageSendDTO storageSendDTO);

	/**
	 * 删除仓库
	 * 
	 * @param id
	 * @return
	 */
	public Response<Boolean> deleteStorage(Integer id);

	/**
	 * 删除发货仓库
	 * 
	 * @param id
	 * @return
	 */
	public Response<Boolean> deleteStorageSend(Integer id);

	/**
	 * 查询仓库
	 * 
	 * @param storageQTO
	 * @return
	 */
	public Response<List<StorageDTO>> queryStorage(StorageQTO storageQTO);

	/**
	 * 查询发货仓库
	 * 
	 * @param storageSendQTO
	 * @return
	 */
	public Response<List<StorageSendDTO>> queryStorageSend(
			StorageSendQTO storageSendQTO);

	/**
	 * 修改仓库
	 * 
	 * @param storageDTO
	 * @return
	 */
	public Response<Boolean> updateStorage(StorageDTO storageDTO);

	/**
	 * 修改发货仓库
	 * 
	 * @param storageSendDTO
	 * @return
	 */
	public Response<Boolean> updateStorageSend(StorageSendDTO storageSendDTO);

}
