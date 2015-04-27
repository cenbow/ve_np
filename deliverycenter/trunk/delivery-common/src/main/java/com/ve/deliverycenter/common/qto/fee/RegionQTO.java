package com.ve.deliverycenter.common.qto.fee;

import com.ve.deliverycenter.common.qto.BaseQTO;

public class RegionQTO extends BaseQTO implements java.io.Serializable {
	private Integer parentId;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
