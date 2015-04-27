package com.ve.itemcenter.common.api;

import java.io.Serializable;

public interface Response<T> extends Serializable {
	public T getModule();

	public String getErrorCode();

	public String getMessage();

	public long getTotalCount();
}
