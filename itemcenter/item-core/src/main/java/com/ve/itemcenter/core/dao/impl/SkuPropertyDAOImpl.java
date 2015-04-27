package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.SkuPropertyQTO;
import com.ve.itemcenter.core.dao.SkuPropertyDAO;
import com.ve.itemcenter.core.domain.SkuPropertyDO;

@Service
public class SkuPropertyDAOImpl extends SqlMapClientDaoSupport implements SkuPropertyDAO {

	public SkuPropertyDAOImpl() {
		super();
	}

	public Long addSkuProperty(SkuPropertyDO skuPropertyDO) {
		skuPropertyDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate()
				.insert("SkuPropertyDAO.addSkuProperty", skuPropertyDO);
		return newInsertedId;
	}

	public SkuPropertyDO getSkuProperty(Long id, Long sellerId) {
		SkuPropertyQTO qto = new SkuPropertyQTO();
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		qto.setId(id);
		qto.setSellerId(sellerId);
		SkuPropertyDO skuPropertyDO = (SkuPropertyDO) getSqlMapClientTemplate()
				.queryForObject("SkuPropertyDAO.getSkuProperty", qto);
		return skuPropertyDO;
	}

	public int deleteSkuProperty(Long id, Long sellerId) {
		SkuPropertyDO skuPropertyDO = new SkuPropertyDO();
		skuPropertyDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(skuPropertyDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		parms.setSellerId(sellerId);
		int rows = getSqlMapClientTemplate().update("SkuPropertyDAO.deleteSkuProperty", parms);
		return rows;
	}

	public int deleteSkuPropertyBySkuId(Long skuId, Long sellerId) {
		SkuPropertyDO skuPropertyDO = new SkuPropertyDO();
		skuPropertyDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(skuPropertyDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setSkuId(skuId);
		parms.setSellerId(sellerId);
		int rows = getSqlMapClientTemplate().update("SkuPropertyDAO.deleteSkuProperty", parms);
		return rows;
	}

	public int updateSkuProperty(SkuPropertyDO skuPropertyDO) {
		WhereParms parms = new WhereParms(skuPropertyDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(skuPropertyDO.getId());
		parms.setSellerId(skuPropertyDO.getSellerId());
		int rows = getSqlMapClientTemplate().update("SkuPropertyDAO.updateSkuProperty", parms);
		return rows;
	}

	public List<SkuPropertyDO> querySkuProperty(SkuPropertyQTO skuPropertyQTO) {
		skuPropertyQTO.setIsDeleted(DBConst.UN_DELETED.getCode());
		if (null != skuPropertyQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate()
					.queryForObject("SkuPropertyDAO.countSkuProperty", skuPropertyQTO);// 总记录数
			skuPropertyQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<SkuPropertyDO>();
			} else {
				skuPropertyQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
			totalCount = null;
		}
		List<SkuPropertyDO> list = getSqlMapClientTemplate()
				.queryForList("SkuPropertyDAO.querySkuProperty", skuPropertyQTO);
		return list;
	}

	protected class WhereParms extends SkuPropertyQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}