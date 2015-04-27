package com.ve.tradecenter.common.domain;

import java.io.Serializable;
import java.util.Date;

public class ItemSkuDTO implements Serializable {	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public Boolean getIsGift() {
		return isGift;
	}

	public void setIsGift(Boolean isGift) {
		this.isGift = isGift;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemSkuName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getReturnPoint() {
		return returnPoint;
	}

	public void setReturnPoint(Integer returnPoint) {
		this.returnPoint = returnPoint;
	}

	public Integer getReturnScore() {
		return returnScore;
	}

	public void setReturnScore(Integer returnScore) {
		this.returnScore = returnScore;
	}

	public Long getReturnMoney() {
		return returnMoney;
	}

	public void setReturnMoney(Long returnMoney) {
		this.returnMoney = returnMoney;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getOrigin_price() {
		return origin_price;
	}

	public void setOrigin_price(Long origin_price) {
		this.origin_price = origin_price;
	}

	public Integer getMinBuyAmount() {
		return minBuyAmount;
	}

	public void setMinBuyAmount(Integer minBuyAmount) {
		this.minBuyAmount = minBuyAmount;
	}

	public Integer getMaxBuyAmount() {
		return maxBuyAmount;
	}

	public void setMaxBuyAmount(Integer maxBuyAmount) {
		this.maxBuyAmount = maxBuyAmount;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getShipper() {
		return shipper;
	}

	public void setShipper(Long shipper) {
		this.shipper = shipper;
	}

	public Long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Long currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Integer getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(Integer promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public Long getWirelessPrice() {
		return wirelessPrice;
	}

	public void setWirelessPrice(Long wirelessPrice) {
		this.wirelessPrice = wirelessPrice;
	}

	public Long getStockNum() {
		return stockNum;
	}

	public void setStockNum(Long stockNum) {
		this.stockNum = stockNum;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private Long id; // 必须

	private String codeValue; // sku代号，例如：红色-42码，sku名称为多个不同维度的sku属性的key按一定顺序拼装而成

	private Boolean isGift; // 是否是礼品
	
	private String itemName; // 名字
	
	private Integer returnPoint; // 返点

	private Integer returnScore; // 返积分
	
	private Long returnMoney; // 返现金额

	private Date startTime; // 销售开始时间
	
	private Date endTime; // 销售结束时间
	
	private Boolean isDelete; // 是否删除
	
	private Long origin_price; // 原价
	
	private Integer minBuyAmount; //最小购买量     必须
	
	private Integer maxBuyAmount; // 最大购买量   必须
	
	private Long itemId; // 商品ID  

	private String materialCode;// 物料码

	private String barCode;// 条码

	private Long supplierId; // 卖家ID 必须
	
	private Long shipper; // 发货商

	private Long currentPrice;// 现价

	private Integer promotionPrice;// 促销价 

	private Long wirelessPrice;// 无线价

	private Long stockNum;// 库存量
	
	private Integer weight; //重量
	
	private String mainImage; // 主图
	
	private String name;
	
}
