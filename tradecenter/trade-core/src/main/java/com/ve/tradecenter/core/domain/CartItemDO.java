package com.ve.tradecenter.core.domain;

import java.util.Date;

public class CartItemDO {
    private Long id; // 主键

    private String name; //产品名称

    private Long itemSkuId; // 销售属性ID

    private Long supplierId; // 供应商ID
 
    private Long userId; // 用户ID

    private Long itemId; // 商品ID

    private String subName; // 名称简称

    private String sessionId; // 客户端唯一标识

    private Long originPrice; // 原价

    private Long unitPrice; // 单价

    private Integer number; // 数量

    private Long totalPrice; // 总价

    private Long savePrice; // 节省金额

    private Long totalSave; // 总节省金额 

    private Long returnMoney; // 返现金额

    private Long returnTotalMoney; // 总返现金额

    private Integer returnScore; // 返积分

    private Integer returnTotalScore; // 总返积分

    private Integer returnPoint; // 返点

    private Integer returnTotalPoint; // 总返点 

    private Boolean isGift; // 是否赠品

    private Integer source; // 端口 （pc、ios、android、wap）

    private Date gmtCreated; // 写入时间

    private Date gmtModified; // 修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getItemSkuId() {
        return itemSkuId;
    }

    public void setItemSkuId(Long itemSkuId) {
        this.itemSkuId = itemSkuId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public Long getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Long originPrice) {
        this.originPrice = originPrice;
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

    public Long getSavePrice() {
        return savePrice;
    }

    public void setSavePrice(Long savePrice) {
        this.savePrice = savePrice;
    }

    public Long getTotalSave() {
        return totalSave;
    }

    public void setTotalSave(Long totalSave) {
        this.totalSave = totalSave;
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

    public Boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }
    
    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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
}