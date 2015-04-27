package com.ve.itemcenter.core.service.action;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.api.ItemResponse;
import com.ve.itemcenter.core.exception.ItemException;
import com.ve.itemcenter.core.service.RequestContext;

/**
 * 操作对像基类
 * 
 * @author wujin.zzq
 *
 */
@Service
public interface Action {

	@SuppressWarnings("rawtypes")
	public ItemResponse execute(RequestContext context) throws ItemException;

	public String getName();
}
