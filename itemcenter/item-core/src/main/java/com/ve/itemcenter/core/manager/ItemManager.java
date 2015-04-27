package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.ItemDTO;
import com.ve.itemcenter.common.domain.qto.ItemQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface ItemManager {

	/**
	 * 添加商品
	 * 
	 * @param itemDO
	 * @return
	 * @throws ItemException
	 */
	public ItemDTO addItem(ItemDTO itemDTO) throws ItemException;

	/**
	 * 添加商品
	 * 
	 * @param itemDO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateItem(ItemDTO itemDTO) throws ItemException;

	/**
	 * 查看商品
	 * 
	 * @param itemDO
	 * @return
	 * @throws ItemException
	 */
	public ItemDTO getItem(Long id, Long supplierId) throws ItemException;

	/**
	 * 删除商品
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteItem(Long id, Long supplierId) throws ItemException;

	/**
	 * 将商品移入回收站
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean removeItem(Long id, Long supplierId) throws ItemException;


	/**
	 * 查询商品列表
	 * 
	 * @param itemQTO
	 * @return
	 * @throws ItemException
	 */
	public List<ItemDTO> queryItem(ItemQTO itemQTO) throws ItemException;

}
