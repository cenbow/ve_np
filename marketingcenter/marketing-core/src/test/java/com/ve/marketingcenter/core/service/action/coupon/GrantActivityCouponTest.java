package com.ve.marketingcenter.core.service.action.coupon;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;

public class GrantActivityCouponTest extends BaseTest {

	@Resource
	private MarketingService marketingService;

	/**
	 * 测试发放有码优惠券只取一次分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Long activityId = 2l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}

	/**
	 * 测试发放有码优惠券多次分页获取分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Long activityId = 2l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		userIdList.add(2l);
		userIdList.add(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}

	/**
	 * 测试发放无码优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Long activityId = 3l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		userIdList.add(2l);
		userIdList.add(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}

	/**
	 * 测试活动为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Long activityId = 3l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		userIdList.add(2l);
		userIdList.add(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", null);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试用户为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Long activityId = 3l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		userIdList.add(2l);
		userIdList.add(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", null);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试活动不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		Long activityId = 36l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		userIdList.add(2l);
		userIdList.add(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试活动过期分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		Long activityId = 4l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		userIdList.add(2l);
		userIdList.add(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试优惠券数量不足分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test8() throws Exception {
		Long activityId = 3l;
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(1l);
		userIdList.add(2l);
		userIdList.add(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GRANT_ACTIVITY_COUPON.getActionName());
		request.setParam("activityId", activityId);
		request.setParam("userIdList", userIdList);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}
}
