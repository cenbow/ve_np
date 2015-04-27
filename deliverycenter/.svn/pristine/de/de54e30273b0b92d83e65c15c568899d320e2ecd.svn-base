package com.ve.deliverycenter.core.manager;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ve.deliverycenter.common.constant.DeliveryConstant;
import com.ve.deliverycenter.common.constant.RetCodeEnum;
import com.ve.deliverycenter.common.qto.BaseQTO;
import com.ve.deliverycenter.common.qto.Page;
import com.ve.deliverycenter.core.dao.BaseDao;
import com.ve.deliverycenter.core.domain.BaseDo;
import com.ve.deliverycenter.core.exception.DeliveryException;

public abstract class BaseManager {
	private static final Log log = LogFactory.getLog(BaseManager.class);
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<BaseDo> query(BaseQTO qto) throws DeliveryException {
		if (qto.getPageNo() == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"pageNo is null");
		}
		if (qto.getPageNo() > DeliveryConstant.MAX_PAGE_NO) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_ERROR.getCode(),
					"pageNo over max no");
		}
		if (qto.getPageSize() == null) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_NULL.getCode(),
					"pageSize is null");
		}
		if (qto.getPageSize() > Long.valueOf(DeliveryConstant.MAX_PAGE_SIZE)) {
			throw new DeliveryException(RetCodeEnum.PARAMETER_ERROR.getCode(),
					"pageSize over max size");
		}
		String listStatementName = getQueryStatement(qto.getClass(), "query");
		String countStatementName = getCountStatement(qto.getClass(),
				"queryCount");
		Long totalCount = (Long) getBaseDao().queryForObject(
				countStatementName, qto);
		qto.setTotalCount(totalCount);
		Page page = new Page();
		page.initPageParameter(totalCount, qto.getPageNo().toString(),
				qto.getPageSize());
		qto.setStartRow(page.getStartRow());
		return getBaseDao().queryForList(listStatementName, qto);
	}

	private String getQueryStatement(Class qtoClass, String curdName) {
		String className = qtoClass.getName()
				.substring(qtoClass.getName().lastIndexOf(".") + 1)
				.replace("QTO", "");
		return className.toUpperCase() + "." + curdName + className;
	}

	private String getCountStatement(Class qtoClass, String curdName) {
		String className = qtoClass.getName()
				.substring(qtoClass.getName().lastIndexOf(".") + 1)
				.replace("QTO", "");
		return className.toUpperCase() + "." + curdName;
	}
}
