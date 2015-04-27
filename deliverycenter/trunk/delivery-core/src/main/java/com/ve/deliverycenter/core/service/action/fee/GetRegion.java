package com.ve.deliverycenter.core.service.action.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.fee.RegionDTO;
import com.ve.deliverycenter.core.domain.fee.Region;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.fee.RegionManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.Action;
import com.ve.deliverycenter.core.util.ResponseUtil;
import com.ve.deliverycenter.core.util.TransUtil;

@Service
public class GetRegion implements Action {
	@Resource
	RegionManager regionManager;

	/**
	 * 根据ID查询区域接口
	 */
	@Override
	public DeliveryResponse execute(RequestContext context)
			throws DeliveryException {
		// 获取参数
		Integer id = (Integer) context.getRequest().getParam("id");
		// 根据ID查询
		Region region = regionManager.getRegion(id);
		// 创建一个DtO
		RegionDTO regionDTO = new RegionDTO();
		// DO转换成DTO
		regionDTO = (RegionDTO) TransUtil.trans2Dto(regionDTO, region);
		return ResponseUtil.getResponse(regionDTO);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.GET_REGION.getActionName();
	}
}
