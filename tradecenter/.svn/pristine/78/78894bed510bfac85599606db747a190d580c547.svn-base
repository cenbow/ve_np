package com.ve.tradecenter.core.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.tradecenter.core.dao.ReturnOrderDao;
import com.ve.tradecenter.core.domain.ReturnOrderDO;

public class ReturnOrderDaoImpl extends SqlMapClientDaoSupport  implements ReturnOrderDao {

	@Override
	public long addReturnOrder(ReturnOrderDO returnOrderDO) {
		return (Long) this.getSqlMapClientTemplate().insert("return_order.addReturnOrder",returnOrderDO);
	}
	
}
