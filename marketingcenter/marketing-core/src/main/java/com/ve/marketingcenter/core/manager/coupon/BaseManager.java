package com.ve.marketingcenter.core.manager.coupon;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponConstant;
import com.ve.marketingcenter.common.domain.qto.BaseQTO;
import com.ve.marketingcenter.common.domain.qto.coupon.Page;
import com.ve.marketingcenter.core.dao.coupon.BaseDao;
import com.ve.marketingcenter.core.domain.coupon.BaseDo;
import com.ve.marketingcenter.core.exception.MarketingException;

public abstract class BaseManager {
	private static final Log log = LogFactory.getLog(BaseManager.class);
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<BaseDo> query(BaseQTO qto) throws MarketingException {
		if (qto.getPageNo() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"pageNo is null");
		}
		if (qto.getPageNo() > CouponConstant.MAX_PAGE_NO) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_ERROR.getCode(),
					"pageNo over max no");
		}
		if (qto.getPageSize() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"pageSize is null");
		}
		if (qto.getPageSize() > Long.valueOf(CouponConstant.MAX_PAGE_SIZE)) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_ERROR.getCode(),
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
