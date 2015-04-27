package com.ve.itemcenter.common.domain.qto;

import com.ve.itemcenter.common.page.PageInfo;

/**
 * SKU模板属性QTO
 * 
 * @author chen.huang
 * @date 2015年1月21日
 */
public class SkuPropertyTmplQTO extends PageInfo {
	private Integer categoryId; // 所属类目ID

	private Integer isDeleted;

	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
