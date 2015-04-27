package com.ve.tradecenter.core.domain;

import java.util.Date;

public class UserCartItemDO {
    private Long id;

    private String name;

    private Long itemSkuId;

    private Long supplierId;

    private Long userId;

    private Long itemId;

    private String subName;

    private String sessionId;

    private Long originPrice;

    private Long unitPrice;

    private Integer number;

    private Long totalPrice;

    private Long savePrice;

    private Long totalSave;

    private Long returnMoney;

    private Long returnTotalMoney;

    private Integer returnScore;

    private Integer returnTotalScore;

    private Integer returnPoint;

    private Integer returnTotalPoint;

    private Boolean isGift;

    private Integer port;

    private Date gmtCreated;

    private Date gmtModified;

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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
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