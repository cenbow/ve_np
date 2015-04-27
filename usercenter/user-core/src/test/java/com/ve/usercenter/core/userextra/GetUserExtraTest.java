package com.ve.usercenter.core.userextra;

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
public class GetUserExtraTest {

	@Resource
	private UserService userService;

	/**
	 * 正确获取买家的扩展信息 测试结果：获取获取
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setCommand(ActionEnum.GET_USER_EXTRA_INFO.getActionName());

		Response response = userService.execute(request);
	}

	/**
	 * 指定的用户不存在 测试结果：user is not exist
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		request.setParam("userId", 100L);
		request.setCommand(ActionEnum.GET_SUPPLIER_EXTRA_INFO.getActionName());

		Response response = userService.execute(request);
	}
}
