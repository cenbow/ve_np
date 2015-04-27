package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.ItemPropertyQTO;
import com.ve.itemcenter.core.dao.ItemPropertyDAO;
import com.ve.itemcenter.core.domain.ItemPropertyDO;

@Service
public class ItemPropertyDAOImpl extends SqlMapClientDaoSupport implements ItemPropertyDAO {

	public ItemPropertyDAOImpl() {
		super();
	}

	public Long addItemProperty(ItemPropertyDO itemPropertyDO) {
		itemPropertyDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate()
				.insert("ItemPropertyDAO.addItemProperty", itemPropertyDO);
		return newInsertedId;
	}

	public ItemPropertyDO getItemProperty(Long id, Long sellerId) {
		ItemPropertyQTO qto = new ItemPropertyQTO();
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		qto.setSupplierId(sellerId);
		qto.setId(id);
		ItemPropertyDO record = (ItemPropertyDO) getSqlMapClientTemplate()
				.queryForObject("ItemPropertyDAO.getItemProperty", qto);
		return record;
	}

	public int deleteItemProperty(Long id, Long sellerId) {
		ItemPropertyDO itemPropertyDO = new ItemPropertyDO();
		itemPropertyDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemPropertyDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		parms.setSupplierId(sellerId);
		int rows = getSqlMapClientTemplate().delete("ItemPropertyDAO.deleteItemProperty", parms);
		return rows;
	}

	public int updateItemProperty(ItemPropertyDO itemPropertyDO) {
		WhereParms parms = new WhereParms(itemPropertyDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(itemPropertyDO.getId());
		parms.setSupplierId(itemPropertyDO.getSupplierId());
		int rows = getSqlMapClientTemplate().update("ItemPropertyDAO.updateItemProperty", parms);
		return rows;
	}

	public List<ItemPropertyDO> queryItemProperty(ItemPropertyQTO itemPropertyQTO) {
		itemPropertyQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		if (null != itemPropertyQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate()
					.queryForObject("ItemPropertyDAO.countItemProperty", itemPropertyQTO);// 总记录数
			itemPropertyQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<ItemPropertyDO>();
			} else {
				itemPropertyQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
		}
		List<ItemPropertyDO> list = getSqlMapClientTemplate()
				.queryForList("ItemPropertyDAO.queryItemProperty", itemPropertyQTO);
		return list;
	}

	protected class WhereParms extends ItemPropertyQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}