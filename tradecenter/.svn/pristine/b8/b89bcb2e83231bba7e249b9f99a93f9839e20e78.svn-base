package com.ve.tradecenter.core.dao;

import com.ve.tradecenter.core.domain.PaymentNoticeDO;

public interface PaymentNoticeDao{

	/**
	 * 写入支付单
	 * @return
	 */
	public long addPaymemntNotice(PaymentNoticeDO paymentNoticeDO);

	/**
	 * 更新支付单
	 * @param paymentNoticeDO
	 * @return
	 */
//	public int updatePaymemntNotice(PaymentNoticeDO paymentNoticeDO);
	
	/**
	 * 查询支付单
	 * @param id
	 * @return
	 */
//	public PaymentNoticeDO getPaymentNotice(Long id);
	
	/**
	 * 根据支付单号查询支付单
	 * @param tradeNo
	 * @return
	 */
	public PaymentNoticeDO getPaymentNoticeByTradeNo(PaymentNoticeDO paymentNoticeDO);
	
	/**
	 * 支付成功更新状态
	 * @param paymentNoticeDO
	 * @return
	 */
	public int paySuccess(PaymentNoticeDO paymentNoticeDO);
}
