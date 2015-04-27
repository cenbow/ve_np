package com.ve.tradecenter.core.manager;

import java.util.Date;
import java.util.List;

import com.ve.tradecenter.common.domain.OrderDTO;
import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.domain.OrderLogDO;
import com.ve.tradecenter.core.exception.TradeException;

	
public interface OrderManager {
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
	public int cancelOrder(Long orderId,Long userId,Date date)throws TradeException;
	
	/**
	 * 删除订单
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeException
	 */
	public Integer deleteOrder(Long orderId,Long userId,Date operateTime)throws TradeException;
	
	/**
	 * 根据订单id和用户id查询订单
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeExcetion
	 */
	public OrderDO getOrder(long orderId ,Long userId)throws TradeException;
	
	/**
	 * 修改订单的收货人信息
	 * @param orderId
	 * @param userId
	 * @param consignee
	 * @param phone
	 * @param address
	 * @return
	 * @throws TradeException
	 */
	public int updateConsigneeInfo(Long orderId,Long userId,String consignee,String phone,String address)throws TradeException;
	
	/**
	 * 跟新订单备注
	 * @param orderId
	 * @param userId
	 * @param newMemo
	 * @param memoType
	 * @return
	 * @throws TradeException
	 */
	public int updateOrderMemo(Long orderId,Long userId,String newMemo,Integer memoType,Date date)throws TradeException;
	
	/**
	 * 查询买家订单
	 * @param orderQTO
	 * @return
	 * @throws TradeException
	 */
	public List<OrderDO> queryUserOrders(OrderQTO orderQTO)throws TradeException;
	
	/**
	 * 复合查询总的订单条数
	 * @param orderQTO
	 * @return
	 * @throws TradeException
	 */
	public int getTotalCount(OrderQTO orderQTO)throws TradeException;
	
	/**
	 * 添加订单操作日志
	 * @param orderLogDO
	 * @return
	 * @throws TradeException
	 */
	public long addOrderLog(OrderLogDO orderLogDO)throws TradeException;
	
	/**
	 * 顾客确认签收，  更改订单的配送状态
	 * @param orderDO
	 * @return
	 * @throws TradeException
	 */
	public int confirmReceival(long orderId,long userId,int deliveryStatus,Date operateTime)throws TradeException;
	
	/**
	 * 订单发货
	 * @param userId
	 * @param orderId
	 * @return
	 */
	public int deliveryGoods(long orderId,long userId,int deliveryStatus,Date date) throws TradeException;
	
	/**
	 * 查询有效订单
	 * @param orderQTO
	 * @return
	 * @throws TradeException
	 */
	public OrderDO getActiveOrder(Long orderId ,Long userId)throws TradeException;
	
	/**
	 * 标记订单的支付状态为已成功
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeException
	 */
	public int orderPaySuccess(int payStatus,Long orderId,Long userId)throws TradeException;
	
	/**
	 * 结单 ，表示订单的生命周期结束不能再对订单做其他状态相关的操作
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeException
	 */
	public int closeOrder(Long orderId, Long userId,int orderStatus,Date operateTime)throws TradeException;
	
	/**
	 * 退货申请
	 * @param orderId
	 * @param userid
	 * @return
	 * @throws TradeException
	 */
	public int applyReturn(long orderId,long userId,int afterSale,Date date)throws TradeException;
	
	/**
	 * 审核用户退货申请
	 * @param auditResult  0： 退款申请不通过 1： 退款申请通过
	 * @param orderId
	 * @param userid
	 * @return
	 */
	public int auditReturnApply(long orderId,long userId,int aferSale,Date date)throws TradeException;
	
	/**
	 * 退款操作标记订单状态为--已退款，并且结单
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws TradeException
	 */
	public int refund(Long orderId,Long userId,int afterSale,Date operateTime)throws TradeException;
	
	/**
	 * 下单时候字段验证
	 * @param orderQTO
	 * @return
	 * @throws TradeEception
	 */
	public String validateFields4Add(OrderDTO orderDTO)throws TradeException;
	
}
