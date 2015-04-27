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
public class UpdateEmailTest {

	@Resource
	private UserService userService;

	/**
	 * 参数正确的情况下修改邮箱 测试结果：修改成功
	 * */
	@Test
	public void updateEmailTest() {

		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setParam("email", "742001948@qq.com");
		request.setCommand(ActionEnum.UPDATE_EMAIL.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 邮箱格式错误的情况下修改邮箱 测试结果：email format error
	 */
	@Test
	public void updateEmailTest2() {

		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setParam("email", "742001938qq.com");
		request.setCommand(ActionEnum.UPDATE_EMAIL.getActionName());
		Response response = userService.execute(request);
	}
}
