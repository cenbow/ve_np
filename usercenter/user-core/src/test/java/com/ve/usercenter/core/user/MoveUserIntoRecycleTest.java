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
public class MoveUserIntoRecycleTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的将用户移入回收站 测试结果：回收正确
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 6L);
		request.setCommand(ActionEnum.MOVE_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 重复移入回收站 测试结果：
	 */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 6L);
		request.setCommand(ActionEnum.MOVE_USER.getActionName());
		Response response = userService.execute(request);
	}
}
