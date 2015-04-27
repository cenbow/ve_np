package com.ve.tradecenter.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.OrderDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.domain.OrderItemDO;
import com.ve.tradecenter.core.domain.OrderSeqDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderSeqManager;

public class TradeUtils {
	private static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyymmdd");
	
	@Resource
	private OrderSeqManager orderSeqManager;
	
	/**
	 * 将DTO对象转换为DO对象用于数据持久化
	 * @param srcObject
	 * @param destObject
	 * @return
	 */
	public static void convert2DO(Object srcObject,Object destObject){
		BeanUtils.copyProperties(srcObject, destObject);
	}
	
	/**
	 * 将持久化的对象DO转化为DTO用户数据传输
	 * @param srcObject
	 * @param destObject
	 * @return
	 */
	public static void convert2DTO(Object srcObject,Object destObject){
		BeanUtils.copyProperties(srcObject, destObject);
	}
	
	/**
	 * 将OrderDO转换为OrderDTO
	 * @param order
	 * @return
	 */
	public static OrderDTO convert2OrderDTO(OrderDO order){
		if(order == null){
			return null;
		}
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderStatus(order.getOrderStatus());
		orderDTO.setOrderSn(order.getOrderSn());
		orderDTO.setAddress(order.getAddress());
		orderDTO.setAddressId(order.getAddressId());
		orderDTO.setAfterSale(order.getAfterSale());
		orderDTO.setGmtCreated(order.getGmtCreated());
		orderDTO.setConsignee(order.getConsignee());
		orderDTO.setDeliveryStatus(order.getDeliveryStatus());
		orderDTO.setDeliveryFee(order.getDeliveryFee());
		orderDTO.setDeliveryStatus(order.getDeliveryStatus());
		orderDTO.setId(order.getId());
		orderDTO.setNeedInvoice(order.getNeedInvoice());
		orderDTO.setPayAmount(order.getPayAmount());
		orderDTO.setTotalAmount(order.getTotalAmount());
		orderDTO.setPaymentId(order.getPaymentId());
		orderDTO.setPayStatus(order.getPayStatus());
		orderDTO.setMobile(order.getMobile());
		orderDTO.setTel(order.getTel());
		orderDTO.setSource(order.getSource());
		orderDTO.setSupplierId(order.getSupplierId());
		orderDTO.setUserId(order.getUserId());
		orderDTO.setUserName(order.getUserName());
		orderDTO.setInvoiceClass(order.getInvoiceClass());
		orderDTO.setInvoiceStatus(order.getInvoiceClass());
		orderDTO.setInvoiceTitle(order.getInvoiceTitle());
		orderDTO.setInvoiceType(order.getInvoiceType());
		orderDTO.setUserMemo(order.getUserMemo());
		orderDTO.setIsActive(order.getIsActive());
		orderDTO.setPromotionDiscount(order.getPromotionDiscount()); // 活动节省金额
		orderDTO.setCouponDiscount(order.getCouponDiscount()); // 优惠券节省金额
		
		return orderDTO;
	}
	
	/**
	 * orderItemDO 
	 * @return
	 */
	public static OrderItemDTO convert2OrderItemDTO(OrderItemDO orderItem){		
		if(orderItem == null){
			return null;
		}
		
		// 传递给调用方必要的字段
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setId(orderItem.getId());
		orderItemDTO.setIsGift(orderItem.getIsGift());
		orderItemDTO.setItemName(orderItem.getItemName());
		orderItemDTO.setItemSkuId(orderItem.getItemSkuId());
		orderItemDTO.setOrderId(orderItem.getOrderId());
		orderItemDTO.setOrderSn(orderItem.getOrderSn());
		orderItemDTO.setUnitPrice(orderItem.getUnitPrice());
		orderItemDTO.setNumber(orderItem.getNumber());
		orderItemDTO.setTotalPrice(orderItem.getTotalPrice());
		
		return orderItemDTO;
	}
	
	/**
	 * md5加密
	 * @param str
	 * @return
	 */
	public static String md5(String str)throws TradeException{
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());
			byte b[] = messageDigest.digest();
			
			StringBuffer buf = new StringBuffer("");
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if(i<0) 
					i+= 256;
				if(i<16) 
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e){
			throw new TradeException(ResponseCode.SYS_E_DEFAULT_ERROR,e);
		}
	}
	
}
