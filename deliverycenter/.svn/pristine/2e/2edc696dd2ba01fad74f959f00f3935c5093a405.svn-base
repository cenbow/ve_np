package com.ve.deliverycenter.core.service.action.storage;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ve.deliverycenter.common.api.BaseRequest;
import com.ve.deliverycenter.common.api.DeliveryService;
import com.ve.deliverycenter.common.api.Request;
import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.core.service.BaseTest;

public class DeleteStorageSendTest extends BaseTest {

	@Resource
	private DeliveryService deliveryService;

	/**
	 * 测试删除成功分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		int id = 1;
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_STORAGE_SEND.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		Response response = deliveryService.execute(request);
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
		request.setCommand(ActionEnum.DELETE_STORAGE_SEND.getActionName());
		request.setParam("id", null);
		// 执行分发执行对应Action
		Response response = deliveryService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}

	/**
	 * 测试ID不存在分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		int id = 9;
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_STORAGE_SEND.getActionName());
		request.setParam("id", id);
		// 执行分发执行对应Action
		Response response = deliveryService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}
}
