package com.ve.deliverycenter.core.service.action.express;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.express.ExpressPropertyDTO;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.express.ExpressPropertyManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.TransAction;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class AddExpressProperty extends TransAction {
	@Resource
	private ExpressPropertyManager expressPropertyManager;

	/**
	 * 新增快递属性接口
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public DeliveryResponse doTransaction(RequestContext context)
			throws DeliveryException {
		// 获取参数
		List<ExpressPropertyDTO> expressPropertyDTOList = (List<ExpressPropertyDTO>) context
				.getRequest().getParam("expressPropertyDTOList");
		List<ExpressPropertyDTO> resultList = expressPropertyManager
				.addExpressProperty(expressPropertyDTOList);
		// 返回response对象
		return ResponseUtil.getResponse(resultList);

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.ADD_EXPRESS_PROPERTY.getActionName();
	}

}
