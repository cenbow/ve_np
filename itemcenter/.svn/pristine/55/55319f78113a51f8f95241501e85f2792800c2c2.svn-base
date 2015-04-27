package com.ve.itemcenter.core.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemDTO;
import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;
import com.ve.itemcenter.common.domain.qto.ItemSkuQTO;
import com.ve.itemcenter.common.domain.qto.SkuPropertyQTO;
import com.ve.itemcenter.core.dao.ItemSkuDAO;
import com.ve.itemcenter.core.domain.ItemSkuDO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemManager;
import com.ve.itemcenter.core.manager.ItemSkuManager;
import com.ve.itemcenter.core.manager.SkuPropertyManager;
import com.ve.itemcenter.core.util.ExceptionUtil;
import com.ve.itemcenter.core.util.ItemUtil;

@Service
public class ItemSkuManagerImpl implements ItemSkuManager {
	@Resource
	private ItemSkuDAO itemSkuDAO;

	@Resource
	private SkuPropertyManager skuPropertyManager;

	@Resource
	private ItemManager itemManager;

	@Override
	public ItemSkuDTO addItemSku(ItemSkuDTO itemSkuDTO) throws ItemException {
		try {
			if (itemSkuDTO == null) {
				throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemSkuDTO is null");
			}
			// 验证itemSkuDTO内的属性
			verifyNewAddedItemSkuDTOProperty(itemSkuDTO);
			// 增加ItemSku表记录
			ItemSkuDO itemSkuDO = new ItemSkuDO();
			ItemUtil.copyProperties(itemSkuDTO, itemSkuDO);// DTO转DO
			long newInsertedId = itemSkuDAO.addItemSku(itemSkuDO);// 新增的记录返回的ID
			long sellerId = itemSkuDTO.getSellerId();
			itemSkuDTO = getItemSku(newInsertedId, sellerId);// 新增加的记录对应的itemSkuDO
			return itemSkuDTO;
		} catch (ItemException e) {
			throw e;
		}
	}

