package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.ItemImageQTO;
import com.ve.itemcenter.core.dao.ItemImageDAO;
import com.ve.itemcenter.core.domain.ItemImageDO;

@Service
public class ItemImageDAOImpl extends SqlMapClientDaoSupport implements ItemImageDAO {

	public ItemImageDAOImpl() {
		super();
	}

	public Long addItemImage(ItemImageDO itemImageDO) {
		itemImageDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate().insert("ItemImageDAO.addItemImage", itemImageDO);
		return newInsertedId;
	}

	public ItemImageDO getItemImage(Long id, Long sellerId) {
		ItemImageQTO qto = new ItemImageQTO();
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		qto.setSupplierId(sellerId);
		qto.setId(id);
		ItemImageDO record = (ItemImageDO) getSqlMapClientTemplate()
				.queryForObject("ItemImageDAO.getItemImage", qto);
		return record;
	}

	public int deleteItemImage(Long id, Long sellerId) {
		ItemImageDO itemImageDO = new ItemImageDO();
		itemImageDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemImageDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		parms.setSupplierId(sellerId);
		int rows = getSqlMapClientTemplate().update("ItemImageDAO.deleteItemImage", parms);
		return rows;
	}

	public int updateItemImage(ItemImageDO itemImageDO) {
		WhereParms parms = new WhereParms(itemImageDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(itemImageDO.getId());
		parms.setSupplierId(itemImageDO.getSupplierId());
		int rows = getSqlMapClientTemplate().update("ItemImageDAO.updateItemImage", parms);
		return rows;
	}

	public List<ItemImageDO> queryItemImage(ItemImageQTO itemImageQTO) {
		itemImageQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		if (null != itemImageQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate()
					.queryForObject("ItemDAO.countItem", itemImageQTO);// 总记录数
			itemImageQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<ItemImageDO>();
			} else {
				itemImageQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
		}
		List<ItemImageDO> list = getSqlMapClientTemplate()
				.queryForList("ItemImageDAO.queryItemImage", itemImageQTO);
		return list;
	}

	public int deleteItemImageListByItemId(Long itemId, Long sellerId) {
		ItemImageDO itemImageDO = new ItemImageDO();
		itemImageDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemImageDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setItemId(itemId);
		parms.setSupplierId(sellerId);
		int rows = getSqlMapClientTemplate().update("ItemImageDAO.deleteItemImage", parms);
		return rows;
	}

	protected class WhereParms extends ItemImageQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}