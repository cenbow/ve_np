package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.ItemCategoryQTO;
import com.ve.itemcenter.core.dao.ItemCategoryDAO;
import com.ve.itemcenter.core.domain.ItemCategoryDO;

@Service
public class ItemCategoryDAOImpl extends SqlMapClientDaoSupport implements ItemCategoryDAO {

	public ItemCategoryDAOImpl() {
		super();
	}

	public Integer addItemCategory(ItemCategoryDO itemCategoryDO) {
		itemCategoryDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		itemCategoryDO.setCateStatus(DBConst.NOT_AUDITED.getCode());
		Integer newInsertedId = (Integer) getSqlMapClientTemplate()
				.insert("ItemCategoryDAO.addItemCategory", itemCategoryDO);
		return newInsertedId;
	}

	public ItemCategoryDO getItemCategory(Integer id) {
		ItemCategoryQTO qto = new ItemCategoryQTO();
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		qto.setId(id);
		ItemCategoryDO record = (ItemCategoryDO) getSqlMapClientTemplate()
				.queryForObject("ItemCategoryDAO.getItemCategory", qto);
		return record;
	}

	public int deleteItemCategory(Integer id) {
		ItemCategoryDO itemCategoryDO = new ItemCategoryDO();
		itemCategoryDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemCategoryDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		int rows = getSqlMapClientTemplate().update("ItemCategoryDAO.deleteItemCategory", parms);
		return rows;
	}

	public int updateItemCategory(ItemCategoryDO itemCategoryDO) {
		WhereParms parms = new WhereParms(itemCategoryDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(itemCategoryDO.getId());
		int rows = getSqlMapClientTemplate().update("ItemCategoryDAO.updateItemCategory", parms);
		return rows;
	}

	public List<ItemCategoryDO> queryItemCategory(ItemCategoryQTO ItemCategoryQTO) {
		ItemCategoryQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		if (null != ItemCategoryQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate()
					.queryForObject("ItemCategoryDAO.countItemCategory", ItemCategoryQTO);// 总记录数
			ItemCategoryQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<ItemCategoryDO>();
			} else {
				ItemCategoryQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
			totalCount = null;
		}
		List<ItemCategoryDO> list = getSqlMapClientTemplate()
				.queryForList("ItemCategoryDAO.queryItemCategory", ItemCategoryQTO);
		return list;
	}

	protected class WhereParms extends ItemCategoryQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}