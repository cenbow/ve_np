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
public class RestoreUserTest {

	@Resource
	private UserService userService;

	/**
	 * 将回收站的里用户正确还原 测试结果：
	 */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 6L);
		request.setCommand(ActionEnum.RESTORE_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 将不在回收站里的用户还原 测试结果：user not in recycle
	 */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 12L);
		request.setCommand(ActionEnum.RESTORE_USER.getActionName());
		Response response = userService.execute(request);
	}

}
