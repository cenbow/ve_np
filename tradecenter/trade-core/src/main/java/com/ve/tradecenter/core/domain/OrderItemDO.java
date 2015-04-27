package com.ve.tradecenter.core.domain;

import java.util.Date;

public class OrderItemDO {
    private Long id;

    private Long userId;

    private String userName;

    private Long orderId;

    private String orderSn;

    private Long itemId;

    private Long itemSkuId;

    private Long unitPrice;

    private Integer number;

    private Long totalPrice;

    private Integer deliveryId;

    private Integer deliveryStatus;

    private String itemName;

    private Long returnMoney;

    private Long returnTotalMoney;

    private Integer returnPoint;

    private Integer returnTotalPoint;

    private Integer returnScore;

    private Integer returnTotalScore;

    private Integer buyType;

    private Integer payStatus;

    private Boolean isCod;

    private boolean isGift; 

    private String barcode;

    private Date gmtCreated;

    private Date gmtModified;
    
	private Long supplierId ;
    
    private Integer supplierType;
    
	private Long promotionDiscount;
    
    private Long couponDiscount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemSkuId() {
        return itemSkuId;
    }

    public void setItemSkuId(Long itemSkuId) {
        this.itemSkuId = itemSkuId;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Long getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Long returnMoney) {
        this.returnMoney = returnMoney;
    }

    public Long getReturnTotalMoney() {
        return returnTotalMoney;
    }

    public void setReturnTotalMoney(Long returnTotalMoney) {
        this.returnTotalMoney = returnTotalMoney;
    }

    public Integer getReturnPoint() {
        return returnPoint;
    }

    public void setReturnPoint(Integer returnPoint) {
        this.returnPoint = returnPoint;
    }

    public Integer getReturnTotalPoint() {
        return returnTotalPoint;
    }

    public void setReturnTotalPoint(Integer returnTotalPoint) {
        this.returnTotalPoint = returnTotalPoint;
    }

    public Integer getReturnScore() {
        return returnScore;
    }

    public void setReturnScore(Integer returnScore) {
        this.returnScore = returnScore;
    }

    public Integer getReturnTotalScore() {
        return returnTotalScore;
    }

    public void setReturnTotalScore(Integer returnTotalScore) {
        this.returnTotalScore = returnTotalScore;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Boolean getIsCod() {
        return isCod;
    }

    public void setIsCod(Boolean isCod) {
        this.isCod = isCod;
    }

    public Boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
    
    public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(Integer supplierType) {
		this.supplierType = supplierType;
	}
	
	  public Long getPromotionDiscount() {
			return promotionDiscount;
		}

		public void setPromotionDiscount(Long promotionDiscount) {
			this.promotionDiscount = promotionDiscount;
		}

		public Long getCouponDiscount() {
			return couponDiscount;
		}

		public void setCouponDiscount(Long couponDiscount) {
			this.couponDiscount = couponDiscount;
		}

}