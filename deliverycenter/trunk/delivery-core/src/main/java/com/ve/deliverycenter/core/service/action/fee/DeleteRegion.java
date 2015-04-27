package com.ve.deliverycenter.core.service.action.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.fee.RegionManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.Action;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class DeleteRegion implements Action {
	@Resource
	RegionManager regionManager;

	/**
	 * 删除区域接口
	 */
	@Override
	public DeliveryResponse execute(RequestContext context)
			throws DeliveryException {
		// 获取参数
		Integer id = (Integer) context.getRequest().getParam("id");
		// 删除区域
		regionManager.deleteRegion(id);
		// 返回response对象
		return ResponseUtil.getResponse(true);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.DELETE_REGION.getActionName();
	}
}
