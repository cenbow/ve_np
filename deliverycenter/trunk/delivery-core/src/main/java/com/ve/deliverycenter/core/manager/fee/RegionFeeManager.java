package com.ve.deliverycenter.core.manager.fee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.dto.fee.RegionFeeDTO;
import com.ve.deliverycenter.core.exception.DeliveryException;

@Service
public interface RegionFeeManager {
	public List<RegionFeeDTO> addRegionFee(List<RegionFeeDTO> regionFeeDTOList)
			throws DeliveryException;

	public int deleteRegionFee(List<Integer> regionFeeIdList)
			throws DeliveryException;

	public List<RegionFeeDTO> queryByFeeId(Integer feeId)
			throws DeliveryException;

}
