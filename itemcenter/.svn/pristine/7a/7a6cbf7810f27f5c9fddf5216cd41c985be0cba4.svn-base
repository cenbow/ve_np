package com.ve.itemcenter.common.domain.qto;

import java.util.Date;

import com.ve.itemcenter.common.page.PageInfo;

public class ItemPropertyTmplQTO extends PageInfo {
	private Long id;

	private String tmplName; // 模板名称

	private Integer ownerType;// 模板属主类型：1代表系统模板，2代表用户模板

	private Long ownerId;// owner_type=1，则owner_id为0，如果owner_type=2，则owner_id为用户ID

	private Integer propertyType;// 属性类型: 0：一般属性;1：关键属性;2:SKU属性

	private String keyName;// 属性名

	private String val;// 属性值

	private Integer valType;// 属性值

	private Integer sort;// 排序字段，如果该字段值相同，则按照属性key来排序

	private Integer inheritType;// 继承类型：0不可继承，1可继承。继承的意思是下级类目是否可以继承父级类目的属性

	private Long bizMark;// 业务标志，例如是否包含图片等等

	private String imgUrl;// 业务标志，例如是否包含图片等等

	private Integer categoryId;// 所属类目ID

	private Integer isDeleted;

	private Date gmtCreated;

	private Date gmtModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTmplName() {
		return tmplName;
	}

	public void setTmplName(String tmplName) {
		this.tmplName = tmplName == null ? null : tmplName.trim();
	}

	public Integer getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName == null ? null : keyName.trim();
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val == null ? null : val.trim();
	}

	public Integer getValType() {
		return valType;
	}

	public void setValType(Integer valType) {
		this.valType = valType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getInheritType() {
		return inheritType;
	}

	public void setInheritType(Integer inheritType) {
		this.inheritType = inheritType;
	}

	public Long getBizMark() {
		return bizMark;
	}

	public void setBizMark(Long bizMark) {
		this.bizMark = bizMark;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl == null ? null : imgUrl.trim();
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
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