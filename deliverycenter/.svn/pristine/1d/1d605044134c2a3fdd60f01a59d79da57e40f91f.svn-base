package com.ve.deliverycenter.core.manager.fee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.dto.fee.StdFeeDTO;
import com.ve.deliverycenter.common.qto.fee.StdFeeQTO;
import com.ve.deliverycenter.core.domain.fee.StdFee;
import com.ve.deliverycenter.core.exception.DeliveryException;

@Service
public interface StdFeeManager {

	public StdFeeDTO addStdFee(StdFeeDTO StdFeeDTO) throws DeliveryException;

	public int updateStdFee(StdFeeDTO StdFeeDTO) throws DeliveryException;

	public int deleteStdFee(Integer id) throws DeliveryException;

	public List<StdFeeDTO> queryStdFee(StdFeeQTO stdFeeQTO)
			throws DeliveryException;

	public StdFee getStdFee(Integer feeId) throws DeliveryException;

}
