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
public class SetUserRole {

	@Resource
	private UserService userService;

	/**
	 * 正常修改用户的角色 测试结果：修改正常
	 */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setParam("role", (byte) 1);
		request.setCommand(ActionEnum.SET_ROLE.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 用户角色错误 测试结果： role value is error
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setParam("role", (byte) 10);
		request.setCommand(ActionEnum.SET_ROLE.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 用户不存在 测试结果：user is not exist
	 * */
	@Test
	public void test3() {
		Request request = new BaseRequest();
		request.setParam("userId", 100L);
		request.setParam("role", (byte) 0);
		request.setCommand(ActionEnum.SET_ROLE.getActionName());
		Response response = userService.execute(request);
	}
}
