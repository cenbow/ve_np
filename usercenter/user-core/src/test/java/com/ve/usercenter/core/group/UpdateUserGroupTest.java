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
import com.ve.usercenter.common.dto.UserGroupDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UpdateUserGroupTest {
	@Resource
	private UserService userService;

	/**
	 * 正确的修改用户组 测试结果：添加成功
	 * */
	@Test
	public void test1() {

		Request request = new BaseRequest();

		UserGroupDTO userGroupDTO = new UserGroupDTO();
		userGroupDTO.setId(16);
		userGroupDTO.setDiscount(85);
		userGroupDTO.setGroupNo(1);
		userGroupDTO.setMaxIntegral(300L);
		request.setParam("userGroupDTO", userGroupDTO);
		request.setCommand(ActionEnum.UPDATE_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * userGroupDTO为空修改用户组 测试结果： userGroupDto is null
	 * */
	@Test
	public void test2() {

		Request request = new BaseRequest();

		UserGroupDTO userGroupDTO = null;
		request.setParam("userGroupDTO", userGroupDTO);
		request.setCommand(ActionEnum.UPDATE_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * 修改的组的最大积分值大于上一等级的最大积分值 测试结果：maxIntegral greater than upGroup maxIntegral
	 * */

	@Test
	public void test3() {

		Request request = new BaseRequest();

		UserGroupDTO userGroupDTO = new UserGroupDTO();
		userGroupDTO.setId(16);
		userGroupDTO.setDiscount(85);
		userGroupDTO.setGroupNo(1);
		userGroupDTO.setMaxIntegral(3000L);
		request.setParam("userGroupDTO", userGroupDTO);
		request.setCommand(ActionEnum.UPDATE_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * 修改的最大积分，大于允许的最大积分 测试结果：maxIntegral can't greater than MAX_INTEGRAL
	 * */
	@Test
	public void test4() {

		Request request = new BaseRequest();

		UserGroupDTO userGroupDTO = new UserGroupDTO();
		userGroupDTO.setId(17);
		userGroupDTO.setDiscount(85);
		userGroupDTO.setMaxIntegral(30000000000L);
		request.setParam("userGroupDTO", userGroupDTO);
		request.setCommand(ActionEnum.UPDATE_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * 折扣值大于允许的最大的折扣 测试结果：discount can't less than 0
	 * */
	@Test
	public void test5() {

		Request request = new BaseRequest();

		UserGroupDTO userGroupDTO = new UserGroupDTO();
		userGroupDTO.setId(16);
		userGroupDTO.setDiscount(-1);
		userGroupDTO.setGroupNo(1);
		userGroupDTO.setMaxIntegral(300L);
		request.setParam("userGroupDTO", userGroupDTO);
		request.setCommand(ActionEnum.UPDATE_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

	/**
	 * 折扣值小于允许的最小的折扣 测试结果： discount can't greater than 100
	 * */
	@Test
	public void test6() {

		Request request = new BaseRequest();

		UserGroupDTO userGroupDTO = new UserGroupDTO();
		userGroupDTO.setId(16);
		userGroupDTO.setDiscount(101);
		userGroupDTO.setGroupNo(1);
		userGroupDTO.setMaxIntegral(300L);
		request.setParam("userGroupDTO", userGroupDTO);
		request.setCommand(ActionEnum.UPDATE_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}
}
