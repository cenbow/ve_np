package com.ve.usercenter.core.group;

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
public class GetUserGroupByUserIdTest {
	@Resource
	private UserService userService;

	/**
	 * 正确的获取指定用户所属的用户组 测试结果：成功获取
	 * */
	@Test
	public void test1() {

		Request request = new BaseRequest();
		request.setParam("userId", 10L);
		request.setCommand(ActionEnum.GET_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * 用户id不存在 测试结果： user is not exist
	 * */
	@Test
	public void test2() {

		Request request = new BaseRequest();
		request.setParam("userId", 199L);
		request.setCommand(ActionEnum.GET_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}
}
