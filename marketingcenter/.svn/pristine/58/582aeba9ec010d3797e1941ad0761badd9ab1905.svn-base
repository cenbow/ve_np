package com.ve.marketingcenter.core.service.action.coupon;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.coupon.CouponTypeStatus;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;

public class GenerateActivityCouponTest extends BaseTest {

	@Resource
	private MarketingService marketingService;

	/**
	 * 测试1000条成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Long startTime = System.currentTimeMillis();
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(1000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Long endTime = System.currentTimeMillis();
		System.out.println("totalTime:" + (endTime - startTime));// totalTime:2621
	}

	/**
	 * 测试5000条成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Long startTime = System.currentTimeMillis();
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(5000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Long endTime = System.currentTimeMillis();
		System.out.println("totalTime:" + (endTime - startTime));// 每1000totalTime:8196
																	// 每5000totalTime:7625
	}

	/**
	 * 测试1万条成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Long startTime = System.currentTimeMillis();
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(10000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Long endTime = System.currentTimeMillis();
		System.out.println("totalTime:" + (endTime - startTime));// 每5000totalTime:14062
																	// 每1000totalTime:12322
																	// 去事物totalTime:13183
	}

	/**
	 * 测试5万条成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Long startTime = System.currentTimeMillis();
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(50000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Long endTime = System.currentTimeMillis();
		System.out.println("totalTime:" + (endTime - startTime));// 每5000totalTime:62642
																	// 每1000totalTime:50119
	}

	/**
	 * 测试10万条成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Long startTime = System.currentTimeMillis();
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(100000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Long endTime = System.currentTimeMillis();
		System.out.println("totalTime:" + (endTime - startTime));// 每5000totalTime:123522
																	// 每1000totalTime:96439
	}

	/**
	 * 测试50万条成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		Long startTime = System.currentTimeMillis();
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(500000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Long endTime = System.currentTimeMillis();
		System.out.println("totalTime:" + (endTime - startTime));// 每1000totalTime:551187
	}

	/**
	 * 测试参数为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", null);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试活动ID为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test8() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		// activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(500000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试优惠券类型为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test9() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		// activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(500000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试使用范围为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test10() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		// activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(500000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试总数为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test11() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		// activityCouponDTO.setTotalCount(500000l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试总数超过最大值分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test12() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(10000001l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试活动ID不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test13() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(1l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试有码成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test14() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}

	/**
	 * 测试无码成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test15() throws Exception {
		// 创建一个DTO并赋值
		ActivityCouponDTO activityCouponDTO = new ActivityCouponDTO();
		activityCouponDTO.setActivityId(2l);
		activityCouponDTO.setCouponType(CouponTypeStatus.NO_CODE.getValue());
		activityCouponDTO.setScope(2);
		activityCouponDTO.setTotalCount(3l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GENERATE_ACTIVITY_COUPON.getActionName());
		request.setParam("activityCouponDTO", activityCouponDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}
}
