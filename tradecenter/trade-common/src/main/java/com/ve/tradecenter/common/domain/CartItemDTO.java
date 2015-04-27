package com.ve.tradecenter.common.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 购物车商品传输类
 * @author cwr
 */
public class CartItemDTO implements Serializable{

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemSkuId() {
		return itemSkuId;
	}

	public void setItemSkuId(Long itemSkuId) {
		this.itemSkuId = itemSkuId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getTotalSave() {
		return totalSave;
	}

	public void setTotalSave(Long totalSave) {
		this.totalSave = totalSave;
	}

	public Boolean getIsGift() {
		return isGift;
	}

	public void setIsGift(Boolean isGift) {
		this.isGift = isGift;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public List<MarketingActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(List<MarketingActivityDTO> activities) {
		this.activities = activities;
	}
	
	public Date getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}
	
	public Long getSavePrice() {
		return savePrice;
	}

	public void setSavePrice(Long savePrice) {
		this.savePrice = savePrice;
	}

	public Long getTotal_save() {
		return total_save;
	}

	public void setTotal_save(Long total_save) {
		this.total_save = total_save;
	}
	
	private Long id; // 购物车项id

	private Long itemSkuId; // 特定规格商品id
	
	private Long itemId; // 商品id
	
	private String sessionId; // sessionId

	private Long supplierId; // 供应商id

	private Integer number; // 数量

	private Long userId; // 用户id

	private Integer source; // 来源

	private String name; // 商品名称

	private Long unitPrice; // 单价

	private Long totalPrice; // 总价

	private Long totalSave; // 总节省金额

	private Boolean isGift; // 是否礼品

	private String mainImage; // 主图url
	
	private List<MarketingActivityDTO> activities; // 该商品参加的活动
	
	private Date gmtCreated;
	
	private Long savePrice;
	
	private Long total_save;
	
	@Override
	public String toString() {
		return "CartItemDTO [id=" + id + ", itemSkuId=" + itemSkuId
				+ ", itemId=" + itemId + ", sessionId=" + sessionId
				+ ", supplierId=" + supplierId + ", number=" + number
				+ ", userId=" + userId + ", source=" + source + ", name="
				+ name + ", unitPrice=" + unitPrice + ", totalPrice="
				+ totalPrice + ", isGift=" + isGift + ", mainImage="
				+ mainImage + ", activities=" + activities + "]" + "\n";
	}

	/*@Override
	public String toString() {
		return "id: " + this.id + " userId: " + this.userId + " itemSkuId: "
				+ this.itemSkuId + " supplierId: " + this.supplierId
				+ " sessionId: " + this.sessionId + " number: " + this.number
				+ " port: " + this.source;
	}*/
	
}
