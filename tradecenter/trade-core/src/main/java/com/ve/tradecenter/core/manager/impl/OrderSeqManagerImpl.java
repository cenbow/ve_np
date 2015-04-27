package com.ve.tradecenter.core.manager.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.dao.OrderSeqDao;
import com.ve.tradecenter.core.domain.OrderSeqDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderSeqManager;

public class OrderSeqManagerImpl implements OrderSeqManager {
	
	private static DateFormat DATE_FORMAT =new SimpleDateFormat("yyMMdd");

	@Resource 
	private OrderSeqDao orderSeqDao;

	@Override
	public Integer updateOrderSeq() throws TradeException {
		return this.orderSeqDao.updateOrderDaySeq();
	}

	@Override
	public OrderSeqDO getOrderSeq() throws TradeException {
		return (OrderSeqDO)this.orderSeqDao.getOrderDaySeq();
	}

	@Override
	public OrderSeqDO addOrderSeq(OrderSeqDO orderSeqDO) throws TradeException {
		return this.orderSeqDao.AddOrderDaySeq(orderSeqDO);
	}
	
	@Override
	public String getOrderSn(int source)throws TradeException{
		String orderSn = null;
		
		int affectedRow  = updateOrderSeq();
		
		OrderSeqDO daySeq=null;
		if(affectedRow > 0){
			daySeq = getOrderSeq();
		}else{
			OrderSeqDO orderSeqDO = new OrderSeqDO();
			orderSeqDO.setSeq(1);
			daySeq = addOrderSeq(orderSeqDO);
		}
		String dateStr =  DATE_FORMAT.format(daySeq.getDay());
		String seqStr = StringUtils.leftPad(daySeq.getSeq().toString(), 6, '0');
		if(source != TradeConstants.OrderSource.PC || source != TradeConstants.OrderSource.ANDROID
			|| source != TradeConstants.OrderSource.HTML5 || source != TradeConstants.OrderSource.IOS){
				source = TradeConstants.OrderSource.PC; //默认为pc
		}
		orderSn =  source + dateStr + seqStr;
		return orderSn;
	}
}
