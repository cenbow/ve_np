package com.ve.tradecenter.core.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.tradecenter.core.dao.PaymentNoticeDao;
import com.ve.tradecenter.core.domain.PaymentNoticeDO;

public class PaymentNoticeDaoImpl extends SqlMapClientDaoSupport implements PaymentNoticeDao{

	@Override
	public long addPaymemntNotice(PaymentNoticeDO paymentNoticeDO) {
		long id = (Long)this.getSqlMapClientTemplate().insert("payment_notice.addPaymentNotice",paymentNoticeDO);
		return id;
	}

	/*public int updatePaymemntNotice(PaymentNoticeDO paymentNoticeDO) {
		int rows = getSqlMapClientTemplate().update(
				"payment_notice.updatePaymentNotice", paymentNoticeDO);
		return rows;
	}*/
	
	/*public PaymentNoticeDO getPaymentNotice(Long id){
		return (PaymentNoticeDO)this.getSqlMapClientTemplate().queryForObject("payment_notice_getPaymentNotice",id);
	}*/
	
	@Override
	public PaymentNoticeDO getPaymentNoticeByTradeNo(PaymentNoticeDO paymentNoticeDO){
		return (PaymentNoticeDO)this.getSqlMapClientTemplate().queryForObject("payment_notice.getPaymentNoticeByTradeNo",paymentNoticeDO);
	}
	
	@Override
	public int paySuccess(PaymentNoticeDO paymentNoticeDO){
		return this.getSqlMapClientTemplate().update("payment_notice.paySuccess",paymentNoticeDO);
	}

}

