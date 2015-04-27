package com.ve.tradecenter.core.manager;

import java.util.Date;

import com.ve.tradecenter.common.domain.DeliveryNoticeDTO;
import com.ve.tradecenter.core.domain.DeliveryNoticeDO;
import com.ve.tradecenter.core.exception.TradeException;

public interface DeliveryNoticeManager {
	
	public long addDeliveryNotice(DeliveryNoticeDO deliveryNoticeDO)throws TradeException;
	
	public int confirmReceival(long orderId,long userId,boolean isArrival,Date operateTime)throws TradeException;
	
	public String validateFields(DeliveryNoticeDTO deliveryNoticeDTO);
	
}
