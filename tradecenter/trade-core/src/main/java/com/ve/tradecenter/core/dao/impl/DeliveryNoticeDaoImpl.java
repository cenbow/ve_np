package com.ve.tradecenter.core.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.tradecenter.core.dao.DeliveryNoticeDao;
import com.ve.tradecenter.core.domain.DeliveryNoticeDO;

public class DeliveryNoticeDaoImpl extends SqlMapClientDaoSupport implements DeliveryNoticeDao {
	
	@Override
	public long addDeliveryNotice(DeliveryNoticeDO deliveryNoticeDO) {
		return (Long)this.getSqlMapClientTemplate().insert("delivery_notice.addDeliveryNotice",deliveryNoticeDO);
	}

	@Override
	public int updateDeliveryNotice(DeliveryNoticeDO deliveryNoticeDO) {
		return this.getSqlMapClientTemplate().update("delivery_notice.confirmReceival",deliveryNoticeDO);
	}
	
}
