package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;
import com.ve.itemcenter.common.domain.qto.SkuPropertyQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface SkuPropertyManager {

	/**
	 * 添加SKU属性
	 * 
	 * @param skuId
	 * @param skuPropertyDO
	 * @return
	 * @throws ItemException
	 */
	public List<SkuPropertyDTO> addSkuProperty(Long skuId, Long sellerId, List<SkuPropertyDTO> skuPropertyDTOList)
			throws ItemException;

	/**
	 * 添加SKU属性
	 * 
	 * @param skuPropertyDTO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateSkuProperty(SkuPropertyDTO skuPropertyDTO) throws ItemException;

	/**
	 * 查看SKU属性
	 * 
	 * @param sellerId
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public SkuPropertyDTO getSkuProperty(Long id, Long sellerId) throws ItemException;

	/**
	 * 删除SKU属性
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteSkuProperty(Long id, Long sellerId) throws ItemException;

	/**
	 * 根据ItemSkuId批量删除SkuProperty
	 * 
	 * @param itemSkuId
	 * @return
	 * @throws ItemException
	 */
	public int deleteSkuPropertyListBySkuId(Long itemSkuId, Long sellerId) throws ItemException;

	/**
	 * 查询SKU属性列表
	 * 
	 * @param skuPropertyQTO
	 * @return
	 * @throws ItemException
	 */
	public List<SkuPropertyDTO> querySkuProperty(SkuPropertyQTO skuPropertyQTO) throws ItemException;

}
