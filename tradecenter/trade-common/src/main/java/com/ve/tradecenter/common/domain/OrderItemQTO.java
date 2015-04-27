package com.ve.tradecenter.common.domain;

import java.io.Serializable;

public class OrderItemQTO implements Serializable {

	private Long orderItemId;
	
	private String itemName;
	
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}	
