package com.ve.usercenter.core.consignee;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.BaseRequest;
import com.ve.usercenter.common.api.Request;
import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.api.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DeleteConsigneeTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的删除指定的 测试结果:正常删除
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 12L);
		request.setParam("consigneeId", 12L);
		request.setCommand(ActionEnum.DELETE_CONSIGNEE.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 收货地址id为空 测试结果： consigneeId is null
	 * */
	@Test
	public void test3() {
		Long consigneeId = null;
		Request request = new BaseRequest();
		request.setParam("consigneeId", consigneeId);
		request.setCommand(ActionEnum.DELETE_CONSIGNEE.getActionName());
		Response response = userService.execute(request);
	}
}
