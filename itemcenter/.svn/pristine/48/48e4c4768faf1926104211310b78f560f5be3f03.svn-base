package com.ve.itemcenter.core.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.ItemSkuQTO;
import com.ve.itemcenter.core.dao.ItemSkuDAO;
import com.ve.itemcenter.core.domain.ItemSkuDO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public class ItemSkuDAOImpl extends SqlMapClientDaoSupport implements ItemSkuDAO {

	public ItemSkuDAOImpl() {
		super();
	}

	public Long addItemSku(ItemSkuDO itemSkuDO) {
		itemSkuDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate().insert("ItemSkuDAO.addItemSku", itemSkuDO);
		return newInsertedId;
	}

	public ItemSkuDO getItemSku(Long id, Long sellerId) {
		ItemSkuQTO qto = new ItemSkuQTO();
		qto.setId(id);
		qto.setSellerId(sellerId);
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		ItemSkuDO record = (ItemSkuDO) getSqlMapClientTemplate().queryForObject("ItemSkuDAO.getItemSku", qto);
		return record;
	}

	public int deleteItemSku(Long id, Long sellerId) {
		ItemSkuDO itemSkuDO = new ItemSkuDO();
		itemSkuDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemSkuDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		parms.setSellerId(sellerId);
		int rows = getSqlMapClientTemplate().update("ItemSkuDAO.deleteItemSku", parms);
		return rows;
	}

	public int updateItemSku(ItemSkuDO itemSkuDO) {
		WhereParms parms = new WhereParms(itemSkuDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(itemSkuDO.getId());
		parms.setSellerId(itemSkuDO.getSellerId());
		int rows = getSqlMapClientTemplate().update("ItemSkuDAO.updateItemSku", parms);
		return rows;
	}

	public List<ItemSkuDO> queryItemSku(ItemSkuQTO ItemSkuQTO) {
		ItemSkuQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		List<ItemSkuDO> list = getSqlMapClientTemplate().queryForList("ItemSkuDAO.queryItemSku", ItemSkuQTO);
		return list;
	}

	@Override
	public int increaseItemSkuStock(Long skuId, Long sellerId, Long increasedNumber) throws ItemException {
		ItemSkuDO itemSkuDO = new ItemSkuDO();
		itemSkuDO.setStockNum(increasedNumber);
		WhereParms parms = new WhereParms(itemSkuDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(skuId);
		parms.setSellerId(sellerId);
		int rows = getSqlMapClientTemplate().update("ItemSkuDAO.increaseItemSkuStock", parms);
		return rows;
	}

	@Override
	public int decreaseItemSkuStock(Long skuId, Long sellerId, Long decreasedNumber) throws ItemException {
		ItemSkuDO itemSkuDO = new ItemSkuDO();
		itemSkuDO.setStockNum(decreasedNumber);
		WhereParms parms = new WhereParms(itemSkuDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(skuId);
		parms.setSellerId(sellerId);
		int rows = getSqlMapClientTemplate().update("ItemSkuDAO.decreaseItemSkuStock", parms);
		return rows;
	}

	public int updateItemSkuCodeValue(Long skuId, Long sellerId, String codeValue) {
		ItemSkuDO itemSkuDO = new ItemSkuDO();
		itemSkuDO.setCodeValue(codeValue);
		WhereParms parms = new WhereParms(itemSkuDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(skuId);
		parms.setSellerId(sellerId);
		int rows = getSqlMapClientTemplate().update("ItemSkuDAO.updateItemSkuCodeValue", parms);
		return rows;
	}

	protected class WhereParms extends ItemSkuQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}