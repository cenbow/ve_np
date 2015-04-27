package com.ve.itemcenter.common.domain.qto;

import com.ve.itemcenter.common.page.PageInfo;

/**
 * SKU属性QTO
 * 
 * @author chen.huang
 * @date 2015年1月21日
 */

public class SkuPropertyQTO extends PageInfo {
	private Long id;

	private Long skuId;

	private Long sellerId;// 卖家ID

	private Integer isDeleted;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

}