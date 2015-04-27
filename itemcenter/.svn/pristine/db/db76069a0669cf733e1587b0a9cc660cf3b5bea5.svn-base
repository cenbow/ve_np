package com.ve.itemcenter.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemCategoryDTO;
import com.ve.itemcenter.common.domain.dto.ItemPropertyTmplDTO;
import com.ve.itemcenter.common.domain.qto.ItemPropertyTmplQTO;
import com.ve.itemcenter.core.dao.ItemPropertyTmplDAO;
import com.ve.itemcenter.core.domain.ItemPropertyTmplDO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemCategoryManager;
import com.ve.itemcenter.core.manager.ItemPropertyTmplManager;
import com.ve.itemcenter.core.util.ExceptionUtil;
import com.ve.itemcenter.core.util.ItemUtil;

@Service
public class ItemPropertyTmplManagerImpl implements ItemPropertyTmplManager {
	@Resource
	private ItemPropertyTmplDAO itemPropertyTmplDAO;

	@Resource
	private ItemCategoryManager itemCategoryManager;

	@Override
	public ItemPropertyTmplDTO addItemPropertyTmpl(ItemPropertyTmplDTO itemPropertyTmplDTO) throws ItemException {
		try {
			// 验证itemPropertyTmplDTO内的属性
			verifyNewAddedItemPropertyTmplDTOProperty(itemPropertyTmplDTO);
			ItemPropertyTmplDO itemPropertyTmplDO = new ItemPropertyTmplDO();
			ItemUtil.copyProperties(itemPropertyTmplDTO, itemPropertyTmplDO);// DTO转DO
			long newInsertedId = itemPropertyTmplDAO.addItemPropertyTmpl(itemPropertyTmplDO);// 新增的记录返回的ID
			itemPropertyTmplDTO = getItemPropertyTmpl(newInsertedId);// 新增加的记录对应的itemPropertyTmplDO
			return itemPropertyTmplDTO;
		} catch (Exception e) {
			throw new ItemException(ResCodeNum.SYS_E_DEFAULT_ERROR, e);
		}
	}

	@Override
	public boolean updateItemPropertyTmpl(ItemPropertyTmplDTO itemPropertyTmplDTO) throws ItemException {
		// 验证参数
		verifyUpdatedItemPropertyTmplDTOProperty(itemPropertyTmplDTO);
		ItemPropertyTmplDO itemPropertyTmplDO = new ItemPropertyTmplDO();
		ItemUtil.copyProperties(itemPropertyTmplDTO, itemPropertyTmplDO);
		int num = itemPropertyTmplDAO.updateItemPropertyTmpl(itemPropertyTmplDO);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_UPDATE, "update itemPropertyTmpl error-->primary id:"
							+ itemPropertyTmplDTO.getId());
		}
	}

	@Override
	public ItemPropertyTmplDTO getItemPropertyTmpl(Long id) throws ItemException {
		ItemPropertyTmplDO itemPropertyTmplDO = itemPropertyTmplDAO.getItemPropertyTmpl(id);
		if (itemPropertyTmplDO == null) {
			throw ExceptionUtil
					.getException(ResCodeNum.BASE_PARAM_E_RECORD_NOT_EXIST, "requested record doesn't exist from table itemPropertyTmpl-->id:"
							+ id);
		}
		ItemPropertyTmplDTO itemPropertyTmplDTO = new ItemPropertyTmplDTO();
		ItemUtil.copyProperties(itemPropertyTmplDO, itemPropertyTmplDTO);
		return itemPropertyTmplDTO;
	}

	@Override
	public boolean deleteItemPropertyTmpl(Long id) throws ItemException {
		int num = itemPropertyTmplDAO.deleteItemPropertyTmpl(id);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_DELETE, "requested record doesn't exist from table itemPropertyTmpl-->id:"
							+ id);
		}
	}

	private void verifyNewAddedItemPropertyTmplDTOProperty(ItemPropertyTmplDTO itemPropertyTmplDTO)
			throws ItemException {
		if (itemPropertyTmplDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemPropertyTmplDTO is null");
		}
		if (itemPropertyTmplDTO.getTmplName() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "tmpl_name is null");
		}
		if (itemPropertyTmplDTO.getKeyName() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "key_name is null");
		}
		if (itemPropertyTmplDTO.getVal() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "van is null");
		}
		// 验证CategoryId在数据库是否存在
		Integer categoryId = itemPropertyTmplDTO.getCategoryId();
		if (categoryId == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "categoryId is null");
		}
		ItemCategoryDTO itemCategoryDTO = itemCategoryManager.getItemCategory(categoryId);
		if (itemCategoryDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.BASE_PARAM_E_RECORD_NOT_EXIST, "requested record "
					+ "doesn't exist from table item_category-->id:" + categoryId);
		}
	}

	private void verifyUpdatedItemPropertyTmplDTOProperty(ItemPropertyTmplDTO itemPropertyTmplDTO)
			throws ItemException {
		if (itemPropertyTmplDTO.getId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "primary id is null");
		}
	}

	public List<ItemPropertyTmplDTO> queryItemPropertyTmpl(ItemPropertyTmplQTO itemPropertyTmplQTO)
			throws ItemException {
		List<ItemPropertyTmplDO> list = itemPropertyTmplDAO.queryItemPropertyTmpl(itemPropertyTmplQTO);
		List<ItemPropertyTmplDTO> itemPropertyTmplDTOList = new ArrayList<ItemPropertyTmplDTO>();// 需要返回的DTO列表
		for (ItemPropertyTmplDO itemPropertyTmplDO : list) {
			ItemPropertyTmplDTO dto = new ItemPropertyTmplDTO();
			ItemUtil.copyProperties(itemPropertyTmplDO, dto);
			itemPropertyTmplDTOList.add(dto);
		}
		return itemPropertyTmplDTOList;
	}
}
