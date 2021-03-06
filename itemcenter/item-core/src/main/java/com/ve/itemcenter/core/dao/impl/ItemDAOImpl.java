package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.ItemQTO;
import com.ve.itemcenter.core.dao.ItemDAO;
import com.ve.itemcenter.core.domain.ItemDO;

@Service
public class ItemDAOImpl extends SqlMapClientDaoSupport implements ItemDAO {

	public ItemDAOImpl() {
		super();
	}

	public Long addItem(ItemDO itemDO) {
		itemDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate().insert("ItemDAO.addItem", itemDO);
		return newInsertedId;
	}

	public ItemDO getItem(Long id, Long supplierId) {
		ItemQTO qto = new ItemQTO();
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		qto.setSupplierId(supplierId);
		qto.setId(id);
		ItemDO record = (ItemDO) getSqlMapClientTemplate().queryForObject("ItemDAO.getItem", qto);
		return record;
	}

	public int deleteItem(Long id, Long supplierId) {
		ItemDO itemDO = new ItemDO();
		itemDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		parms.setSupplierId(supplierId);
		int rows = getSqlMapClientTemplate().delete("ItemDAO.deleteItem", parms);
		return rows;
	}

	public int updateItem(ItemDO itemDO) {
		WhereParms parms = new WhereParms(itemDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(itemDO.getId());
		parms.setSupplierId(itemDO.getSupplierId());
		int rows = getSqlMapClientTemplate().update("ItemDAO.updateItem", parms);
		return rows;
	}

	public List<ItemDO> queryItem(ItemQTO itemQTO) {
		itemQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		if (null != itemQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate().queryForObject("ItemDAO.countItem", itemQTO);// 总记录数
			itemQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<ItemDO>();
			} else {
				itemQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
		}
		List<ItemDO> list = getSqlMapClientTemplate().queryForList("ItemDAO.queryItemList", itemQTO);
		return list;
	}

	public int updateItemState(Long id, Long supplier_id, Integer state) {
		ItemDO itemDO = new ItemDO();
		itemDO.setIsDeleted(state);
		WhereParms parms = new WhereParms(itemDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		parms.setSupplierId(supplier_id);
		int rows = getSqlMapClientTemplate().update("ItemDAO.updateItemState", parms);
		return rows;
	}

	protected class WhereParms extends ItemQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}