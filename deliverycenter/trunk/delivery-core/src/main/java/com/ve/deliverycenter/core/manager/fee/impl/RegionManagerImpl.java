package com.ve.deliverycenter.core.manager.fee.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.deliverycenter.common.constant.RetCodeEnum;
import com.ve.deliverycenter.common.dto.fee.RegionDTO;
import com.ve.deliverycenter.common.qto.fee.RegionQTO;
import com.ve.deliverycenter.core.domain.BaseDo;
import com.ve.deliverycenter.core.domain.fee.Region;
import com.ve.deliverycenter.core.exception.DeliveryException;
import com.ve.deliverycenter.core.manager.BaseManager;
import com.ve.deliverycenter.core.manager.fee.RegionManager;
import com.ve.deliverycenter.core.util.TransUtil;

@Service
public class RegionManagerImpl extends BaseManager implements RegionManager {

	@Override
	public RegionDTO addRegion(RegionDTO regionDTO) throws DeliveryException {
		if (regionDTO == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"regionDTO is null");
		}
		// 创建一个DO
		Region region = new Region();
		// DTO转换成DO
		region = (Region) TransUtil.trans2Do(regionDTO, region);
		// 处理地区级别，
		// 如果父ID为0，级别为1国，否则级别设置为上层级别+1
		if (regionDTO.getParentId() == 0) {
			region.setRegionLevel(1);
		} else {
			Region parentRegion = this.getRegion(regionDTO.getParentId());
			if (parentRegion == null) {
				throw new DeliveryException(
						RetCodeEnum.PARAMETER_ERROR.getCode(),
						"parent regionid not exist");
			}
			region.setRegionLevel(parentRegion.getRegionLevel() + 1);
		}
		// 执行新增操作
		region = (Region) getBaseDao().insert(region);
		// DO转换成DTO
		regionDTO = (RegionDTO) TransUtil.trans2Dto(regionDTO, region);
		return regionDTO;
	}

	@Override
	public int updateRegion(RegionDTO regionDTO) throws DeliveryException {
		if (regionDTO == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"regionDTO is null");
		}
		// 创建一个DO
		BaseDo region = new Region();
		// DTO转换成DO
		region = TransUtil.trans2Do(regionDTO, region);
		// 执行更新操作
		int row = getBaseDao().update(region);
		if (row != 1) {
			throw new DeliveryException(RetCodeEnum.UPDATE_ERROR);
		}
		return row;
	}

	@Override
	public int deleteRegion(Integer id) throws DeliveryException {
		if (id == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"id is null");
		}
		// 校验是否存在子区域，如存在不允许删除
		RegionQTO regionQTO = new RegionQTO();
		regionQTO.setPageNo(1);
		regionQTO.setPageSize(1);
		regionQTO.setParentId(id);
		List<RegionDTO> regionDTOList = this.queryRegion(regionQTO);
		if (regionDTOList.size() > 0) {
			throw new DeliveryException(RetCodeEnum.SUB_REGION_EXIST);
		}
		// 创建一个DO
		Region region = new Region();
		// DO赋值逻辑删除
		region.setId(id);
		region.setDeleted(1);
		// 执行更新操作
		int row = getBaseDao().update(region);
		if (row != 1) {
			throw new DeliveryException(RetCodeEnum.DELETE_ERROR);
		}
		return row;
	}

	@Override
	public List queryRegion(RegionQTO regionQTO) throws DeliveryException {
		if (regionQTO == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"regionQTO is null");
		}
		List<BaseDo> regionList = query(regionQTO);
		List<RegionDTO> regionDTOList = new ArrayList<RegionDTO>();
		for (BaseDo region : regionList) {
			// 创建一个DtO
			RegionDTO regionDTO = new RegionDTO();
			// DO转换成DTO
			regionDTO = (RegionDTO) TransUtil.trans2Dto(regionDTO, region);
			regionDTOList.add(regionDTO);
		}
		return regionDTOList;
	}

	@Override
	public Region getRegion(Integer regionId) throws DeliveryException {
		if (regionId == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"regionId is null");
		}
		Region region = new Region();
		region.setId(regionId);
		return (Region) getBaseDao().get(region);
	}

}
