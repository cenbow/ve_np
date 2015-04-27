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
import com.ve.usercenter.common.dto.UserExtraInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserExtraInfoTest {
	@Resource
	private UserService userService;

	@Test
	public void test() {
		Request request = new BaseRequest();

		UserExtraInfoDTO userExtraDTO = new UserExtraInfoDTO();

		userExtraDTO.setUserId(30L);
		userExtraDTO.setAlipayId("1f2sd1");
		request.setParam("userExtraDTO", userExtraDTO);
		request.setCommand(ActionEnum.ADD_USER_EXTRA_INFO.getActionName());

		Response response = userService.execute(request);
	}
}
