package com.ve.tradecenter.core.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.tradecenter.core.dao.DeliveryReturnDao;
import com.ve.tradecenter.core.domain.DeliveryReturnDO;

public class DeliveryReturnDaoImpl  extends SqlMapClientDaoSupport implements DeliveryReturnDao{

	@Override
	public long addDeliveryReturn(DeliveryReturnDO deliveryReturn) {
		return (Long)this.getSqlMapClientTemplate().insert("delivery_return.addDeliveryReturn",deliveryReturn);
	}
	
}
