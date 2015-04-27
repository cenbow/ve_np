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
public class RefuseSupplierExtraTest {

	@Resource
	private UserService userService;

	/**
	 * 忽略供应商的审核 测试结果：成功
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		request.setParam("userId", 19L);
		request.setCommand(ActionEnum.SUPPLIER_FAIL_IDENTIFIED_ACTION
				.getActionName());
		Response response = userService.execute(request);
	}
}
