package com.ve.deliverycenter.core.util;

import org.springframework.beans.BeanUtils;

import com.ve.deliverycenter.common.constant.RetCodeEnum;
import com.ve.deliverycenter.common.dto.BaseDTO;
import com.ve.deliverycenter.common.qto.BaseQTO;
import com.ve.deliverycenter.core.domain.BaseDo;
import com.ve.deliverycenter.core.exception.DeliveryException;

public class TransUtil {
	public static BaseDo trans2Do(BaseDTO dto, BaseDo domain)
			throws DeliveryException {
		if (dto == null) {
			return null;
		}
		checkNull(domain);
		BeanUtils.copyProperties(dto, domain);
		return domain;
	}

	public static BaseDTO trans2Dto(BaseDTO dto, BaseDo domain)
			throws DeliveryException {
		if (domain == null) {
			return null;
		}
		checkNull(dto);
		BeanUtils.copyProperties(domain, dto);
		return dto;
	}

	public static BaseQTO trans2Qto(BaseDTO dto, BaseQTO qto)
			throws DeliveryException {
		if (dto == null) {
			return null;
		}
		checkNull(qto);
		BeanUtils.copyProperties(dto, qto);
		return qto;
	}

	private static void checkNull(Object target) throws DeliveryException {
		if (target == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"trans target is null");
		}

	}
}
