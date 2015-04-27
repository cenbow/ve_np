package com.ve.deliverycenter.core.service.action.fee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.fee.RegionFeeDTO;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.fee.RegionFeeManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.TransAction;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class AddRegionFee extends TransAction {
	@Resource
	private RegionFeeManager regionFeeManager;

	/**
	 * 新增区域运费接口
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DeliveryResponse doTransaction(RequestContext context)
			throws DeliveryException {
		// 获取参数
		List<RegionFeeDTO> regionFeeDTOList = (List<RegionFeeDTO>) context
				.getRequest().getParam("regionFeeDTOList");
		List<RegionFeeDTO> resultList = regionFeeManager
				.addRegionFee(regionFeeDTOList);
		// 返回response对象
		return ResponseUtil.getResponse(resultList);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.ADD_REGION_FEE.getActionName();
	}

}
