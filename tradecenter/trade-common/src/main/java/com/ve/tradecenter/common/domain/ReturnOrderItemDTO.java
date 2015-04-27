package com.ve.tradecenter.common.domain;

public class ReturnOrderItemDTO {
	
	public Long getItemSkuId() {
		return itemSkuId;
	}

	public void setItemSkuId(Long itemSkuId) {
		this.itemSkuId = itemSkuId;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getReturnDesc() {
		return returnDesc;
	}

	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc;
	}

	public String getReturnAttach() {
		return returnAttach;
	}

	public void setReturnAttach(String returnAttach) {
		this.returnAttach = returnAttach;
	}
	
	private Long itemSkuId ;
	
	private String item_name;
	
	private Long supplierId;
	
	private Integer number;
	
	private String returnReason;
	
	private String returnDesc;
	
	private String returnAttach;
	
}
