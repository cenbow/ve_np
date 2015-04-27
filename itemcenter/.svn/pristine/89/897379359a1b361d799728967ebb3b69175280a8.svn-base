package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.ItemPropertyTmplDTO;
import com.ve.itemcenter.common.domain.qto.ItemPropertyTmplQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface ItemPropertyTmplManager {

	/**
	 * 添加商品属性模板
	 * 
	 * @param ItemPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public ItemPropertyTmplDTO addItemPropertyTmpl(ItemPropertyTmplDTO itemPropertyTmplDTO) throws ItemException;

	/**
	 * 添加商品属性模板
	 * 
	 * @param ItemPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateItemPropertyTmpl(ItemPropertyTmplDTO itemPropertyTmplDTO) throws ItemException;

	/**
	 * 查看商品属性模板
	 * 
	 * @param ItemPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public ItemPropertyTmplDTO getItemPropertyTmpl(Long id) throws ItemException;

	/**
	 * 删除商品属性模板
	 * 
	 * @param ItemPropertyTmplDO
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteItemPropertyTmpl(Long id) throws ItemException;


	/**
	 * 查询商品属性模板列表
	 * 
	 * @param itemPropertyTmplQTO
	 * @return
	 * @throws ItemException
	 */
	public List<ItemPropertyTmplDTO> queryItemPropertyTmpl(ItemPropertyTmplQTO itemPropertyTmplQTO)
			throws ItemException;

}
