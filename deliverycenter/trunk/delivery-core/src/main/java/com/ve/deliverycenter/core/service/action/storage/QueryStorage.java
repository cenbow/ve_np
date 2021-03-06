package com.ve.deliverycenter.core.service.action.storage;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.storage.StorageDTO;
import com.ve.deliverycenter.common.qto.storage.StorageQTO;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.storage.StorageManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.Action;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class QueryStorage implements Action {
	@Resource
	StorageManager storageManager;

	/**
	 * 查询仓库接口
	 */
	@Override
	public DeliveryResponse execute(RequestContext context)
			throws DeliveryException {
		// 获取参数
		StorageQTO storageQTO = (StorageQTO) context.getRequest().getParam(
				"storageQTO");
		// 根据QTO查询条件进行分页查询
		List<StorageDTO> modelList = storageManager.queryStorage(storageQTO);
		return ResponseUtil.getResponse(modelList, storageQTO.getTotalCount());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.QUERY_STORAGE.getActionName();
	}
}
