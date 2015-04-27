package com.ve.usercenter.core.user;

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
public class GetUserByIdTest {

	@Resource
	private UserService userService;

	/**
	 * 获取用户 测试结果：获取成功
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setCommand(ActionEnum.GET_USER_BY_ID.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 获取不存在的用户 测试结果：user is not exist
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 1000L);
		request.setCommand(ActionEnum.GET_USER_BY_ID.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 用户id格式错误 测试结果：userId must greater than 0
	 * */
	@Test
	public void test3() {
		Request request = new BaseRequest();
		request.setParam("userId", -1L);
		request.setCommand(ActionEnum.GET_USER_BY_ID.getActionName());
		Response response = userService.execute(request);
	}
}
