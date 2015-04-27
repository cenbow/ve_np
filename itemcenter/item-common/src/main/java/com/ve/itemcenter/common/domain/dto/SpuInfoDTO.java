package com.ve.itemcenter.common.domain.dto;

import java.io.Serializable;

public class SpuInfoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2616331975379302681L;

	private Long id;

	private String spuName; // spu属性名称

	private Integer createType;// spu属性名称

	private Long createId;// 创建者用户ID

	private Integer spuStatus;// 状态：使用中/已停用

	private Integer isDeleted;// 删除标志

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpuName() {
		return spuName;
	}

	public void setSpuName(String spuName) {
		this.spuName = spuName == null ? null : spuName.trim();
	}

	public Integer getCreateType() {
		return createType;
	}

	public void setCreateType(Integer createType) {
		this.createType = createType;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Integer getSpuStatus() {
		return spuStatus;
	}

	public void setSpuStatus(Integer spuStatus) {
		this.spuStatus = spuStatus;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "SpuInfoDTO [id=" + id + ", spuName=" + spuName + "]";
	}

}