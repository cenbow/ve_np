package com.ve.tradecenter.common.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable {
	
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

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}

	public Boolean getNeedInvoice() {
		return needInvoice;
	}

	public void setNeedInvoice(Boolean needInvoice) {
		this.needInvoice = needInvoice;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Long getTotalToPay() {
		return totalToPay;
	}

	public void setTotalToPay(Long totalToPay) {
		this.totalToPay = totalToPay;
	}

	public Long getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public Long getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(Long itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}

	public Long getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Long discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Long getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(Long deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Integer getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Long getPaymentFee() {
		return paymentFee;
	}

	public void setPaymentFee(Long paymentFee) {
		this.paymentFee = paymentFee;
	}

	public Long getReturnTotalMoney() {
		return returnTotalMoney;
	}

	public void setReturnTotalMoney(Long returnTotalMoney) {
		this.returnTotalMoney = returnTotalMoney;
	}

	public Integer getAfterSale() {
		return afterSale;
	}

	public void setAfterSale(Integer afterSale) {
		this.afterSale = afterSale;
	}

	public Long getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(Long refundMoney) {
		this.refundMoney = refundMoney;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Integer getRetakeStatus() {
		return retakeStatus;
	}

	public void setRetakeStatus(Integer retakeStatus) {
		this.retakeStatus = retakeStatus;
	}

	public String getCouponMobile() {
		return couponMobile;
	}

	public void setCouponMobile(String couponMobile) {
		this.couponMobile = couponMobile;
	}

	public Boolean getIsCod() {
		return isCod;
	}

	public void setIsCod(Boolean isCod) {
		this.isCod = isCod;
	}

	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Integer getInvoiceClass() {
		return invoiceClass;
	}

	public void setInvoiceClass(Integer invoiceClass) {
		this.invoiceClass = invoiceClass;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public Long getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(Long couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public Long getPromotionDiscount() {
		return promotionDiscount;
	}

	public void setPromotionDiscount(Long promotionDiscount) {
		this.promotionDiscount = promotionDiscount;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getUserMemo() {
		return userMemo;
	}

	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}

	public String getSellerMemo() {
		return sellerMemo;
	}

	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	public String getAdminMemo() {
		return adminMemo;
	}

	public void setAdminMemo(String adminMemo) {
		this.adminMemo = adminMemo;
	}

	public Integer getExtraStatus() {
		return extraStatus;
	}

	public void setExtraStatus(Integer extraStatus) {
		this.extraStatus = extraStatus;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	private Long id;// 主键
	
	private Long userId;// 用户ID 
	
	private Long addressId;// 收货地址id
	
	private Integer paymentId;// 支付方式
	
	private List<OrderItemDTO> orderItems;// 下单明细列表 
	
	public boolean getIsCoupon() {
		return isCoupon;
	}

	public void setIsCoupon(boolean isCoupon) {
		this.isCoupon = isCoupon;
	}

	private boolean isCoupon; // 是否使用优惠券
	
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", userId=" + userId + ", addressId="
				+ addressId + ", paymentId=" + paymentId + ", orderItems="
				+ orderItems + ", isCoupon=" + isCoupon + ", needInvoice="
				+ needInvoice + ", couponId=" + couponId + ", orderSn="
				+ orderSn + ", supplierId=" + supplierId + ", payStatus="
				+ payStatus + ", totalToPay=" + totalToPay + ", payAmount="
				+ payAmount + ", deliveryStatus=" + deliveryStatus
				+ ", orderStatus=" + orderStatus + ", refundAmount="
				+ refundAmount + ", address=" + address + ", tel=" + tel
				+ ", mobile=" + mobile + ", consignee=" + consignee
				+ ", itemTotalPrice=" + itemTotalPrice + ", discountPrice="
				+ discountPrice + ", deliveryFee=" + deliveryFee
				+ ", deliveryId=" + deliveryId + ", paymentFee=" + paymentFee
				+ ", returnTotalMoney=" + returnTotalMoney + ", afterSale="
				+ afterSale + ", refundMoney=" + refundMoney + ", bankCode="
				+ bankCode + ", userName=" + userName + ", refundStatus="
				+ refundStatus + ", retakeStatus=" + retakeStatus
				+ ", couponMobile=" + couponMobile + ", isCod=" + isCod
				+ ", invoiceStatus=" + invoiceStatus + ", invoiceClass="
				+ invoiceClass + ", invoiceType=" + invoiceType
				+ ", invoiceTitle=" + invoiceTitle + ", couponDiscount="
				+ couponDiscount + ", promotionDiscount=" + promotionDiscount
				+ ", gmtCreated=" + gmtCreated + ", gmtModified=" + gmtModified
				+ ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", userMemo=" + userMemo + ", sellerMemo=" + sellerMemo
				+ ", adminMemo=" + adminMemo + ", extraStatus=" + extraStatus
				+ ", source=" + source + ", number=" + number + "]";
	}

	private Boolean needInvoice; // 是否需要发票

	private Long couponId;  // 优惠券

	private String orderSn;// 订单号

	private Long supplierId;// 供应商ID

	private Integer payStatus;// 支付状态

	private Long totalToPay;// 待支付金额

	private Long payAmount;// 已支付金额

	private Integer deliveryStatus;// 发货状态

	private Integer orderStatus;//订单状态

	private Long refundAmount;// 退款金额

	private String address;// 详细地址

	private String tel;// 固定电话
 
	private String mobile;// 移动电话

	private String consignee;// 收货人

	private Long itemTotalPrice;// 

	private Long discountPrice;// 

	private Long deliveryFee;// 运费

	private Integer deliveryId;// 配送方式

	private Long paymentFee;// 支付手续费

	private Long returnTotalMoney;// 

	private Integer afterSale;// 售后状态

	private Long refundMoney;// 

	private String bankCode;// 

	private String userName;//

	private Integer refundStatus;//

	private Integer retakeStatus;//

	private String couponMobile;//

	private Boolean isCod;//

	private Integer invoiceStatus;//

	private Integer invoiceClass;//

	private Integer invoiceType;//

	private String invoiceTitle;//

	private Long couponDiscount;//

	private Long promotionDiscount;//

	private Date gmtCreated;//

	private Date gmtModified;//

	private Boolean isActive;//

	private Integer isDelete;//

	private String userMemo;//

	private String sellerMemo;//

	private String adminMemo;//

	private Integer extraStatus;//
 
	private Integer source;// 渠道来源
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	private Integer number;

	
}
