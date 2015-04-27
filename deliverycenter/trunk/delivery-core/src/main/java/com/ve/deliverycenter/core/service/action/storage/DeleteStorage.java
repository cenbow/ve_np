package com.ve.deliverycenter.core.service.action.storage;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.storage.StorageManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.Action;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class DeleteStorage implements Action {
	@Resource
	StorageManager storageManager;

	/**
	 * 删除仓库接口
	 */
	@Override
	public DeliveryResponse execute(RequestContext context)
			throws DeliveryException {
		// 获取参数
		Integer id = (Integer) context.getRequest().getParam("id");
		// 删除仓库
		storageManager.deleteStorage(id);
		// 返回response对象
		return ResponseUtil.getResponse(true);

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.DELETE_STORAGE.getActionName();
	}
}
