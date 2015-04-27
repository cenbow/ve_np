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
import com.ve.usercenter.common.dto.UserInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ApiUserLoginTest {

	@Resource
	private UserService userService;

	/**
	 * 第三方用户登陆 测试结果：登陆成功
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		UserInfoDTO userInfoDto = new UserInfoDTO();
		userInfoDto.setOpenId("123454867534135");
		userInfoDto.setAuthType(1);
		userInfoDto.setName("我爱睡觉19");
		userInfoDto.setPassword("xxyyzz123");
		userInfoDto.setEmail("742001368@qq.com");
		request.setParam("userInfoDTO", userInfoDto);
		request.setCommand(ActionEnum.API_USER_LOGIN.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * userInfoDto 为空 测试结果：userInfoDto is null
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		UserInfoDTO userInfoDto = null;

		request.setParam("userInfoDTO", userInfoDto);
		request.setCommand(ActionEnum.API_USER_LOGIN.getActionName());
		Response response = userService.execute(request);
	}

}
