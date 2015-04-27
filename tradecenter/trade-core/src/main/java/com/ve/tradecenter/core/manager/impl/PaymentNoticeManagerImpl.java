package com.ve.tradecenter.core.manager.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.dao.PaymentNoticeDao;
import com.ve.tradecenter.core.domain.PaymentNoticeDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.PaymentNoticeManager;
import com.ve.tradecenter.core.service.RequestDispatcher;

public class PaymentNoticeManagerImpl implements PaymentNoticeManager{
	private static final Logger log = LoggerFactory.getLogger(RequestDispatcher.class);
	
	@Resource 
	private PaymentNoticeDao paymentNoticeDao;

	@Override
	public Long addPaymentNotice(PaymentNoticeDO paymentNoticeDO)throws TradeException {
		log.info("enter addPaymentNotice");
		long id = 0L;
		try{
			 id = this.paymentNoticeDao.addPaymemntNotice(paymentNoticeDO);
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit addPaymentNotice id: " + id);
		return id;
	}

	@Override
	public PaymentNoticeDO getPaymentNoticeByTradeNo(String tradeNo,long supplierId)throws TradeException{
		log.info("enter getPaymentNoticeByTradeNo: " + tradeNo + ","+ supplierId);
		PaymentNoticeDO paymentNotice = new PaymentNoticeDO();
		// 根据交易号和用户Id查询交易单
		paymentNotice.setTradeNo(tradeNo);
		paymentNotice.setSupplierId(supplierId);
		paymentNotice = this.paymentNoticeDao.getPaymentNoticeByTradeNo(paymentNotice);
		log.info("exit getPaymentNoticeByTradeNo " +paymentNotice );
		return paymentNotice;
	}
	
	@Override
	public int paySuccess(boolean payStatus,long totalFee,String  outerTradeNo,long id,long supplierId)throws TradeException{
		log.info("enter paySuccess " + " payStatus : " + payStatus + "," + totalFee + "," + outerTradeNo + "," + id + "," + supplierId);
		int result = 0;
		
		PaymentNoticeDO paymentNotice = new PaymentNoticeDO();
		paymentNotice.setIsPaid(payStatus); // 标记为已支付
		paymentNotice.setMoney(totalFee);
		paymentNotice.setOutTradeNo(outerTradeNo);
		paymentNotice.setId(id);
		paymentNotice.setSupplierId(supplierId);

		try {
			result = this.paymentNoticeDao.paySuccess(paymentNotice);
		} catch (Exception e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		log.info("exit paySuccess updated: " + result);
		return result;
	}

}