	@Override
	public boolean updateItemSku(ItemSkuDTO itemSkuDTO) throws ItemException {
		verifyUpdatedItemSkuDTOProperty(itemSkuDTO);
		ItemSkuDO itemSkuDO = new ItemSkuDO();
		ItemUtil.copyProperties(itemSkuDTO, itemSkuDO);
		int num = itemSkuDAO.updateItemSku(itemSkuDO);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.SYS_E_DB_UPDATE, "update item_sku error-->primary id:"
					+ itemSkuDTO.getId());
		}
	}

	@Override
	public ItemSkuDTO getItemSku(Long id, Long sellerId) throws ItemException {
		ItemSkuDO itemSkuDO = itemSkuDAO.getItemSku(id, sellerId);
		if (itemSkuDO == null) {
			throw ExceptionUtil.getException(ResCodeNum.BASE_PARAM_E_RECORD_NOT_EXIST, "requested"
					+ " record doesn't exist from table item_sku-->id:" + id + " sellerId:" + sellerId);
		}
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		ItemUtil.copyProperties(itemSkuDO, itemSkuDTO);
		return itemSkuDTO;
	}

	@Override
	public boolean deleteItemSku(Long id, Long sellerId) throws ItemException {
		// 先删除skuproperty列表
		skuPropertyManager.deleteSkuPropertyListBySkuId(id, sellerId);
		ItemSkuDO itemSkuDO = new ItemSkuDO();
		itemSkuDO.setIsDeleted(DBConst.DELETED.getCode());
		int num = itemSkuDAO.deleteItemSku(id, sellerId);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.SYS_E_DB_DELETE, "delete item_sku error-->id:" + id
					+ " sellerId:" + sellerId);
		}
	}

	/**
	 * 验证新增ItemSku属性
	 * 
	 * @param itemSkuDTO
	 * @return
	 * @throws ItemException
	 */
	private boolean verifyNewAddedItemSkuDTOProperty(ItemSkuDTO itemSkuDTO) throws ItemException {
		if (StringUtils.isBlank(itemSkuDTO.getMaterialCode())) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "MaterialCode is null");
		}
		if (StringUtils.isBlank(itemSkuDTO.getBarCode())) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "BarCode is null");
		}
		// TODO
		// 验证供应商ID seller_id
		// 验证item_id是否合法
		if (itemSkuDTO.getSellerId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "sellerId is null");
		}
		Long sellerId = itemSkuDTO.getSellerId();
		Long itemId = itemSkuDTO.getItemId();
		if (itemId == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemId is null");
		}
		ItemDTO itemDTO = itemManager.getItem(itemId, sellerId);
		if (itemDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "itemId is not illegle");
		}
		if (itemDTO.getItemStatus() != DBConst.ITEM_NORMAL.getCode()) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "item is in illegle status");
		}
		return true;
	}

	/**
	 * 验证更新的ItemSku属性
	 * 
	 * @param itemSkuDTO
	 * @return
	 * @throws ItemException
	 */
	private void verifyUpdatedItemSkuDTOProperty(ItemSkuDTO itemSkuDTO) throws ItemException {
		if (itemSkuDTO.getId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "item Id is null");
		}
	}

	// /**
	// * 验证SkuProperty属性
	// *
	// * @param itemSkuDTO
	// * @return
	// * @throws ItemException
	// */
	// private boolean verifySkuPropertyDTOProperty(SkuPropertyDTO
	// skuPropertyDTO) throws ItemException {
	// // TODO
	// // 验证供应商ID seller_id
	// if (StringUtils.isBlank(skuPropertyDTO.getKeyName())) {
	// throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING,
	// "KeyName is null");
	// }
	// if (StringUtils.isBlank(skuPropertyDTO.getVal())) {
	// throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING,
	// "Val is null");
	// }
	// if (skuPropertyDTO.getSort() == null) {
	// throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING,
	// "sort is null");
	// }
	// return true;
	// }

	public List<ItemSkuDTO> queryItemSku(ItemSkuQTO itemSkuQTO) throws ItemException {
		List<ItemSkuDO> list = itemSkuDAO.queryItemSku(itemSkuQTO);
		List<ItemSkuDTO> itemSkuDTOList = new ArrayList<ItemSkuDTO>();// 需要返回的DTO列表
		for (ItemSkuDO itemSkuDO : list) {
			SkuPropertyQTO skuPropertyQTO = new SkuPropertyQTO();
			skuPropertyQTO.setSkuId(itemSkuDO.getId());
			skuPropertyQTO.setSellerId(itemSkuDO.getSellerId());
			List<SkuPropertyDTO> skuPropertyDTOList = skuPropertyManager.querySkuProperty(skuPropertyQTO);
			ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
			ItemUtil.copyProperties(itemSkuDO, itemSkuDTO);
			itemSkuDTO.setSkuPropertyDTOList(skuPropertyDTOList);
			itemSkuDTOList.add(itemSkuDTO);
		}
		return itemSkuDTOList;
	}

	public boolean decreaseItemSkuStock(Long skuId, Long sellerId, Long decreasedNumber) throws ItemException {
		// TODO sellerId
		ItemSkuDTO itemSkuDTO = getItemSku(skuId, sellerId);
		if (itemSkuDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "skuId:" + skuId + " sellerId:"
					+ sellerId);
		}
		Long currentStock = itemSkuDTO.getStockNum();
		if (currentStock == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "currentStock is null");
		}
		if (decreasedNumber == null || decreasedNumber > currentStock) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "decreasedNumber:" + decreasedNumber);
		}
		int num = itemSkuDAO.decreaseItemSkuStock(skuId, sellerId, decreasedNumber);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_UPDATE, "decrease SkuStock item_sku error-->skuId id:"
							+ skuId + " sellerId:" + sellerId + " increasedNumber:" + decreasedNumber);
		}
	}

	public boolean increaseItemSkuStock(Long skuId, Long sellerId, Long increasedNumber) throws ItemException {
		// TODO sellerId
		ItemSkuDTO itemSkuDTO = getItemSku(skuId, sellerId);
		if (itemSkuDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "skuId:" + skuId + " sellerId:"
					+ sellerId);
		}
		Long currentStock = itemSkuDTO.getStockNum();
		if (currentStock == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "currentStock is null");
		}
		if (increasedNumber == null || increasedNumber <= 0) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "increasedNumber:" + increasedNumber);
		}
		int num = itemSkuDAO.increaseItemSkuStock(skuId, sellerId, increasedNumber);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_UPDATE, "increase SkuStock item_sku error-->skuId id:"
							+ skuId + " sellerId:" + sellerId + " increasedNumber:" + increasedNumber);
		}
	}

	@Override
	public boolean updateItemSkuCodeValue(Long skuId, Long sellerId, List<SkuPropertyDTO> skuPropertyDTOList)
			throws ItemException {
		// 以sort字段对属性排序
		Collections.sort(skuPropertyDTOList, new Comparator<SkuPropertyDTO>() {
			@Override
			public int compare(SkuPropertyDTO o1, SkuPropertyDTO o2) {
				return o1.getSort().compareTo(o2.getSort());
			}
		});
		StringBuilder codeValue = new StringBuilder();
		for (SkuPropertyDTO skuPropertyDTO : skuPropertyDTOList) {
			codeValue.append(skuPropertyDTO.getVal()).append("-");
		}
		// ItemSkuDTO updateDTO = new ItemSkuDTO();
		// updateDTO.setId(skuId);
		// updateDTO.setSellerId(sellerId);
		// updateDTO.setCodeValue(codeValue.toString());
		int num = itemSkuDAO.updateItemSkuCodeValue(skuId, sellerId, codeValue.toString());
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, " update item_sku error item_sku-->id:"
					+ skuId + " sellerId:" + sellerId);
		}
	}

}
