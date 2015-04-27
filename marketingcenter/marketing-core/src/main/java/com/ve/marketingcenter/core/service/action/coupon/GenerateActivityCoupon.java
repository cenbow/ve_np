package com.ve.marketingcenter.core.service.action.coupon;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponConstant;
import com.ve.marketingcenter.common.constant.coupon.CouponTypeStatus;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;
import com.ve.marketingcenter.core.domain.ActivityDO;
import com.ve.marketingcenter.core.domain.coupon.ActivityCoupon;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.coupon.ActivityCouponManager;
import com.ve.marketingcenter.core.service.RequestContext;
import com.ve.marketingcenter.core.service.action.Action;
import com.ve.marketingcenter.core.util.CouponCodeUtil;
import com.ve.marketingcenter.core.util.ResponseUtil;

@Service
public class GenerateActivityCoupon implements Action {
	@Resource
	ActivityCouponManager activityCouponManager;

	/**
	 * 生成营销活动优惠券
	 */
	@Override
	public MarketingResponse execute(RequestContext context)
			throws MarketingException {
		// 获取参数
		ActivityCouponDTO activityCouponDTO = (ActivityCouponDTO) context
				.getRequest().getParam("activityCouponDTO");
		if (activityCouponDTO == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"activityCouponDTO is null");
		}
		if (activityCouponDTO.getActivityId() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"activityId is null");
		}
		if (activityCouponDTO.getTotalCount() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"totalCount is null");
		}
		if (activityCouponDTO.getTotalCount() > CouponConstant.MAX_COUPON_COUNT) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"coupon totalCount over max 10000000");
		}
		if (activityCouponDTO.getCouponType() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"couponType is null");
		}
		if (activityCouponDTO.getScope() == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"scope is null");
		}
		ActivityDO activityDO = activityCouponManager
				.getActivity(activityCouponDTO.getActivityId());
		if (activityDO == null) {
			throw new MarketingException(ReturnCodeEnum.PARAMETER_NULL.getCode(),
					"activityId:" + activityCouponDTO.getActivityId()
							+ " not exist");
		}
		// 优惠券类型有码情况
		if (activityCouponDTO.getCouponType().intValue() == CouponTypeStatus.CODE
				.getValue().intValue()) {
			// 循环数量批量生成优惠券
			List<ActivityCoupon> activityCouponList = new ArrayList<ActivityCoupon>();
			for (long couponIndex = 0; couponIndex < activityCouponDTO
					.getTotalCount(); couponIndex++) {
				// 根据DTO生成DO
				ActivityCoupon activityCoupon = buildActivityCoupon(
						activityCouponDTO, activityDO);
				activityCoupon.setCouponCode(CouponCodeUtil
						.generateCouponCode());
				// 有码的总数量初始为1
				activityCoupon.setTotalCount(1l);
				activityCouponList.add(activityCoupon);
				// 列表达到增量时新增一次
				if (activityCouponList.size() % CouponConstant.INCREASE_COUNT == 0) {
					activityCouponManager
							.batchAddActivityCoupon(activityCouponList);
					activityCouponList.clear();
				}
			}
			// 剩余的在新增一次
			if (activityCouponList.size() > 0) {
				activityCouponManager
						.batchAddActivityCoupon(activityCouponList);
			}

		}
		// // 优惠券类型无码情况
		else if (activityCouponDTO.getCouponType().intValue() == CouponTypeStatus.NO_CODE
				.getValue().intValue()) {
			// 根据DTO生成DO
			ActivityCoupon activityCoupon = buildActivityCoupon(
					activityCouponDTO, activityDO);
			activityCoupon.setTotalCount(activityCouponDTO.getTotalCount());
			activityCouponManager.addActivityCoupon(activityCoupon);
		}
		// 返回response对象
		return ResponseUtil.getResponse(true);
	}

	private ActivityCoupon buildActivityCoupon(
			ActivityCouponDTO activityCouponDTO, ActivityDO activityDO) {
		// 根据DTO生成DO
		ActivityCoupon activityCoupon = new ActivityCoupon();
		activityCoupon.setActivityId(activityCouponDTO.getActivityId());
		activityCoupon.setGrantedCount(0l);
		activityCoupon.setScope(activityCouponDTO.getScope());
		activityCoupon.setStatus(0);// 新生成未推送
		activityCoupon.setSuppliedUserId(activityDO.getCreatorUserId());
		return activityCoupon;
	}

	@Override
	public String getName() {
		return ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName();
	}
}
