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
public class QueryGroupTest {
	@Resource
	private UserService userService;

	/**
	 * 正确获取用户组列表 测试结果：成功获取
	 * */
	@Test
	public void test1() {

		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_GROUP.getActionName());

		Response response = userService.execute(request);

	}

}
