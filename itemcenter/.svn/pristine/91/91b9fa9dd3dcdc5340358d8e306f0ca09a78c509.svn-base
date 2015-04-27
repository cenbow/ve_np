package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.ItemPropertyTmplQTO;
import com.ve.itemcenter.core.dao.ItemPropertyTmplDAO;
import com.ve.itemcenter.core.domain.ItemPropertyTmplDO;

@Service
public class ItemPropertyTmplDAOImpl extends SqlMapClientDaoSupport implements ItemPropertyTmplDAO {

	public ItemPropertyTmplDAOImpl() {
		super();
	}

	public Long addItemPropertyTmpl(ItemPropertyTmplDO itemPropertyTmplDO) {
		itemPropertyTmplDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate()
				.insert("ItemPropertyTmplDAO.addItemPropertyTmpl", itemPropertyTmplDO);
		return newInsertedId;
	}

	public ItemPropertyTmplDO getItemPropertyTmpl(Long id) {
		ItemPropertyTmplQTO qto = new ItemPropertyTmplQTO();
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		qto.setId(id);
		ItemPropertyTmplDO record = (ItemPropertyTmplDO) getSqlMapClientTemplate()
				.queryForObject("ItemPropertyTmplDAO.getItemPropertyTmpl", qto);
		return record;
	}

	public int deleteItemPropertyTmpl(Long id) {
		ItemPropertyTmplDO itemPropertyTmplDO = new ItemPropertyTmplDO();
		itemPropertyTmplDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemPropertyTmplDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		int rows = getSqlMapClientTemplate().delete("ItemPropertyTmplDAO.deleteItemPropertyTmpl", parms);
		return rows;
	}

	public int updateItemPropertyTmpl(ItemPropertyTmplDO itemPropertyTmplDO) {
		WhereParms parms = new WhereParms(itemPropertyTmplDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(itemPropertyTmplDO.getId());
		int rows = getSqlMapClientTemplate().update("ItemPropertyTmplDAO.updateItemPropertyTmpl", parms);
		return rows;
	}

	public List<ItemPropertyTmplDO> queryItemPropertyTmpl(ItemPropertyTmplQTO itemPropertyTmplQTO) {
		itemPropertyTmplQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		if (null != itemPropertyTmplQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate()
					.queryForObject("ItemPropertyTmplDAO.countItemPropertyTmpl", itemPropertyTmplQTO);// 总记录数
			itemPropertyTmplQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<ItemPropertyTmplDO>();
			} else {
				itemPropertyTmplQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
		}
		List<ItemPropertyTmplDO> list = getSqlMapClientTemplate()
				.queryForList("ItemPropertyTmplDAO.queryItemPropertyTmpl", itemPropertyTmplQTO);
		return list;
	}

	protected class WhereParms extends ItemPropertyTmplQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}