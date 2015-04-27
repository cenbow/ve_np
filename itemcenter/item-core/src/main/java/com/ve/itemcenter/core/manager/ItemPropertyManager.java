package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.ItemPropertyDTO;
import com.ve.itemcenter.common.domain.qto.ItemPropertyQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface ItemPropertyManager {

	/**
	 * 添加商品属性
	 * 
	 * @param ItemPropertyDO
	 * @return
	 * @throws ItemException
	 */
	public ItemPropertyDTO addItemProperty(ItemPropertyDTO itemPropertyDTO) throws ItemException;

	/**
	 * 添加商品属性
	 * 
	 * @param ItemPropertyDO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateItemProperty(ItemPropertyDTO itemPropertyDTO) throws ItemException;

	/**
	 * 查看商品属性
	 * 
	 * @param ItemPropertyDO
	 * @return
	 * @throws ItemException
	 */
	public ItemPropertyDTO getItemProperty(Long id,Long sellerId) throws ItemException;

	/**
	 * 删除商品属性
	 * 
	 * @param ItemPropertyDO
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteItemProperty(Long id,Long sellerId) throws ItemException;


	/**
	 * 查询商品属性列表
	 * 
	 * @param itemPropertyQTO
	 * @return
	 * @throws ItemException
	 */
	public List<ItemPropertyDTO> queryItemProperty(ItemPropertyQTO itemPropertyQTO) throws ItemException;

}
