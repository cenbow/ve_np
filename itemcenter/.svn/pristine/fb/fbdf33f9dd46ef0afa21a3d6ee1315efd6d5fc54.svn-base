package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.SpuPropertyTmplDTO;
import com.ve.itemcenter.common.domain.qto.SpuPropertyTmplQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface SpuPropertyTmplManager {

	/**
	 * 添加SPU属性模板
	 * 
	 * @param spuPropertyTmplDTO
	 * @return
	 * @throws ItemException
	 */
	public SpuPropertyTmplDTO addSpuPropertyTmpl(SpuPropertyTmplDTO spuPropertyTmplDTO) throws ItemException;

	/**
	 * 添加SPU属性模板
	 * 
	 * @param spuPropertyTmplDTO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateSpuPropertyTmpl(SpuPropertyTmplDTO spuPropertyTmplDTO) throws ItemException;

	/**
	 * 查看SPU属性模板
	 * 
	 * @param SpuPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public SpuPropertyTmplDTO getSpuPropertyTmpl(Long id) throws ItemException;

	/**
	 * 删除SPU属性模板
	 * 
	 * @param SpuPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteSpuPropertyTmpl(Long id) throws ItemException;

	/**
	 * 验证SpuPropertyTmplDTO
	 * 
	 * @param spuPropertyTmplDTO
	 * @return
	 * @throws ItemException
	 */
	public boolean verifySpuPropertyTmplDTOProperty(SpuPropertyTmplDTO spuPropertyTmplDTO) throws ItemException;

	/**
	 * 查询SPU属性模板列表
	 * 
	 * @param spuPropertyTmplQTO
	 * @return
	 * @throws ItemException
	 */
	public List<SpuPropertyTmplDTO> querySpuPropertyTmpl(SpuPropertyTmplQTO spuPropertyTmplQTO) throws ItemException;

}
