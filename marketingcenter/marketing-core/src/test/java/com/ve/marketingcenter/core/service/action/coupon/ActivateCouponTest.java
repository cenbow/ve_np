package com.ve.marketingcenter.core.service.action.coupon;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;

public class ActivateCouponTest extends BaseTest {

	@Resource
	private MarketingService marketingService;

	/**
	 * 测试成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Long userId = 1l;
		String couponCode = "abc";
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
	}

	/**
	 * 测试优惠券代码为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Long userId = 1l;
		String couponCode = null;
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
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
	public void test3() throws Exception {
		Long userId = null;
		String couponCode = "abc";
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试优惠券代码不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Long userId = 1l;
		String couponCode = "abcd";
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
		Assert.assertEquals(ReturnCodeEnum.COUPON_CODE_NOT_EXIST.getCode(),
				response.getResCode());
	}

	/**
	 * 测试优惠券代码已被激活分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Long userId = 1l;
		String couponCode = "bcd";
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
		Assert.assertEquals(ReturnCodeEnum.COUPON_CODE_ACTIVATED.getCode(),
				response.getResCode());
	}

	/**
	 * 测试更新优惠券发放数量出错分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		Long userId = 1l;
		String couponCode = "abc";
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
		Assert.assertEquals(ReturnCodeEnum.UPDATE_ERROR.getCode(),
				response.getResCode());
	}

	/**
	 * 测试优惠券对应的活动不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		Long userId = 1l;
		String couponCode = "abc";
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ACTIVATE_COUPON.getActionName());
		request.setParam("userId", userId);
		request.setParam("couponCode", couponCode);
		// 执行分发执行对应Action
		Response response = marketingService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}
}
