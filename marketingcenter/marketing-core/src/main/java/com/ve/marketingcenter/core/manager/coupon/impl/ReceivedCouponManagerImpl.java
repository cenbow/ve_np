package com.ve.marketingcenter.core.manager.coupon.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.domain.qto.coupon.ReceivedCouponQTO;
import com.ve.marketingcenter.core.domain.coupon.BaseDo;
import com.ve.marketingcenter.core.domain.coupon.ReceivedCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.coupon.BaseManager;
import com.ve.marketingcenter.core.manager.coupon.ReceivedCouponManager;

@Service
public class ReceivedCouponManagerImpl extends BaseManager implements
		ReceivedCouponManager {

	@Override
	public ReceivedCoupon addReceivedCoupon(ReceivedCoupon receivedCoupon)
			throws MarketingException {
		if (receivedCoupon == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"receivedCoupon is null");
		}
		// 执行新增操作
		receivedCoupon = (ReceivedCoupon) getBaseDao().insert(receivedCoupon);

		return receivedCoupon;
	}

	@Override
	public int batchAddReceivedCoupon(List<ReceivedCoupon> receivedCouponList)
			throws MarketingException {
		if (receivedCouponList == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"receivedCouponList is null");
		}
		// 执行新增操作
		getBaseDao().batchInsert("RECEIVEDCOUPON.batchAddReceivedCoupon",
				receivedCouponList);
		return receivedCouponList.size();
	}

	@Override
	public int freezeCoupon(ReceivedCoupon receivedCoupon)
			throws MarketingException {
		if (receivedCoupon == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"receivedCoupon is null");
		}

		// 执行更新操作
		int row = getBaseDao().update("RECEIVEDCOUPON.freezeCoupon",
				receivedCoupon);
		return row;
	}

	@Override
	public int updateCouponStatus(ReceivedCoupon receivedCoupon)
			throws MarketingException {
		if (receivedCoupon == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"receivedCoupon is null");
		}

		// 执行更新操作
		int row = getBaseDao().update("RECEIVEDCOUPON.updateCouponStatus",
				receivedCoupon);
		return row;
	}

	@Override
	public List queryReceivedCoupon(ReceivedCouponQTO receivedCouponQTO)
			throws MarketingException {
		if (receivedCouponQTO == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"receivedCouponQTO is null");
		}
		List<BaseDo> receivedCouponList = query(receivedCouponQTO);
		return receivedCouponList;
	}

}
