package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.SkuPropertyTmplDTO;
import com.ve.itemcenter.common.domain.qto.SkuPropertyTmplQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface SkuPropertyTmplManager {

	/**
	 * 添加SKU属性模板
	 * 
	 * @param SkuPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public SkuPropertyTmplDTO addSkuPropertyTmpl(SkuPropertyTmplDTO SkuPropertyTmplDTO) throws ItemException;

	/**
	 * 添加SKU属性模板
	 * 
	 * @param SkuPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateSkuPropertyTmpl(SkuPropertyTmplDTO SkuPropertyTmplDTO) throws ItemException;

	/**
	 * 查看SKU属性模板
	 * 
	 * @param SkuPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public SkuPropertyTmplDTO getSkuPropertyTmpl(Long id) throws ItemException;

	/**
	 * 删除SKU属性模板
	 * 
	 * @param SkuPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteSkuPropertyTmpl(Long id) throws ItemException;

	/**
	 * 查询SKU属性模板列表
	 * 
	 * @param SkuPropertyTmplQTO
	 * @return
	 * @throws ItemException
	 */
	public List<SkuPropertyTmplDTO> querySkuPropertyTmpl(SkuPropertyTmplQTO SkuPropertyTmplQTO) throws ItemException;

}
