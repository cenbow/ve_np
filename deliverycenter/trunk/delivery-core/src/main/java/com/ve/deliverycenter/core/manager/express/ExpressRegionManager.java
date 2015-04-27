package com.ve.deliverycenter.core.manager.express;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.dto.express.ExpressRegionDTO;
import com.ve.deliverycenter.common.qto.express.ExpressRegionQTO;
import com.ve.deliverycenter.core.exception.DeliveryException;

@Service
public interface ExpressRegionManager {

	public List<ExpressRegionDTO> queryExpressRegion(
			ExpressRegionQTO expressRegionQTO) throws DeliveryException;

}
