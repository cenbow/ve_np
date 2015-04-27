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
import com.ve.usercenter.common.dto.UserExtraInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddUserExtraInfoTest {
	@Resource
	private UserService userService;

	/**
	 * 正确添加用户的扩展信息 测试结果：
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();

		UserExtraInfoDTO userExtraDTO = new UserExtraInfoDTO();

		userExtraDTO.setUserId(30L);
		userExtraDTO.setAddress("杭州市文三路");
		userExtraDTO.setSex((byte) 0);

		request.setParam("userExtraDTO", userExtraDTO);
		request.setCommand(ActionEnum.ADD_USER_EXTRA_INFO.getActionName());

		Response response = userService.execute(request);
	}

	/**
	 * userExtraDTO为空 测试结果：userExtraDto is null
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();

		UserExtraInfoDTO userExtraDTO = null;

		request.setParam("userExtraDTO", userExtraDTO);
		request.setCommand(ActionEnum.ADD_USER_EXTRA_INFO.getActionName());

		Response response = userService.execute(request);
	}

	/**
	 * 已删除的用户测试结果：user is not exist
	 * */
	@Test
	public void test3() {
		Request request = new BaseRequest();

		UserExtraInfoDTO userExtraDTO = new UserExtraInfoDTO();

		userExtraDTO.setUserId(11L);
		userExtraDTO.setAddress("杭州市文三路");
		userExtraDTO.setSex((byte) 0);

		request.setParam("userExtraDTO", userExtraDTO);
		request.setCommand(ActionEnum.ADD_USER_EXTRA_INFO.getActionName());

		Response response = userService.execute(request);
	}

	/**
	 * 相同用户重复添加数据 测试结果： user information is already exist
	 */
	@Test
	public void test4() {
		Request request = new BaseRequest();

		UserExtraInfoDTO userExtraDTO = new UserExtraInfoDTO();

		userExtraDTO.setUserId(30L);
		userExtraDTO.setAddress("杭州市文三路");
		userExtraDTO.setSex((byte) 0);

		request.setParam("userExtraDTO", userExtraDTO);
		request.setCommand(ActionEnum.ADD_USER_EXTRA_INFO.getActionName());

		Response response = userService.execute(request);
	}
}
