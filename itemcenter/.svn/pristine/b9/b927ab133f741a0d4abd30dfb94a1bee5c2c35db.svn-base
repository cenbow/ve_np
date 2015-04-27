package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.ItemCategoryDTO;
import com.ve.itemcenter.common.domain.qto.ItemCategoryQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface ItemCategoryManager {

	/**
	 * 添加增加商品类目(ItemCategory)
	 * 
	 * @param itemCategoryDO
	 * @return
	 * @throws ItemException
	 */
	public ItemCategoryDTO addItemCategory(ItemCategoryDTO itemCategoryDTO) throws ItemException;

	/**
	 * 添加增加商品类目(ItemCategory)
	 * 
	 * @param itemCategoryDTO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateItemCategory(ItemCategoryDTO itemCategoryDTO) throws ItemException;

	/**
	 * 查看增加商品类目(ItemCategory)
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public ItemCategoryDTO getItemCategory(Integer id) throws ItemException;

	/**
	 * 删除增加商品类目(ItemCategory)
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteItemCategory(Integer id) throws ItemException;

	/**
	 * 查询增加商品类目(ItemCategory)列表
	 * 
	 * @param itemCategoryQTO
	 * @return
	 * @throws ItemException
	 */
	public List<ItemCategoryDTO> queryItemCategory(ItemCategoryQTO itemCategoryQTO) throws ItemException;

}
