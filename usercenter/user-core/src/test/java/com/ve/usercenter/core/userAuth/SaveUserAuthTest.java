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
import com.ve.usercenter.common.dto.UserAuthInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SaveUserAuthTest {

	@Resource
	private UserService userService;

	/**
	 * 正确的保存用户的认证信息 测试结果:正常保存
	 * */
	@Test
	public void test1() {
		Request request = new BaseRequest();
		UserAuthInfoDTO userAuthInfoDto = new UserAuthInfoDTO();
		userAuthInfoDto.setUserId(30L);
		userAuthInfoDto.setIdcardNo("362324199110235719");
		userAuthInfoDto.setRealName("大神");
		userAuthInfoDto
				.setIdcardFrontImg("http://society.huanqiu.com/photonew/2015-01/2760449.html");
		userAuthInfoDto
				.setIdcardReverseImg("http://g.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=f450e5c46e224f4a57cc20536fcaa460/ac4bd11373f082021c0402dd48fbfbedaa641bb9.jpg");
		request.setParam("userAuthDTO", userAuthInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * userAuthDTO为空 测试结果:authInfoDto is null
	 * */
	@Test
	public void test2() {
		Request request = new BaseRequest();
		UserAuthInfoDTO userAuthInfoDto = null;
		request.setParam("userAuthDTO", userAuthInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 身份证号码错误 测试结果:IDCard length should be 15 or 18
	 * */
	@Test
	public void test3() {
		Request request = new BaseRequest();
		UserAuthInfoDTO userAuthInfoDto = new UserAuthInfoDTO();
		userAuthInfoDto.setUserId(30L);
		userAuthInfoDto.setIdcardNo("36232419911025719");
		userAuthInfoDto.setRealName("大神");
		userAuthInfoDto
				.setIdcardFrontImg("http://society.huanqiu.com/photonew/2015-01/2760449.html");
		userAuthInfoDto
				.setIdcardReverseImg("http://g.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=f450e5c46e224f4a57cc20536fcaa460/ac4bd11373f082021c0402dd48fbfbedaa641bb9.jpg");
		request.setParam("userAuthDTO", userAuthInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 真实姓名为空 测试结果：real name is null
	 * */
	@Test
	public void test4() {
		Request request = new BaseRequest();
		UserAuthInfoDTO userAuthInfoDto = new UserAuthInfoDTO();
		userAuthInfoDto.setUserId(30L);
		userAuthInfoDto.setIdcardNo("362324199110235719");
		userAuthInfoDto
				.setIdcardFrontImg("http://society.huanqiu.com/photonew/2015-01/2760449.html");
		userAuthInfoDto
				.setIdcardReverseImg("http://g.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=f450e5c46e224f4a57cc20536fcaa460/ac4bd11373f082021c0402dd48fbfbedaa641bb9.jpg");
		request.setParam("userAuthDTO", userAuthInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 身份证正面地址为空 测试结果：IdCardFrontImg is null
	 */
	@Test
	public void test5() {
		Request request = new BaseRequest();
		UserAuthInfoDTO userAuthInfoDto = new UserAuthInfoDTO();
		userAuthInfoDto.setUserId(30L);
		userAuthInfoDto.setRealName("大神");
		userAuthInfoDto.setIdcardNo("362324199110235719");
		userAuthInfoDto
				.setIdcardReverseImg("http://g.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=f450e5c46e224f4a57cc20536fcaa460/ac4bd11373f082021c0402dd48fbfbedaa641bb9.jpg");
		request.setParam("userAuthDTO", userAuthInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 身份证反面地址为空 测试结果：idCardReverseImg is null
	 * */
	@Test
	public void test6() {
		Request request = new BaseRequest();
		UserAuthInfoDTO userAuthInfoDto = new UserAuthInfoDTO();
		userAuthInfoDto.setUserId(30L);
		userAuthInfoDto.setRealName("大神");
		userAuthInfoDto.setIdcardNo("362324199110235719");
		userAuthInfoDto
				.setIdcardFrontImg("http://society.huanqiu.com/photonew/2015-01/2760449.html");
		request.setParam("userAuthDTO", userAuthInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response response = userService.execute(request);
	}

	/**
	 * 重复保存用户认证信息 测试结果：保存保存
	 */
	@Test
	public void test7() {
		Request request = new BaseRequest();
		UserAuthInfoDTO userAuthInfoDto = new UserAuthInfoDTO();
		userAuthInfoDto.setUserId(30L);
		userAuthInfoDto.setIdcardNo("362324199110235719");
		userAuthInfoDto.setRealName("大大神");
		userAuthInfoDto
				.setIdcardFrontImg("http://society.huanqiu.com/photonew/2015-01/2760449.html");
		userAuthInfoDto
				.setIdcardReverseImg("http://g.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=f450e5c46e224f4a57cc20536fcaa460/ac4bd11373f082021c0402dd48fbfbedaa641bb9.jpg");
		request.setParam("userAuthDTO", userAuthInfoDto);
		request.setCommand(ActionEnum.SAVE_USER_AUTH_INFO.getActionName());
		Response response = userService.execute(request);
	}
}
