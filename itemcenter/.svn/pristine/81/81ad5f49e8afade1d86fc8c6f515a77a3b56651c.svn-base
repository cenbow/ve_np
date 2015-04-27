package com.ve.itemcenter.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.constant.ResCodeNum;
import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;
import com.ve.itemcenter.common.domain.qto.SkuPropertyQTO;
import com.ve.itemcenter.core.dao.SkuPropertyDAO;
import com.ve.itemcenter.core.domain.SkuPropertyDO;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.manager.ItemSkuManager;
import com.ve.itemcenter.core.manager.SkuPropertyManager;
import com.ve.itemcenter.core.util.ExceptionUtil;
import com.ve.itemcenter.core.util.ItemUtil;

@Service
public class SkuPropertyManagerImpl implements SkuPropertyManager {
	@Resource
	private SkuPropertyDAO skuPropertyDAO;

	@Resource
	private ItemSkuManager itemSkuManager;

	@Override
	public List<SkuPropertyDTO> addSkuProperty(Long skuId, Long sellerId, List<SkuPropertyDTO> skuPropertyDTOList)
			throws ItemException {
		if (skuId == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "skuId is null");
		}
		if (skuPropertyDTOList == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "skuPropertyDTOList is null");
		}
		if (skuPropertyDTOList.size() == 0) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "the size of skuPropertyDTOList is 0");
		}
		// 返回的SkuPropertyDTO列表
		List<SkuPropertyDTO> returnSkuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		// TODO 1.验证sellerId
		// 2.验证skuId
		itemSkuManager.getItemSku(skuId, sellerId);
		
		for (SkuPropertyDTO skuPropertyDTO : skuPropertyDTOList) {
			// 验证skuPropertyDTO内的属性
			verifyNewAddedSkuPropertyDTOProperty(skuPropertyDTO);
			skuPropertyDTO.setSkuId(skuId);
			skuPropertyDTO.setSellerId(sellerId);
			SkuPropertyDO skuPropertyDO = new SkuPropertyDO();
			ItemUtil.copyProperties(skuPropertyDTO, skuPropertyDO);// DTO转DO
			long newInsertedId = skuPropertyDAO.addSkuProperty(skuPropertyDO);// 新增的记录返回的ID
			skuPropertyDTO = getSkuProperty(newInsertedId, sellerId);// 新增加的记录对应的skuPropertyDO
			returnSkuPropertyDTOList.add(skuPropertyDTO);
		}
		return returnSkuPropertyDTOList;
	}

	@Override
	public boolean updateSkuProperty(SkuPropertyDTO skuPropertyDTO) throws ItemException {
		verifyUpdatedSkuPropertyDTOProperty(skuPropertyDTO);
		SkuPropertyDO skuPropertyDO = new SkuPropertyDO();
		ItemUtil.copyProperties(skuPropertyDTO, skuPropertyDO);
		int num = skuPropertyDAO.updateSkuProperty(skuPropertyDO);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil.getException(ResCodeNum.SYS_E_DB_UPDATE, "update SkuProperty error-->primary id:"
					+ skuPropertyDTO.getId());
		}
	}

	@Override
	public SkuPropertyDTO getSkuProperty(Long id, Long sellerId) throws ItemException {
		SkuPropertyDO skuPropertyDO = skuPropertyDAO.getSkuProperty(id, sellerId);
		if (skuPropertyDO == null) {
			throw ExceptionUtil.getException(ResCodeNum.BASE_PARAM_E_RECORD_NOT_EXIST, "requested"
					+ " record doesn't exist from table skuProperty-->id:" + id + " sellerId:" + sellerId);
		}
		SkuPropertyDTO skuPropertyDTO = new SkuPropertyDTO();
		ItemUtil.copyProperties(skuPropertyDO, skuPropertyDTO);
		return skuPropertyDTO;
	}

	@Override
	public boolean deleteSkuProperty(Long id, Long sellerId) throws ItemException {
		// TODO 验证id
		SkuPropertyDO skuPropertyDO = new SkuPropertyDO();
		skuPropertyDO.setId(id);
		skuPropertyDO.setSellerId(sellerId);
		skuPropertyDO.setIsDeleted(DBConst.DELETED.getCode());
		int num = skuPropertyDAO.deleteSkuProperty(id, sellerId);
		if (num > 0) {
			return true;
		} else {
			throw ExceptionUtil
					.getException(ResCodeNum.SYS_E_DB_DELETE, "requested record doesn't exist from table sku_property-->id:->id:"
							+ id + " sellerId:" + sellerId);
		}
	}

	/**
	 * 验证新增SkuProperty
	 * 
	 * @param skuPropertyDTO
	 * @throws ItemException
	 */
	private void verifyNewAddedSkuPropertyDTOProperty(SkuPropertyDTO skuPropertyDTO) throws ItemException {
		if (skuPropertyDTO.getKeyName() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "keyname is null");
		}
		if (skuPropertyDTO.getVal() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "val is null");
		}
		if (skuPropertyDTO.getSort() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "sort is null");
		}
	}

	/**
	 * 验证更新SkuProperty
	 * 
	 * @param skuPropertyDTO
	 * @throws ItemException
	 */
	private void verifyUpdatedSkuPropertyDTOProperty(SkuPropertyDTO skuPropertyDTO) throws ItemException {
		if (skuPropertyDTO.getId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "skuPropertyId is null");
		}
		if (skuPropertyDTO.getSellerId() == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "seller_id is null");
		}
		// TODO 验证seller_id的合法性
	}

	public List<SkuPropertyDTO> querySkuProperty(SkuPropertyQTO skuPropertyQTO) throws ItemException {
		List<SkuPropertyDO> list = skuPropertyDAO.querySkuProperty(skuPropertyQTO);
		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();// 需要返回的DTO列表
		for (SkuPropertyDO skuPropertyDO : list) {
			SkuPropertyDTO dto = new SkuPropertyDTO();
			ItemUtil.copyProperties(skuPropertyDO, dto);
			skuPropertyDTOList.add(dto);
		}
		return skuPropertyDTOList;
	}

	@Override
	public int deleteSkuPropertyListBySkuId(Long skuId, Long sellerId) throws ItemException {
		// TODO 验证sellerId
		if (skuId == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_MISSING, "skuId is null");
		}
		ItemSkuDTO itemSkuDTO = itemSkuManager.getItemSku(skuId, sellerId);
		if (itemSkuDTO == null) {
			throw ExceptionUtil.getException(ResCodeNum.PARAM_E_INVALID, "itemSkuId is not illegle");
		}
		int num = skuPropertyDAO.deleteSkuPropertyBySkuId(skuId, sellerId);
		return num;
		// if (num > 0) {
		// return true;
		// } else {
		// throw ExceptionUtil
		// .getException(ResCodeNum.SYS_E_DB_DELETE,
		// "delete from sku_property error-->skuId id:" + skuId
		// + " sellerId:" + sellerId);
		// }
	}

}
