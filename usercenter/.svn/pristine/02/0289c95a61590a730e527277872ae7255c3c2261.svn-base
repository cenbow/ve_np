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
public class DeleteUserGroupTest {
	@Resource
	private UserService userService;

	/**
	 * 正确的删除 测试结果：成功删除
	 * */
	@Test
	public void test1() {

		Request request = new BaseRequest();

		request.setParam("groupId", 15);
		request.setCommand(ActionEnum.DEL_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * groupId 为空 测试结果：groupId is null
	 * */
	@Test
	public void test2() {

		Request request = new BaseRequest();

		Long groupId = null;
		request.setParam("groupId", groupId);
		request.setCommand(ActionEnum.DEL_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * 删除非组等级最高的组 测试结果：delete error,not the largest group_no
	 */
	@Test
	public void test3() {

		Request request = new BaseRequest();

		request.setParam("groupId", 16);
		request.setCommand(ActionEnum.DEL_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

}
