package com.ve.deliverycenter.core.service.action.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.fee.RegionDTO;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.fee.RegionManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.Action;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class AddRegion implements Action {
	@Resource
	RegionManager regionManager;

	/**
	 * 新增区域接口
	 */
	@Override
	public DeliveryResponse execute(RequestContext context)
			throws DeliveryException {

		// 获取参数
		RegionDTO regionDTO = (RegionDTO) context.getRequest().getParam(
				"regionDTO");
		// 新增区域
		regionManager.addRegion(regionDTO);
		// 返回response对象
		return ResponseUtil.getResponse(regionDTO);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.ADD_REGION.getActionName();
	}
}
