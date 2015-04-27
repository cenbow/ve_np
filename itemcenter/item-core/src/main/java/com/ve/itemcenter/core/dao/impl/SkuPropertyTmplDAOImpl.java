package com.ve.itemcenter.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.constant.DBConst;
import com.ve.itemcenter.common.domain.qto.SkuPropertyTmplQTO;
import com.ve.itemcenter.core.dao.SkuPropertyTmplDAO;
import com.ve.itemcenter.core.domain.SkuPropertyTmplDO;

@Service
public class SkuPropertyTmplDAOImpl extends SqlMapClientDaoSupport implements SkuPropertyTmplDAO {

	public SkuPropertyTmplDAOImpl() {
		super();
	}

	public Long addSkuPropertyTmpl(SkuPropertyTmplDO skuPropertyTmplDO) {
		skuPropertyTmplDO.setIsDeleted(DBConst.UN_DELETED.getCode());
		Long newInsertedId = (Long) getSqlMapClientTemplate()
				.insert("SkuPropertyTmplDAO.addSkuPropertyTmpl", skuPropertyTmplDO);
		return newInsertedId;
	}

	public SkuPropertyTmplDO getSkuPropertyTmpl(Long id) {
		SkuPropertyTmplQTO qto = new SkuPropertyTmplQTO();
		qto.setIsDeleted(DBConst.UN_DELETED.getCode());
		qto.setId(id);
		SkuPropertyTmplDO record = (SkuPropertyTmplDO) getSqlMapClientTemplate()
				.queryForObject("SkuPropertyTmplDAO.getSkuPropertyTmpl", qto);
		return record;
	}

	public int deleteSkuPropertyTmpl(Long id) {
		SkuPropertyTmplDO skuPropertyTmplDO = new SkuPropertyTmplDO();
		skuPropertyTmplDO.setIsDeleted(DBConst.DELETED.getCode());
		WhereParms parms = new WhereParms(skuPropertyTmplDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(id);
		int rows = getSqlMapClientTemplate().update("SkuPropertyTmplDAO.deleteSkuPropertyTmpl", parms);
		return rows;
	}

	public int updateSkuPropertyTmpl(SkuPropertyTmplDO skuPropertyTmplDO) {
		WhereParms parms = new WhereParms(skuPropertyTmplDO);
		parms.setIsDeleted(DBConst.UN_DELETED.getCode());
		parms.setId(skuPropertyTmplDO.getId());
		int rows = getSqlMapClientTemplate().update("SkuPropertyTmplDAO.updateSkuPropertyTmpl", parms);
		return rows;
	}

	public List<SkuPropertyTmplDO> querySkuPropertyTmpl(SkuPropertyTmplQTO skuPropertyTmplQTO) {
		if (null != skuPropertyTmplQTO.getNeedPaging()) {
			Integer totalCount = (Integer) getSqlMapClientTemplate()
					.queryForObject("SkuPropertyTmplDAO.countSkuPropertyTmpl", skuPropertyTmplQTO);// 总记录数
			skuPropertyTmplQTO.setTotalCount(totalCount);
			if (totalCount == 0) {
				return new ArrayList<SkuPropertyTmplDO>();
			} else {
				skuPropertyTmplQTO.setOffsetAndTotalPage();// 设置总页数和跳过的行数
			}
		}
		List<SkuPropertyTmplDO> list = getSqlMapClientTemplate()
				.queryForList("SkuPropertyTmplDAO.querySkuPropertyTmpl", skuPropertyTmplQTO);
		return list;
	}

	protected class WhereParms extends SkuPropertyTmplQTO {
		private Object record;

		public WhereParms(Object record) {
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}