package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.ItemCommentQTO;
import com.ve.itemcenter.core.dao.ItemCommentDAO;
import com.ve.itemcenter.core.domain.ItemCommentDO;

@Service
public class ItemCommentDAOImpl extends SqlMapClientDaoSupport implements ItemCommentDAO {

	public ItemCommentDAOImpl() {
		super();
	}

	public Long addItemComment(ItemCommentDO itemCommentDO) {
		itemCommentDO.setAuditStatus(DBConst.NOT_AUDITED.getCode());
		itemCommentDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate()
				.insert("ItemCommentDAO.addItemComment", itemCommentDO);
		return newInsertedId;
	}

	public ItemCommentDO getItemComment(Long id, Long sellerId) {
		ItemCommentQTO queryQTO = new ItemCommentQTO();
		queryQTO.setId(id);
		queryQTO.setSellerId(sellerId);
		queryQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		ItemCommentDO record = (ItemCommentDO) getSqlMapClientTemplate()
				.queryForObject("ItemCommentDAO.getItemComment", queryQTO);
		return record;
	}

	public int updateItemComment(ItemCommentDO itemCommentDO) {
		WhereParms parms = new WhereParms(itemCommentDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(itemCommentDO.getId());
		int rows = getSqlMapClientTemplate().update("ItemCommentDAO.updateItemComment", parms);
		return rows;
	}

	public List<ItemCommentDO> queryItemCommentByItemId(ItemCommentQTO itemCommentQTO) {
		itemCommentQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		if (null != itemCommentQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate()
					.queryForObject("ItemCommentDAO.countItemComment", itemCommentQTO);// 总记录数
			itemCommentQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<ItemCommentDO>();
			} else {
				itemCommentQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
		}
		List<ItemCommentDO> list = getSqlMapClientTemplate()
				.queryForList("ItemCommentDAO.queryItemCommentByItemId", itemCommentQTO);
		return list;
	}

	@Override
	public int deleteItemComment(Long id, Long sellerId) {
		ItemCommentDO itemCommentDO = new ItemCommentDO();
		itemCommentDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(itemCommentDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		parms.setSellerId(sellerId);
		int rows = getSqlMapClientTemplate().update("ItemCommentDAO.deleteItemComment", parms);
		return rows;
	}

	protected class WhereParms extends ItemCommentQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}