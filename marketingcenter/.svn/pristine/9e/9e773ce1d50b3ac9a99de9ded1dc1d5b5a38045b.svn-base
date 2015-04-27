package com.ve.marketingcenter.core.service.action.coupon;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.domain.dto.coupon.OrderActivityDTO;

public class CancelOrderActivityTest extends BaseTest {

	@Resource
	private MarketingService marketingService;

	/**
	 * 测试成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CANCEL_ORDER_ACTIVITY.getActionName());
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
	public void test2() throws Exception {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CANCEL_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", null);
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
	public void test3() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		// orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CANCEL_ORDER_ACTIVITY.getActionName());
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
	public void test4() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		orderActivityDTO.setOrderId(1l);
		// orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CANCEL_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试没有和订单关联的活动分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		// 创建一个DTO并赋值
		OrderActivityDTO orderActivityDTO = new OrderActivityDTO();
		orderActivityDTO.setOrderId(1l);
		orderActivityDTO.setUserId(1l);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CANCEL_ORDER_ACTIVITY.getActionName());
		request.setParam("orderActivityDTO", orderActivityDTO);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}
}
