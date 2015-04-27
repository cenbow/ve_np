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
public class GetConsigneeByIdTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的获取收货地址 测试结果:正常获取
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 12L);
		request.setParam("consigneeId", 12L);
		request.setCommand(ActionEnum.GET_CONSIGNEE_BY_ID.getActionName());
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
		request.setCommand(ActionEnum.GET_CONSIGNEE_BY_ID.getActionName());
		Response response = userService.execute(request);
	}
}
