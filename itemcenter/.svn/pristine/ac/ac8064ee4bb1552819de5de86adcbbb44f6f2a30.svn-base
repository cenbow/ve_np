package com.ve.itemcenter.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemDTO;
import com.ve.itemcenter.common.domain.qto.ItemQTO;
import com.ve.itemcenter.core.dao.ItemDAO;
import com.ve.itemcenter.core.domain.ItemDO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemManager;
import com.ve.itemcenter.core.util.ExceptionUtil;
import com.ve.itemcenter.core.util.ItemUtil;

@Service
public class ItemManagerImpl implements ItemManager {
	@Resource
	private ItemDAO itemDAO;

	@Override
	public ItemDTO addItem(ItemDTO itemDTO) throws ItemException {
		// 验证itemDTO内的属性
		verifyNewAddedItemDTOProperty(itemDTO);
		ItemDO itemDO = new ItemDO();
		ItemUtil.copyProperties(itemDTO, itemDO);// DTO转DO
		long newInsertedId = itemDAO.addItem(itemDO);// 新增的记录返回的ID
		itemDTO = getItem(newInsertedId, itemDTO.getSupplierId());// 新增加的记录对应的itemDO
		return itemDTO;
	}

	@Override
	public boolean updateItem(ItemDTO itemDTO) throws ItemException {
		// 验证参数
		verifyUpdatedItemDTOProperty(itemDTO);
		ItemDO itemDO = new ItemDO();
		ItemUtil.copyProperties(itemDTO, itemDO);
		int num = itemDAO.updateItem(itemDO);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.SYS_E_DB_UPDATE, "update item error-->primary id:"
					+ itemDTO.getId() + " sellerId:" + itemDTO.getSupplierId());
		}
	}

	@Override
	public ItemDTO getItem(Long id, Long supplierId) throws ItemException {
		ItemDO itemDO = itemDAO.getItem(id, supplierId);
		if (itemDO == null) {
			throw ExceptionUtil
					.getException(ResCodeNum.BASE_PARAM_E_RECORD_NOT_EXIST, "requested record doesn't exist from table item-->id:"
							+ id + " sellerId:" + supplierId);
		}
		ItemDTO itemDTO = new ItemDTO();
		ItemUtil.copyProperties(itemDO, itemDTO);
		return itemDTO;
	}

	@Override
	public boolean deleteItem(Long id, Long supplierId) throws ItemException {
		int num = itemDAO.deleteItem(id, supplierId);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_DELETE, "requested record doesn't exist from table item-->id:"
							+ id + " sellerId:" + supplierId);
		}
	}

	@Override
	public boolean removeItem(Long id, Long supplierId) throws ItemException {
		// TODO 验证id
		int num = itemDAO.updateItemState(id, supplierId, DBConst.ITEM_IN_TRASH.getCode());
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_DELETE, "requested record doesn't exist from table item-->id:"
							+ id + " sellerId:" + supplierId);
		}
	}

	private void verifyNewAddedItemDTOProperty(ItemDTO itemDTO) throws ItemException {
		// 验证ItemDTO字段属性
		if (itemDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemDTO is null");
		}
		if (itemDTO.getItemName() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "item_name is null");
		}
		if (itemDTO.getItemBriefName() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "item_brief_name is null");
		}
		if (itemDTO.getItemBrandId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "item_brand_id is null");
		}
		if (itemDTO.getItemType() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "item_type is null");
		}
		if (itemDTO.getIconUrl() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "icon_url is null");
		}

		if (itemDTO.getCategoryId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "category_id is null");
		}
		// TODO 验证 CategoryId在数据库是否存在

		// TODO 验证品牌ID在数据库是否存在

		// TODO 供应商ID验证
		if (itemDTO.getSupplierId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "supplier_id is null");
		}

	}

	private void verifyUpdatedItemDTOProperty(ItemDTO itemDTO) throws ItemException {
		// TODO 验证ItemDTO字段属性
		if (itemDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemDTO is null");
		}
		if (itemDTO.getId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemDTO is null");
		}
		// TODO 供应商ID验证
		if (itemDTO.getSupplierId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "supplier_id is null");
		}
	}

	public List<ItemDTO> queryItem(ItemQTO itemQTO) throws ItemException {
		// TODO 供应商ID验证
		if (itemQTO.getSupplierId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "supplier_id is null");
		}
		List<ItemDO> list = itemDAO.queryItem(itemQTO);
		List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();// 需要返回的DTO列表
		for (ItemDO itemDO : list) {
			ItemDTO dto = new ItemDTO();
			ItemUtil.copyProperties(itemDO, dto);
			itemDTOList.add(dto);
		}
		return itemDTOList;
	}
}
