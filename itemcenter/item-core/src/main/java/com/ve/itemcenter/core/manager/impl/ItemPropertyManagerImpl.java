package com.ve.itemcenter.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemDTO;
import com.ve.itemcenter.common.domain.dto.ItemPropertyDTO;
import com.ve.itemcenter.common.domain.qto.ItemPropertyQTO;
import com.ve.itemcenter.core.dao.ItemPropertyDAO;
import com.ve.itemcenter.core.domain.ItemPropertyDO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemManager;
import com.ve.itemcenter.core.manager.ItemPropertyManager;
import com.ve.itemcenter.core.util.ExceptionUtil;
import com.ve.itemcenter.core.util.ItemUtil;

@Service
public class ItemPropertyManagerImpl implements ItemPropertyManager {
	@Resource
	private ItemPropertyDAO itemPropertyDAO;

	@Resource
	private ItemManager itemManager;

	@Override
	public ItemPropertyDTO addItemProperty(ItemPropertyDTO itemPropertyDTO) throws ItemException {
		try {
			// 验证itemPropertyDTO内的属性
			verifyNewAddedItemPropertyDTOProperty(itemPropertyDTO);
			ItemPropertyDO itemPropertyDO = new ItemPropertyDO();
			ItemUtil.copyProperties(itemPropertyDTO, itemPropertyDO);// DTO转DO
			long newInsertedId = itemPropertyDAO.addItemProperty(itemPropertyDO);// 新增的记录返回的ID
			long sellerId = itemPropertyDTO.getSupplierId();
			itemPropertyDTO = getItemProperty(newInsertedId, sellerId);// 新增加的记录对应的itemPropertyDO
			return itemPropertyDTO;
		} catch (Exception e) {
			throw new ItemException(ResCodeNum.SYS_E_DEFAULT_ERROR, e);
		}
	}

	@Override
	public boolean updateItemProperty(ItemPropertyDTO itemPropertyDTO) throws ItemException {
		// 验证参数
		verifyUpdatedItemPropertyDTOProperty(itemPropertyDTO);
		ItemPropertyDO itemPropertyDO = new ItemPropertyDO();
		ItemUtil.copyProperties(itemPropertyDTO, itemPropertyDO);
		int num = itemPropertyDAO.updateItemProperty(itemPropertyDO);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.SYS_E_DB_UPDATE, "update itemProperty error-->primary id:"
					+ itemPropertyDTO.getId() + " sellerId:" + itemPropertyDTO.getSupplierId());
		}
	}

	@Override
	public ItemPropertyDTO getItemProperty(Long id, Long sellerId) throws ItemException {
		ItemPropertyDO itemPropertyDO = itemPropertyDAO.getItemProperty(id, sellerId);
		if (itemPropertyDO == null) {
			throw ExceptionUtil
					.getException(ResCodeNum.BASE_PARAM_E_RECORD_NOT_EXIST, "requested record doesn't exist from table itemProperty-->id:"
							+ id + " sellerId:" + sellerId);
		}
		ItemPropertyDTO itemPropertyDTO = new ItemPropertyDTO();
		ItemUtil.copyProperties(itemPropertyDO, itemPropertyDTO);
		return itemPropertyDTO;
	}

	@Override
	public boolean deleteItemProperty(Long id, Long sellerId) throws ItemException {
		int num = itemPropertyDAO.deleteItemProperty(id, sellerId);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_DELETE, "requested record doesn't exist from table itemProperty-->id:"
							+ id + " sellerId:" + sellerId);
		}
	}

	private void verifyNewAddedItemPropertyDTOProperty(ItemPropertyDTO itemPropertyDTO) throws ItemException {
		// 1.验证supplier_id
		// 2.验证item_id
		if (itemPropertyDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemPropertyDTO is null");
		}
		if (itemPropertyDTO.getKeyName() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "key_name is null");
		}
		if (itemPropertyDTO.getVal() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "van is null");
		}
		// 验证item_id
		if (itemPropertyDTO.getItemId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "item_id is null");
		}
		// TODO 验证supplier_id
		if (itemPropertyDTO.getSupplierId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "supplier_id is null");
		}
		Long sellerId = itemPropertyDTO.getSupplierId();// 供应商ID
		Long itemId = itemPropertyDTO.getItemId();
		ItemDTO itemDTO = itemManager.getItem(itemId, sellerId);
		if (itemDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "itemId  is invalid");
		}

	}

	private void verifyUpdatedItemPropertyDTOProperty(ItemPropertyDTO itemPropertyDTO) throws ItemException {
		if (itemPropertyDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemPropertyDTO is null");
		}
		if (itemPropertyDTO.getId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "item_property id is null");
		}
		// TODO 验证supplier_id
		if (itemPropertyDTO.getSupplierId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "supplier_id is null");
		}
	}

	public List<ItemPropertyDTO> queryItemProperty(ItemPropertyQTO itemPropertyQTO) throws ItemException {
		List<ItemPropertyDO> list = itemPropertyDAO.queryItemProperty(itemPropertyQTO);
		List<ItemPropertyDTO> itemPropertyDTOList = new ArrayList<ItemPropertyDTO>();// 需要返回的DTO列表
		for (ItemPropertyDO itemPropertyDO : list) {
			ItemPropertyDTO dto = new ItemPropertyDTO();
			ItemUtil.copyProperties(itemPropertyDO, dto);
			itemPropertyDTOList.add(dto);
		}
		return itemPropertyDTOList;
	}
}
