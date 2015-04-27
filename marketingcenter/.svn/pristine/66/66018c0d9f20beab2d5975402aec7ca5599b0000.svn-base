package com.ve.marketingcenter.core.service.action.coupon;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponGrantStatus;
import com.ve.marketingcenter.common.domain.qto.coupon.ActivityCouponQTO;

public class QueryActivityCouponTest extends BaseTest {

	@Resource
	private MarketingService marketingService;

	/**
	 * 测试查询活动下已发放完优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		// 创建一个QTO并赋值
		ActivityCouponQTO activityCouponQTO = new ActivityCouponQTO();
		activityCouponQTO.setPageNo(1);
		activityCouponQTO.setPageSize(50);
		activityCouponQTO.setActivityId(2l);
		activityCouponQTO.setStatus(CouponGrantStatus.GRANTED.getValue());
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponQTO", activityCouponQTO);
		// 执行分发执行对应Action
		Response<List<ActivityCouponQTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Assert.assertTrue(response.getModule().size() > 0);
	}

	/**
	 * 测试查询活动下未发放完优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		// 创建一个QTO并赋值
		ActivityCouponQTO activityCouponQTO = new ActivityCouponQTO();
		activityCouponQTO.setPageNo(1);
		activityCouponQTO.setPageSize(50);
		activityCouponQTO.setActivityId(2l);
		activityCouponQTO.setStatus(CouponGrantStatus.UN_GRANTED.getValue());
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponQTO", activityCouponQTO);
		// 执行分发执行对应Action
		Response<List<ActivityCouponQTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Assert.assertTrue(response.getModule().size() > 0);
	}

	/**
	 * 测试查询活动下所有优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		// 创建一个QTO并赋值
		ActivityCouponQTO activityCouponQTO = new ActivityCouponQTO();
		activityCouponQTO.setPageNo(1);
		activityCouponQTO.setPageSize(50);
		activityCouponQTO.setActivityId(2l);
		// activityCouponQTO.setStatus(CouponGrantStatus.GRANTED.getValue());
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponQTO", activityCouponQTO);
		// 执行分发执行对应Action
		Response<List<ActivityCouponQTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Assert.assertTrue(response.getModule().size() > 0);
	}

	/**
	 * 测试参数为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		// 创建一个QTO并赋值
		ActivityCouponQTO activityCouponQTO = new ActivityCouponQTO();
		activityCouponQTO.setPageNo(1);
		activityCouponQTO.setPageSize(50);
		activityCouponQTO.setActivityId(2l);
		activityCouponQTO.setStatus(CouponGrantStatus.GRANTED.getValue());
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponQTO", null);
		// 执行分发执行对应Action
		Response<List<ActivityCouponQTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试活动ID为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		// 创建一个QTO并赋值
		ActivityCouponQTO activityCouponQTO = new ActivityCouponQTO();
		activityCouponQTO.setPageNo(1);
		activityCouponQTO.setPageSize(50);
		// activityCouponQTO.setActivityId(2l);
		activityCouponQTO.setStatus(CouponGrantStatus.GRANTED.getValue());
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponQTO", activityCouponQTO);
		// 执行分发执行对应Action
		Response<List<ActivityCouponQTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试发放状态不合法分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		// 创建一个QTO并赋值
		ActivityCouponQTO activityCouponQTO = new ActivityCouponQTO();
		activityCouponQTO.setPageNo(1);
		activityCouponQTO.setPageSize(50);
		activityCouponQTO.setActivityId(2l);
		activityCouponQTO.setStatus(3);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponQTO", activityCouponQTO);
		// 执行分发执行对应Action
		Response<List<ActivityCouponQTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}
}
