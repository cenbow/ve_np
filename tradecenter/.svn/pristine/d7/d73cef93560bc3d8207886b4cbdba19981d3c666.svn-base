package com.ve.tradecenter.core.manager.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.dao.PaymentDao;
import com.ve.tradecenter.core.domain.PaymentDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.PaymentManager;
import com.ve.tradecenter.core.service.action.cart.AddCartItem;

public class PaymentManagerImpl implements PaymentManager{
	private static final Logger log = LoggerFactory.getLogger(AddCartItem.class);

	@Resource 
	private PaymentDao paymentDao;
	
	@Override
	public Long addPayment(PaymentDO payment) throws TradeException {
		Long result =0L;
		try{
			result =  this.paymentDao.addPayment(payment);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit addPayment id: " + result);
		return result;
	}

	@Override
	public int deletePayment(Integer paymentId) throws TradeException {
		log.info("enter deletePayment : " + paymentId);
		int result = 0;
		try{
			this.paymentDao.deletePayment(paymentId);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit deletePayment ,result : " + result);
		return result;
	}

	@Override
	public int updatePayment(PaymentDO payment) throws TradeException {
		log.info("enter updatePayment: " + payment.getId());
		int result = 0;
		try{
			result = this.paymentDao.updatePayment(payment);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit updatePayment, result:  " + result);
		return result;
	}

	@Override
	public PaymentDO getPayment(Integer paymentId) throws TradeException {
		log.info("enter getPayment : " + paymentId );
		PaymentDO payment = this.paymentDao.getPayment(paymentId);
		log.info("exit getPayment: " + payment);
		return payment;
	}
	
	@Override
	public PaymentDO getPaymentByClass(String className)throws TradeException{
		log.info("enter getPaymentByClass : " + className);
		PaymentDO payment = new PaymentDO();
		payment.setClassName(className);
		try{
			payment = this.paymentDao.getPaymentByClass(payment);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit getPaymentByClass : " + payment);
		return payment;
	}

	@Override
	public String getPaymentSignKey(PaymentDO payment) throws TradeException {
		String key ="";
		
		// TODO
		// 获取支付宝的签名key
		
		return key;
		
	}
	
}
