package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.ItemBrandDTO;
import com.ve.itemcenter.common.domain.qto.ItemBrandQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface ItemBrandManager {

	/**
	 * 添加商品品牌
	 * 
	 * @param itemBrandDO
	 * @return
	 * @throws ItemException
	 * @throws Exception 
	 */
	public ItemBrandDTO addItemBrand(ItemBrandDTO itemBrandDTO) throws ItemException;

	/**
	 * 添加商品品牌
	 * 
	 * @param itemBrandDO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateItemBrand(ItemBrandDTO itemBrandDTO) throws ItemException;

	/**
	 * 查看商品品牌
	 * 
	 * @param itemBrandDO
	 * @return
	 * @throws ItemException
	 */
	public ItemBrandDTO getItemBrand(Long id) throws ItemException;

	/**
	 * 删除商品品牌
	 * 
	 * @param itemBrandDO
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteItemBrand(Long id) throws ItemException;

	/**
	 * 查询商品品牌列表
	 * 
	 * @param itemBrandQTO
	 * @return
	 * @throws ItemException
	 */
	public List<ItemBrandDTO> queryItemBrand(ItemBrandQTO itemBrandQTO) throws ItemException;

}
