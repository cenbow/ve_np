package com.ve.marketingcenter.core.service.action.coupon;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ActivityCouponQTO;
import com.ve.marketingcenter.core.domain.coupon.ActivityCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.coupon.ActivityCouponManager;
import com.ve.marketingcenter.core.manager.coupon.ReceivedCouponManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.ResponseUtil;
import com.ve.marketingcenter.core.util.TransUtil;

@Service
public class QueryActivityCoupon implements Action {
	@Resource
	ActivityCouponManager activityCouponManager;

	@Resource
	ReceivedCouponManager receivedCouponManager;

	/**
	 * 查询活动包含的营销活动券
	 * 
	 * @throws MarketingException
	 */
	@Override
	public MarketingResponse execute(RequestContext context)
			throws MarketingException {
		// 获取参数
		ActivityCouponQTO activityCouponQTO = (ActivityCouponQTO) context
				.getRequest().getParam("activityCouponQTO");
		if (activityCouponQTO == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"activityCouponQTO is null");
		}
		if (activityCouponQTO.getActivityId() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"activityId is null");
		}
		if (activityCouponQTO.getStatus() != null) {
			// 1未发放 2已发放
			if (activityCouponQTO.getStatus() != 1
					&& activityCouponQTO.getStatus() != 2) {
				throw new MarketingException(
						ReturnCodeEnum.PARAMETER_ERROR.getCode(),
						"status not in (1,2) error");
			}
		}
		// 根据条件查询符合条件的优惠券
		List<ActivityCoupon> activityCouponList = activityCouponManager
				.queryActivityCoupon(activityCouponQTO);
		// do转成dto返回
		List<ActivityCouponDTO> activityCouponDTOList = new ArrayList<ActivityCouponDTO>();
		for (ActivityCoupon activityCoupon : activityCouponList) {
			ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
			activityCouponDTO = (ActivityCouponDTO) TransUtil.trans2Dto(
					activityCouponDTO, activityCoupon);
			activityCouponDTOList.add(activityCouponDTO);
		}

		// 返回response对象
		return ResponseUtil.getResponse(activityCouponDTOList,
				activityCouponQTO.getTotalCount());
	}

	@Override
	public String getName() {
		return ActionEnum.QUERY_ACTIVITY_COUPON.getActionName();
	}
}
