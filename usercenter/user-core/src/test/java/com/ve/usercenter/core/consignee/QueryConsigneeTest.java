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
public class QueryConsigneeTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的查询指定用户的收货地址 测试结果：正确
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 12L);
		request.setCommand(ActionEnum.QUERY_CONSIGNEE.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 查询不存在的用户的收货地址 测试结果：user is not exist
	 */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 100L);
		request.setCommand(ActionEnum.QUERY_CONSIGNEE.getActionName());
		Response response = userService.execute(request);
	}
}
