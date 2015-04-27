package com.ve.itemcenter.common.domain.qto;

import com.ve.itemcenter.common.page.PageInfo;

public class ItemCategoryQTO extends PageInfo {
	private Integer id;

	private String cateName; // 类目名称

	private Integer cateLevel;// 类目层级

	private Integer parentId; // 父ID

	private Integer spuId;// 所关联的spu属性记录

	private Integer sort;

	private Integer cateStatus;// 类目状态

	private Integer isRecommend; // 是否推荐

	private Integer topid; // 所属一级类目

	private Integer isDeleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName == null ? null : cateName.trim();
	}

	public Integer getCateLevel() {
		return cateLevel;
	}

	public void setCateLevel(Integer cateLevel) {
		this.cateLevel = cateLevel;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSpuId() {
		return spuId;
	}

	public void setSpuId(Integer spuId) {
		this.spuId = spuId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getCateStatus() {
		return cateStatus;
	}

	public void setCateStatus(Integer cateStatus) {
		this.cateStatus = cateStatus;
	}

	public Integer getTopid() {
		return topid;
	}

	public void setTopid(Integer topid) {
		this.topid = topid;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

}