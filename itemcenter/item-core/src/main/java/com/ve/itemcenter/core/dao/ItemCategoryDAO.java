package com.ve.itemcenter.core.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.qto.ItemCategoryQTO;
import com.ve.itemcenter.core.domain.ItemCategoryDO;

@Service
public interface ItemCategoryDAO {

	/**
	 * 增加商品类目(ItemCategory)
	 * 
	 * @param itemCategoryDO
	 * @return
	 */
	Integer addItemCategory(ItemCategoryDO itemCategoryDO);

	/**
	 * 根据id获取商品类目(ItemCategory)
	 * 
	 * @param id
	 * @return
	 */
	ItemCategoryDO getItemCategory(Integer id);

	/**
	 * 根据id删除商品类目(ItemCategory)
	 * 
	 * @param id
	 * @return
	 */
	int deleteItemCategory(Integer id);

	/**
	 * 更新商品类目(ItemCategory)信息
	 * 
	 * @param itemCategoryDO
	 * @return
	 */
	int updateItemCategory(ItemCategoryDO itemCategoryDO);

	/**
	 * 返回商品类目(ItemCategory)列表
	 * 
	 * @param itemCategoryQTO
	 * @return
	 */
	List<ItemCategoryDO> queryItemCategory(ItemCategoryQTO itemCategoryQTO);

}