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
public class ActiveUserTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的激活用户 测试结果:正常激活
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();

		request.setParam("userId", 6L);
		request.setCommand(ActionEnum.ACTIVE_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 对处于激活状态的用户激活 测试结果:user is activity
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();

		request.setParam("userId", 6L);
		request.setCommand(ActionEnum.ACTIVE_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 对不存在的用户激活 测试结果：user not exist
	 */
	@Test
	public void test3() {
		Request request = new BaseRequest();

		request.setParam("userId", 100L);
		request.setCommand(ActionEnum.ACTIVE_USER.getActionName());
		Response response = userService.execute(request);
	}
}
