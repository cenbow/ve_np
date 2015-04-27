package com.ve.deliverycenter.core.service.action.fee;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.api.DeliveryResponse;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.fee.RegionFeeDTO;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.fee.RegionFeeManager;
import com.ve.deliverycenter.core.manager.fee.StdFeeManager;
import com.ve.deliverycenter.core.service.RequestContext;
import com.ve.deliverycenter.core.service.action.TransAction;
import com.ve.deliverycenter.core.util.ResponseUtil;

@Service
public class DeleteStdFee extends TransAction {
	@Resource
	StdFeeManager stdFeeManager;
	@Resource
	RegionFeeManager regionFeeManager;

	/**
	 * 删除运费标准接口
	 */
	@Override
	public DeliveryResponse doTransaction(RequestContext context)
			throws DeliveryException {
		// 获取参数
		Integer id = (Integer) context.getRequest().getParam("id");
		// 根据运费标准ID查询区域运费标准
		List<RegionFeeDTO> regionFeeDTOList = regionFeeManager.queryByFeeId(id);
		List<Integer> regionFeeIdList = new ArrayList();
		for (RegionFeeDTO regionFeeDTO : regionFeeDTOList) {
			regionFeeIdList.add(regionFeeDTO.getId());
		}
		// 批量删除区域运费
		regionFeeManager.deleteRegionFee(regionFeeIdList);
		// 删除运费标准
		stdFeeManager.deleteStdFee(id);
		// 返回response对象
		return ResponseUtil.getResponse(true);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.DELETE_STDFEE.getActionName();
	}
}
