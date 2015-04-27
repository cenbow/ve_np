package com.ve.deliverycenter.core.manager.express;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.dto.express.ExpressPropertyDTO;
import com.ve.deliverycenter.core.exception.DeliveryException;

@Service
public interface ExpressPropertyManager {
	public List<ExpressPropertyDTO> addExpressProperty(
			List<ExpressPropertyDTO> expressPropertyDTOList)
			throws DeliveryException;

	public int deleteExpressProperty(List<Integer> expressPropertyIdList)
			throws DeliveryException;

	public List<ExpressPropertyDTO> queryByExpressId(Integer expressId)
			throws DeliveryException;

}
