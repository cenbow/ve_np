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
public class FreezeUserTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的冻结用户 测试结果:正常冻结
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 9L);
		request.setCommand(ActionEnum.FREEZE_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 对处于冻结状态的用户冻结 测试结果:user is freezed
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 7L);
		request.setCommand(ActionEnum.FREEZE_USER.getActionName());
		Response response = userService.execute(request);
	}
}
