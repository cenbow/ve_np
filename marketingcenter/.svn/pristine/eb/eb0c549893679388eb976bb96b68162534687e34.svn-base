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
import com.ve.marketingcenter.common.domain.dto.coupon.OrderActivityDTO;

public class RelateOrderActivityTest extends BaseTest {

	@Resource
	private MarketingService marketingService;

	/**
	 * 测试活动没有优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		List<Long> activityIdList = new ArrayList();
		// activityIdList.add(1l);
		activityIdList.add(2l);
		orderActivityDTO.setActivityIdList(activityIdList);
		List<Long> couponIdList = new ArrayList();
		couponIdList.add(1l);
		couponIdList.add(2l);
		// orderActivityDTO.setCouponIdList(couponIdList);
		orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}

	/**
	 * 测试有优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		List<Long> activityIdList = new ArrayList();
		// activityIdList.add(1l);
		activityIdList.add(2l);
		orderActivityDTO.setActivityIdList(activityIdList);
		List<Long> couponIdList = new ArrayList();
		couponIdList.add(1l);
		// couponIdList.add(2l);
		orderActivityDTO.setCouponIdList(couponIdList);
		orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}

	/**
	 * 测试参数为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", null);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试活动为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		List<Long> activityIdList = new ArrayList();
		activityIdList.add(1l);
		activityIdList.add(2l);
		// orderActivityDTO.setActivityIdList(activityIdList);
		List<Long> couponIdList = new ArrayList();
		couponIdList.add(1l);
		couponIdList.add(2l);
		orderActivityDTO.setCouponIdList(couponIdList);
		orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试订单为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		List<Long> activityIdList = new ArrayList();
		activityIdList.add(1l);
		activityIdList.add(2l);
		// orderActivityDTO.setActivityIdList(activityIdList);
		List<Long> couponIdList = new ArrayList();
		couponIdList.add(1l);
		couponIdList.add(2l);
		orderActivityDTO.setCouponIdList(couponIdList);
		// orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
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
	public void test6() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		List<Long> activityIdList = new ArrayList();
		activityIdList.add(1l);
		activityIdList.add(2l);
		// orderActivityDTO.setActivityIdList(activityIdList);
		List<Long> couponIdList = new ArrayList();
		couponIdList.add(1l);
		couponIdList.add(2l);
		orderActivityDTO.setCouponIdList(couponIdList);
		orderActivityDTO.setOrderId(1l);
		// orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试优惠券不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		List<Long> activityIdList = new ArrayList();
		activityIdList.add(1l);
		activityIdList.add(2l);
		orderActivityDTO.setActivityIdList(activityIdList);
		List<Long> couponIdList = new ArrayList();
		couponIdList.add(4l);
		couponIdList.add(5l);
		orderActivityDTO.setCouponIdList(couponIdList);
		orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
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
	public void test8() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		List<Long> activityIdList = new ArrayList();
		activityIdList.add(1l);
		activityIdList.add(2l);
		orderActivityDTO.setActivityIdList(activityIdList);
		List<Long> couponIdList = new ArrayList();
		couponIdList.add(1l);
		couponIdList.add(2l);
		orderActivityDTO.setCouponIdList(couponIdList);
		orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.RELATE_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

}
