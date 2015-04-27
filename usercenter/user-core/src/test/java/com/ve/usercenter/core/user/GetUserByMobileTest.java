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
public class GetUserByMobileTest {

	@Resource
	private UserService userService;

	/**
	 * 获取用户 测试结果：获取成功
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("mobile", "18668017860");
		request.setCommand(ActionEnum.GET_USER_BY_MOBILE.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 不存在的手机号获取用户 测试结果:user is not exist
	 */
	@Test
	public void test3() {
		Request request = new BaseRequest();
		request.setParam("mobile", "18666666666");
		request.setCommand(ActionEnum.GET_USER_BY_MOBILE.getActionName());
		Response response = userService.execute(request);
	}

}
