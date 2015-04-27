package com.ve.deliverycenter.core.manager.storage;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.dto.storage.StorageSendDTO;
import com.ve.deliverycenter.common.qto.storage.StorageSendQTO;
import com.ve.deliverycenter.core.domain.storage.StorageSend;
import com.ve.deliverycenter.core.exception.DeliveryException;

@Service
public interface StorageSendManager {

	public StorageSendDTO addStorageSend(StorageSendDTO StorageSendDTO)
			throws DeliveryException;

	public int updateStorageSend(StorageSendDTO StorageSendDTO)
			throws DeliveryException;

	public int deleteStorageSend(Integer id) throws DeliveryException;

	public List<StorageSendDTO> queryStorageSend(StorageSendQTO storageSendQTO)
			throws DeliveryException;

	public StorageSend getStorageSend(Integer storageSendId)
			throws DeliveryException;

}
