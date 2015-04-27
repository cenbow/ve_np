package com.ve.deliverycenter.core.service.action.express;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.express.ExpressDTO;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.express.ExpressManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.Action;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class UpdateExpress implements Action {
	@Resource
	ExpressManager expressManager;

	/**
	 * 修改快递接口
	 */
	@Override
	public DeliveryResponse execute(RequestContext context)
			throws DeliveryException {
		// 获取参数
		ExpressDTO expressDTO = (ExpressDTO) context.getRequest().getParam(
				"expressDTO");
		expressManager.updateExpress(expressDTO);
		// 返回response对象
		return ResponseUtil.getResponse(true);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.UPDATE_EXPRESS.getActionName();
	}
}
