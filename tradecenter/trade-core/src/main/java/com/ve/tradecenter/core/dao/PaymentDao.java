package com.ve.tradecenter.core.dao;

import com.ve.tradecenter.core.domain.PaymentDO;

public interface PaymentDao {
	
	/**
	 * 添加支付方式 
	 * @param payment
	 * @return
	 */
    public Long addPayment(PaymentDO payment);
    
    /**
     * 删除支付方式
     * @param payment
     */
    public int deletePayment(Integer paymentId);
    
    /**
     * 根据支付方式id查询支付方式
     * @param paymentId
     * @return
     */
    public PaymentDO getPayment(Integer paymentId);
    
    /**
     * 更新支付信息
     * @param payment
     * @return
     */
    public int updatePayment(PaymentDO payment);
    
    /**
     * 根据支付分类查找支付方式
     * @return
     */
    public PaymentDO getPaymentByClass(PaymentDO paymentDO);
}
