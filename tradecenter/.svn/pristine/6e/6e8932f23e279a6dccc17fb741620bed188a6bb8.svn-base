package com.ve.tradecenter.core.manager;

import java.util.Date;
import java.util.List;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.exception.TradeException;

public interface SellerOrderManager {

	/**
	 * 添加订单接口示例
	 * @param orderDO
	 * @return
	 * @throws TradeException
	 */
	public long addOrder(OrderDO orderDO) throws TradeException;
	
	/**
	 * 取消订单
	 * @param orderDO
	 * @return
	 * @throws TradeException
	 */
	public int cancelOrder(Long orderId,Long supplierId,Date date)throws TradeException;
	
	/**
	 * 删除订单
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeException
	 */
	public int deleteOrder(Long orderId,Long supplierId,Date date)throws TradeException;
	
	/**
	 * 根据订单id和用户id查询订单
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeExcetion
	 */
	public OrderDO getOrder(Long orderId ,Long supplierId)throws TradeException;
	
	/**
	 * 关闭订单 -- 结单
	 * @param orderId
	 * @param supplierId
	 * @return
	 * @throws TradeException
	 */
	public int closeOrder(Long orderId,Long supplierId,int orderStatus,Date date)throws TradeException;
	
	/**
	 * 根据查询条件获取总记录数
	 * @param orderQTO
	 * @return
	 * @throws TradeException
	 */
	public int getTotalCount(OrderQTO orderQTO)throws TradeException;
	
	/**
	 * 复合条件查询卖家订单
	 * @param orderQTO
	 * @return
	 * @throws TradeException
	 */
	public List<OrderDO> querySellerOrder(OrderQTO orderQTO)throws TradeException;
	
	/**
	 * 确认已退款
	 * @param orderId
	 * @param supplierId
	 * @return
	 * @throws TradeException
	 */
	public int refund(Long orderId ,Long supplierId,int afterSale,Date date)throws TradeException;
	
	/**
	 * 更新收货人信息
	 * @param orderId
	 * @param userId
	 * @param consignee
	 * @param phone
	 * @param address
	 * @return
	 * @throws TradeException
	 */
	public int updateConsigneeInfo(Long orderId,Long supplierId,String consignee,String phone,String address)throws TradeException;

	/**
	 * 修改订单备注
	 * @param orderId
	 * @param userId
	 * @param newMemo
	 * @param memoType
	 * @return
	 * @throws TradeException
	 */
	public int updateOrderMemo(Long orderId,Long supplierId,String newMemo,Integer memoType,Date date)throws TradeException;

	/**
	 * 退货申请
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeException
	 */
	public int applyReturn(long orderId ,long supplierId,int afterSale, Date date)throws TradeException;
	
	/**
	 * 审核退货申请
	 * @param orderId
	 * @param supplierId
	 * @param auditResult
	 * @return
	 * @throws TradeException
	 */
	public int auditReturnApply(long orderId,long supplierId,int auditResult,Date date)throws TradeException;
	
	/**
	 * 发货
	 * @param orderId
	 * @param userId
	 * @param deliveryStatus
	 * @param date
	 * @return
	 * @throws TradeException
	 */
	public int deliveryGoods(long orderId,long userId,int deliveryStatus,Date date) throws TradeException;

	/**
	 * 修改订单的支付状态
	 * @param orderId
	 * @param supplierId
	 * @return
	 * @throws TradeException
	 */
	public int OrderPaySuccess(int payStatus,long orderId,long supplierId)throws TradeException;
}
