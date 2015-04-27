package com.ve.itemcenter.core.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.qto.ItemQTO;
import com.ve.itemcenter.core.domain.ItemDO;

@Service
public interface ItemDAO {

	/**
	 * 增加商品
	 * 
	 * @param itemDO
	 * @return
	 */
	Long addItem(ItemDO itemDO);

	/**
	 * 根据id获取商品
	 * 
	 * @param id
	 * @return
	 */
	ItemDO getItem(Long id, Long supplier_id);

	/**
	 * 根据id删除商品
	 * 
	 * @param id
	 * @return
	 */
	int deleteItem(Long id, Long supplier_id);

	/**
	 * 更新商品状态
	 * 
	 * @param id
	 * @return
	 */
	int updateItemState(Long id, Long supplier_id, Integer state);

	/**
	 * 更新商品信息
	 * 
	 * @param itemDO
	 * @return
	 */
	int updateItem(ItemDO itemDO);

	/**
	 * 返回商品列表
	 * 
	 * @param itemQTO
	 * @return
	 */
	List<ItemDO> queryItem(ItemQTO itemQTO);

}