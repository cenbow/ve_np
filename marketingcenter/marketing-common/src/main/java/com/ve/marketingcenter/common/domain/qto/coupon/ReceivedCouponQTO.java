package com.ve.marketingcenter.common.domain.qto.coupon;

import java.io.Serializable;

import com.ve.marketingcenter.common.domain.qto.BaseQTO;

public class ReceivedCouponQTO extends BaseQTO implements Serializable {
	private Long userId;
	private Integer status;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
