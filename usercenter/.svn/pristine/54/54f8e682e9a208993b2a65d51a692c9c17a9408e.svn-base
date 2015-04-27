package com.ve.usercenter.core.userAuth;

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
public class RefuseUserIdenTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的用户实名认证通过 测试结果:认证正确
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 30L);
		request.setParam("remark", "sb一律不通过");
		request.setCommand(ActionEnum.FILEIDENTIFIED_USER_AUTH_INFO
				.getActionName());
		Response response = userService.execute(request);
	}

}
