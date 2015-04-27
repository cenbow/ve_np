package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;
import com.ve.itemcenter.common.domain.qto.ItemSkuQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface ItemSkuManager {

	/**
	 * 添加增加商品销售属性(ItemSku)
	 * 
	 * @param itemSkuDTO
	 * @param skuPropertyDTOList
	 * @return
	 * @throws ItemException
	 */
	public ItemSkuDTO addItemSku(ItemSkuDTO itemSkuDTO) throws ItemException;

	/**
	 * 更新codeValue值
	 * 
	 * @param itemSkuDTO
	 * @param skuPropertyDTOList
	 * @return
	 * @throws ItemException
	 */
	public boolean updateItemSkuCodeValue(Long skuId, Long sellerId, List<SkuPropertyDTO> skuPropertyDTOList)
			throws ItemException;

	/**
	 * 更新增加商品销售属性(ItemSku)
	 * 
	 * @param itemSkuDTO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateItemSku(ItemSkuDTO itemSkuDTO) throws ItemException;

	/**
	 * 减少SKU库存
	 * 
	 * @param skuId
	 * @param sellerId卖家ID
	 * @param number减少的数量
	 * 
	 * @return
	 * @throws ItemException
	 */
	public boolean decreaseItemSkuStock(Long skuId, Long sellerId, Long decreasedNumber) throws ItemException;

	/**
	 * 增加SKU库存
	 * 
	 * @param skuId
	 * @param sellerId卖家ID
	 * @param number增加的数量
	 * 
	 * @return
	 * @throws ItemException
	 */
	public boolean increaseItemSkuStock(Long skuId, Long sellerId, Long increasedNumber) throws ItemException;

	/**
	 * 查看增加商品销售属性(ItemSku)
	 * 
	 * @param sellerId
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public ItemSkuDTO getItemSku(Long id, Long sellerId) throws ItemException;

	/**
	 * 删除增加商品销售属性(ItemSku)
	 * 
	 * @param sellerId
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteItemSku(Long id, Long sellerId) throws ItemException;

	/**
	 * 查询增加商品销售属性(ItemSku)列表
	 * 
	 * @param itemSkuQTO
	 * @return
	 * @throws ItemException
	 */
	public List<ItemSkuDTO> queryItemSku(ItemSkuQTO itemSkuQTO) throws ItemException;

}
