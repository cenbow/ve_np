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
import com.ve.usercenter.common.qto.UserQTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class QueryUserTest {

	@Resource
	private UserService userService;

	/**
	 * 获取用户 测试结果：获取成功
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		UserQTO userQto = new UserQTO();
		userQto.setName("我爱睡觉");
		request.setParam("userQTO", userQto);
		request.setCommand(ActionEnum.QUERY_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * userQto 为空获取用户 测试结果：userQto is null
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		UserQTO userQto = null;
		request.setParam("userQTO", userQto);
		request.setCommand(ActionEnum.QUERY_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 查询的页数大于最大一页，这默认进入最后一页
	 * */
	@Test
	public void test3() {
		Request request = new BaseRequest();
		UserQTO userQto = new UserQTO();
		userQto.setName("我爱睡觉");
		userQto.setEmail("1dddd@qq.com");
		userQto.setPageNum(100L);
		request.setParam("userQTO", userQto);
		request.setCommand(ActionEnum.QUERY_USER.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 手机格式错误查询
	 */
	@Test
	public void test4() {
		Request request = new BaseRequest();
		UserQTO userQto = new UserQTO();
		userQto.setName("我爱睡觉");

		userQto.setEmail("1dddd@qq.com");
		request.setParam("userQTO", userQto);
		request.setCommand(ActionEnum.QUERY_USER.getActionName());
		Response response = userService.execute(request);
	}

}
