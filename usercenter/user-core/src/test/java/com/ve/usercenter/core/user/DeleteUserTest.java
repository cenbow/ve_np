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
public class DeleteUserTest {

	@Resource
	private UserService userService;

	/**
	 * 正常情况下删除用户(只有在回收站里的用户才能被删除) 测试结果：删除成功
	 */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 13L);
		request.setCommand(ActionEnum.DELETE_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 删除不在回收站里的用户 测试结果：user not in recycle
	 */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 15L);
		request.setCommand(ActionEnum.DELETE_USER.getActionName());
		Response response = userService.execute(request);
	}

}
