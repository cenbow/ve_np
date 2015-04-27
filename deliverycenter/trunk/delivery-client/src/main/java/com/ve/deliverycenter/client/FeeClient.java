package com.ve.deliverycenter.client;

import java.util.List;

import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.dto.fee.RegionDTO;
import com.ve.deliverycenter.common.dto.fee.RegionFeeDTO;
import com.ve.deliverycenter.common.dto.fee.StdFeeDTO;
import com.ve.deliverycenter.common.qto.fee.DeliveryFeeQTO;
import com.ve.deliverycenter.common.qto.fee.RegionQTO;
import com.ve.deliverycenter.common.qto.fee.StdFeeQTO;

public interface FeeClient {
	/**
	 * 新增区域
	 * 
	 * @param regionDTO
	 * @return
	 */
	public Response<RegionDTO> addRegion(RegionDTO regionDTO);

	/**
	 * 新增区域运费
	 * 
	 * @param regionFeeDTOList
	 * @return
	 */
	public Response<List<RegionFeeDTO>> addRegionFee(
			List<RegionFeeDTO> regionFeeDTOList);

	/**
	 * 新增运费标准
	 * 
	 * @param stdFeeDTO
	 * @return
	 */
	public Response<StdFeeDTO> addStdFee(StdFeeDTO stdFeeDTO);

	/**
	 * 删除区域
	 * 
	 * @param id
	 * @return
	 */
	public Response<Boolean> deleteRegion(Integer id);

	/**
	 * 删除区域运费
	 * 
	 * @param regionFeeIdList
	 * @return
	 */
	public Response<Boolean> deleteRegionFee(List<Integer> regionFeeIdList);

	/**
	 * 删除运费标准
	 * 
	 * @param id
	 * @return
	 */
	public Response<Boolean> deleteStdFee(Integer id);

	/**
	 * 根据ID查询区域
	 * 
	 * @param id
	 * @return
	 */
	public Response<RegionDTO> getRegion(Integer id);

	/**
	 * 查询运费
	 * 
	 * @param deliveryFeeQTO
	 * @return
	 */
	public Response<Long> queryDeliveryFee(DeliveryFeeQTO deliveryFeeQTO);

	/**
	 * 查询区域
	 * 
	 * @param regionQTO
	 * @return
	 */
	public Response<List<RegionDTO>> queryRegion(RegionQTO regionQTO);

	/**
	 * 查询运费标准
	 * 
	 * @param stdFeeQTO
	 * @return
	 */
	public Response<List<StdFeeDTO>> queryStdFee(StdFeeQTO stdFeeQTO);

	/**
	 * 修改区域
	 * 
	 * @param regionDTO
	 * @return
	 */
	public Response<Boolean> updateRegion(RegionDTO regionDTO);

	/**
	 * 修改运费标准
	 * 
	 * @param stdFeeDTO
	 * @return
	 */
	public Response<Boolean> updateStdFee(StdFeeDTO stdFeeDTO);

}
