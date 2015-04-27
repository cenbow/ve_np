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
import com.ve.marketingcenter.common.domain.dto.coupon.ReceivedCouponDTO;
import com.ve.marketingcenter.common.domain.qto.coupon.ReceivedCouponQTO;

public class QueryUserCouponTest extends BaseTest {

	@Resource
	private MarketingService marketingService;

	/**
	 * 测试查询未使用优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(1);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Assert.assertTrue(response.getModule().size() > 0);
	}

	/**
	 * 测试查询已使用优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(2);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Assert.assertTrue(response.getModule().size() > 0);
	}

	/**
	 * 测试查询已过期优惠券分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(3);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
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
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(3);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", null);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试用户ID为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		// receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(3);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试优惠券使用状态为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		// receivedCouponQTO.setStatus(3);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试优惠券使用状态不合法分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(5);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试查询的优惠券对应的活动不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test8() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(2);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试查询的优惠券ID不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test9() throws Exception {
		// 创建一个QTO并赋值
		ReceivedCouponQTO receivedCouponQTO = new ReceivedCouponQTO();
		receivedCouponQTO.setPageNo(1);
		receivedCouponQTO.setPageSize(50);
		receivedCouponQTO.setUserId(1l);
		receivedCouponQTO.setStatus(2);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_COUPON.getActionName());
		request.setParam("receivedCouponQTO", receivedCouponQTO);
		// 执行分发执行对应Action
		Response<List<ReceivedCouponDTO>> response = marketingService
				.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}
}
