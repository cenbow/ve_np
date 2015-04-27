package com.ve.marketingcenter.common.domain.qto;

import com.ve.marketingcenter.common.domain.qto.coupon.PageQuery;

public class BaseQTO extends PageQuery {
	private Long id;

	private Integer start;

	private Integer offset;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getOffset() {
		return offset;
	}

	/**
	 * CONTINUED 设置结果集的上限
	 * @param offset
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
