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
public class UpdatePwdTest {

	@Resource
	private UserService userService;

	/**
	 * 参数正确的情况下修改密码 测试结果：修改成功
	 * */
	@Test
	public void updatePwdTest() {
		Request request = new BaseRequest();
		request.setParam("userId", 14L);
		request.setParam("oldPwd", "zl123456");
		request.setParam("newPwd", "np5356822");
		request.setCommand(ActionEnum.UPDATE_PWD.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 用户名和密码不匹配的情况下修改密码 测试结果：old password is error
	 * */
	@Test
	public void updatePwdTest1() {
		Request request = new BaseRequest();
		request.setParam("userId", 14L);
		request.setParam("oldPwd", "zl123456");
		request.setParam("newPwd", "np5356822");
		request.setCommand(ActionEnum.UPDATE_PWD.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 新老密码相同的情况下修改密码 测试结果：new password and old password is same
	 * */
	@Test
	public void updatePwdTest2() {
		Request request = new BaseRequest();
		request.setParam("userId", 14L);
		request.setParam("oldPwd", "np5356822");
		request.setParam("newPwd", "np5356822");
		request.setCommand(ActionEnum.UPDATE_PWD.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 错误的密码格式下修改密码 测试结果：password format error
	 * */
	@Test
	public void updatePwdTest3() {
		Request request = new BaseRequest();
		request.setParam("userId", 14L);
		request.setParam("oldPwd", "np5356822");
		request.setParam("newPwd", "np5");
		request.setCommand(ActionEnum.UPDATE_PWD.getActionName());
		Response response = userService.execute(request);
	}
}
