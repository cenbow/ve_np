package com.ve.deliverycenter.core.service.action.storage;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.storage.StorageSendManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.Action;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class DeleteStorageSend implements Action {
	@Resource
	StorageSendManager storageSendManager;

	/**
	 * 删除发货仓库接口
	 */
	@Override
	public DeliveryResponse execute(RequestContext context)
			throws DeliveryException {
		// 获取参数
		Integer id = (Integer) context.getRequest().getParam("id");
		// 删除发货仓库
		storageSendManager.deleteStorageSend(id);
		// 返回response对象
		return ResponseUtil.getResponse(true);

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.DELETE_STORAGE_SEND.getActionName();
	}
}
