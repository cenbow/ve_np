package com.ve.itemcenter.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemCategoryDTO;
import com.ve.itemcenter.common.domain.qto.ItemCategoryQTO;
import com.ve.itemcenter.core.dao.ItemCategoryDAO;
import com.ve.itemcenter.core.domain.ItemCategoryDO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemCategoryManager;
import com.ve.itemcenter.core.util.ExceptionUtil;
import com.ve.itemcenter.core.util.ItemUtil;

@Service
public class ItemCategoryManagerImpl implements ItemCategoryManager {
	@Resource
	private ItemCategoryDAO itemCategoryDAO;

	@Override
	public ItemCategoryDTO addItemCategory(ItemCategoryDTO itemCategoryDTO) throws ItemException {
		try {
			// 验证新增的参数
			verifyNewAddedItemCategoryDTOProperty(itemCategoryDTO);
			ItemCategoryDO itemCategoryDO = new ItemCategoryDO();
			ItemUtil.copyProperties(itemCategoryDTO, itemCategoryDO);// DTO转DO
			int newInsertedId = itemCategoryDAO.addItemCategory(itemCategoryDO);// 新增的记录返回的ID
			itemCategoryDTO = getItemCategory(newInsertedId);// 新增加的记录对应的itemCategoryDO
			return itemCategoryDTO;
		} catch (Exception e) {
			throw new ItemException(ResCodeNum.SYS_E_DEFAULT_ERROR, e);
		}
	}

	@Override
	public boolean updateItemCategory(ItemCategoryDTO itemCategoryDTO) throws ItemException {
		verifyUpdatedItemCategoryDTOProperty(itemCategoryDTO);
		ItemCategoryDO itemCategoryDO = new ItemCategoryDO();
		ItemUtil.copyProperties(itemCategoryDTO, itemCategoryDO);
		int num = itemCategoryDAO.updateItemCategory(itemCategoryDO);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.SYS_E_DB_UPDATE, "update ItemCategory error-->primary id:"
					+ itemCategoryDTO.getId());
		}
	}

	@Override
	public ItemCategoryDTO getItemCategory(Integer id) throws ItemException {
		ItemCategoryDO itemCategoryDO = itemCategoryDAO.getItemCategory(id);
		if (itemCategoryDO == null) {
			throw ExceptionUtil
					.getException(ResCodeNum.BASE_PARAM_E_RECORD_NOT_EXIST, "requested record doesn't exist from table itemcategory-->id:"
							+ id);
		}
		ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
		ItemUtil.copyProperties(itemCategoryDO, itemCategoryDTO);
		return itemCategoryDTO;
	}

	@Override
	public boolean deleteItemCategory(Integer id) throws ItemException {
		// 查询子类目 :如果存在子类目,则不允许删除该类目
		ItemCategoryQTO itemCategoryQTO = new ItemCategoryQTO();
		itemCategoryQTO.setParentId(id);
		List<ItemCategoryDTO> itemCategoryDTOList = queryItemCategory(itemCategoryQTO);
		if (itemCategoryDTOList.size() > 0) {
			throw ExceptionUtil
					.getException(ResCodeNum.BASE_STATE_E_NOT_ALLOW_CATEGORY_DELETED, "category not allowed to delete primary id:"
							+ id);
		}
		int num = itemCategoryDAO.deleteItemCategory(id);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.SYS_E_DB_DELETE, "delete ItemCategory error-->primary id:"
					+ id);
		}
	}

	/**
	 * 验证新增的ItemCategoryDTO
	 */
	private void verifyNewAddedItemCategoryDTOProperty(ItemCategoryDTO itemCategoryDTO) throws ItemException {
		if (itemCategoryDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemCategoryDTO is null");
		}
		if (itemCategoryDTO.getCateName() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "cate_name is null ");
		}
		if (itemCategoryDTO.getCateLevel() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "cate_level is null ");
		}
		if (itemCategoryDTO.getParentId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "parent_id is null ");
		}
		if (itemCategoryDTO.getTopid() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "topid is null ");
		}
		// 判断parent是不是合法,一级的类目为0
		Integer parentId = itemCategoryDTO.getParentId();
		if (parentId != 0) {
			ItemCategoryDTO parentItemCategoryDTO = getItemCategory(parentId);
			if (parentItemCategoryDTO == null) {
				throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "parent_id is invalid parent_id:"
						+ parentId);
			}
		}
	}

	/**
	 * 验证新增的ItemCategoryDTO
	 */
	private void verifyUpdatedItemCategoryDTOProperty(ItemCategoryDTO itemCategoryDTO) throws ItemException {
		if (itemCategoryDTO.getId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "itemCategory id is null");
		}
	}

	public List<ItemCategoryDTO> queryItemCategory(ItemCategoryQTO itemCategoryQTO) throws ItemException {
		List<ItemCategoryDO> list = itemCategoryDAO.queryItemCategory(itemCategoryQTO);
		List<ItemCategoryDTO> itemCategoryDTOList = new ArrayList<ItemCategoryDTO>();// 需要返回的DTO列表
		for (ItemCategoryDO itemCategoryDO : list) {
			ItemCategoryDTO dto = new ItemCategoryDTO();
			ItemUtil.copyProperties(itemCategoryDO, dto);
			itemCategoryDTOList.add(dto);
		}
		return itemCategoryDTOList;
	}

}
