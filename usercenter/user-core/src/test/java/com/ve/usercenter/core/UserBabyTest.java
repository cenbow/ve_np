package com.ve.usercenter.core;

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
import com.ve.usercenter.common.dto.UserBabyInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserBabyTest {
	@Resource
	private UserService userService;

	@Test
	public void test() {

		Request request = new BaseRequest();
		UserBabyInfoDTO userBabyInfoDto = new UserBabyInfoDTO();
		// 添加测试
		/*
		 * userBabyInfoDto.setUserId(12L); userBabyInfoDto.setIsDefault((byte)
		 * 1); userBabyInfoDto.setBabyName("小飞机");
		 * 
		 * request.setParam("userBabyDTO", userBabyInfoDto);
		 * request.setCommand(ActionEnum.ADD_USER_BABY_INFO.getActionName());
		 */
		// 删除测试

		/*
		 * request.setParam("userId", 12L); request.setParam("babyId", 2L);
		 * request.setCommand(ActionEnum.DELETE_USER_BABY_INFO.getActionName());
		 */

		// 修改测试测试
		userBabyInfoDto.setUserId(12L);
		userBabyInfoDto.setId(2L);

		request.setParam("userBabyDTO", userBabyInfoDto);
		request.setCommand(ActionEnum.UPDATE_USER_BABY_INFO.getActionName());

		/**
		 * 查询用户宝贝信息
		 * */
		/*
		 * request.setParam("userId", 12L);
		 * request.setCommand(ActionEnum.GET_USER_BABYS.getActionName());
		 */
		Response response = userService.execute(request);

	}

	@Test
	public void addtest() {

		Request request = new BaseRequest();
		UserBabyInfoDTO userBabyInfoDto = new UserBabyInfoDTO();

		userBabyInfoDto.setUserId(100L);
		userBabyInfoDto.setBabyName("小飞机飞不停");

		request.setParam("userBabyDTO", userBabyInfoDto);
		request.setCommand(ActionEnum.ADD_USER_BABY_INFO.getActionName());
		Response response = userService.execute(request);
	}

	@Test
	public void updatetest() {

		Request request = new BaseRequest();
		UserBabyInfoDTO userBabyInfoDto = new UserBabyInfoDTO();
		userBabyInfoDto.setUserId(12L);
		userBabyInfoDto.setId(2L);
		userBabyInfoDto.setBabyName("大飞机飞啊飞");

		request.setParam("userBabyDTO", userBabyInfoDto);
		request.setCommand(ActionEnum.UPDATE_USER_BABY_INFO.getActionName());
		Response response = userService.execute(request);
	}

	@Test
	public void deltest() {

		Request request = new BaseRequest();
		request.setParam("userId", 12L);
		request.setParam("babyId", 3L);
		request.setCommand(ActionEnum.DELETE_USER_BABY_INFO.getActionName());
		Response response = userService.execute(request);

	}

	@Test
	public void gettest() {

		Request request = new BaseRequest();
		request.setParam("userId", 12L);
		request.setCommand(ActionEnum.QUERY_USER_BABYS.getActionName());
		Response response = userService.execute(request);
	}
}
