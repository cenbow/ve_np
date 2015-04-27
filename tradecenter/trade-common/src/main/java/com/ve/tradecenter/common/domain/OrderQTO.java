package com.ve.tradecenter.common.domain;

import java.io.Serializable;
import java.util.Date;

public class OrderQTO extends BaseQTO implements Serializable {
	
	private Long id;// 主键
	
	private Long supplierId; // 供应商id
	
	private Long userId;// 用户id
	
	private String userName;
	
	private String orderSn;
	
	private Integer orderStatus; //
	
	private Date timeBegin;
	
	private Date timeEnd;
	
	private Date payTimeBegin;
	
	private Date payTimeEnd;
	
	private Integer deliveryStatus;
	
	private Integer payStatus;
	
	private Integer afterSale;

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id =id;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(Date timeBegin) {
		this.timeBegin = timeBegin;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getPayTimeBegin() {
		return payTimeBegin;
	}

	public void setPayTimeBegin(Date payTimeBegin) {
		this.payTimeBegin = payTimeBegin;
	}

	public Date getPayTimeEnd() {
		return payTimeEnd;
	}

	public void setPayTimeEnd(Date payTimeEnd) {
		this.payTimeEnd = payTimeEnd;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
	public Integer getAfterSale() {
		return afterSale;
	}

	public void setAfterSale(Integer afterSale) {
		this.afterSale = afterSale;
	}

}
