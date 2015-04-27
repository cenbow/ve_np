package com.ve.deliverycenter.core.manager.express;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.dto.express.ExpressDTO;
import com.ve.deliverycenter.common.qto.express.ExpressQTO;
import com.ve.deliverycenter.core.domain.express.Express;
import com.ve.deliverycenter.core.exception.DeliveryException;

@Service
public interface ExpressManager {

	public ExpressDTO addExpress(ExpressDTO expressDTO)
			throws DeliveryException;

	public int updateExpress(ExpressDTO expressDTO) throws DeliveryException;

	public int deleteExpress(Integer id) throws DeliveryException;

	public List<ExpressDTO> queryExpress(ExpressQTO expressQTO)
			throws DeliveryException;

	public Express getExpress(Integer expressId) throws DeliveryException;

}
