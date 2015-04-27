package com.ve.marketingcenter.common.api;

import java.io.Serializable;

public interface Response<T> extends Serializable {
	public T getModule();

	public String getResCode();

	public String getMessage();

	public long getTotalCount();

	public boolean isSuccess();

}
