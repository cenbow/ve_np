package com.ve.deliverycenter.core.manager.fee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.dto.fee.RegionDTO;
import com.ve.deliverycenter.common.qto.fee.RegionQTO;
import com.ve.deliverycenter.core.domain.fee.Region;
import com.ve.deliverycenter.core.exception.DeliveryException;

@Service
public interface RegionManager {

	public RegionDTO addRegion(RegionDTO RegionDTO) throws DeliveryException;

	public int updateRegion(RegionDTO RegionDTO) throws DeliveryException;

	public int deleteRegion(Integer id) throws DeliveryException;

	public List<RegionDTO> queryRegion(RegionQTO regionQTO)
			throws DeliveryException;

	public Region getRegion(Integer regionId) throws DeliveryException;

}
