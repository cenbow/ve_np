package com.ve.deliverycenter.common.qto.express;

import com.ve.deliverycenter.common.qto.BaseQTO;

public class ExpressQTO extends BaseQTO implements java.io.Serializable {
	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
