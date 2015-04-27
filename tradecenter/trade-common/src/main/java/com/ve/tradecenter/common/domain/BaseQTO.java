package com.ve.tradecenter.common.domain;

import java.io.Serializable;

public class BaseQTO  implements Serializable{
	private Integer start;  //分页起始
	
	private Integer offset; // 分页长度
	
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}
