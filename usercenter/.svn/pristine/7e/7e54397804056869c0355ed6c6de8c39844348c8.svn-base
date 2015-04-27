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
import com.ve.usercenter.common.dto.ConsigneeDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserConsigneeTest {
	@Resource
	private UserService userService;

	@Test
	public void test() {

		Request request = new BaseRequest();

		/*
		 * ConsigneeDTO consigneeDto = new ConsigneeDTO();
		 * consigneeDto.setUserId(11L); consigneeDto.setCountry(1);
		 * consigneeDto.setProvince(3); consigneeDto.setCity(4);
		 * consigneeDto.setArea(4); consigneeDto.setConsignee("金刚葫芦娃");
		 * consigneeDto.setAddress("文三路华星时代广场1205");
		 * consigneeDto.setMobileNo("13569874562");
		 * consigneeDto.setRemark("一个藤上8个挂");
		 * 
		 * request.setParam("consigneeDTO", consigneeDto);
		 * request.setCommand(ActionEnum.ADD_CONSIGNEE.getActionName());
		 */

		request.setParam("userId", 11L);
		// request.setParam("consigneeId", 5L);
		request.setCommand(ActionEnum.QUERY_CONSIGNEE.getActionName());

		Response response = userService.execute(request);

	}

	@Test
	public void addtest() {
		Request request = new BaseRequest();

		ConsigneeDTO consigneeDto = new ConsigneeDTO();
		consigneeDto.setUserId(12L);
		consigneeDto.setCountry(1);
		consigneeDto.setProvince(3);
		consigneeDto.setCity(4);
		consigneeDto.setArea(4);
		consigneeDto.setConsignee("老五");
		consigneeDto.setAddress("文三路华星时代广场1205-1206");
		consigneeDto.setMobileNo("13569874562");
		consigneeDto.setRemark("一个藤上7个瓜");
		request.setParam("consigneeDTO", consigneeDto);
		request.setCommand(ActionEnum.ADD_CONSIGNEE.getActionName());

		Response response = userService.execute(request);

	}

	@Test
	public void updatetest() {

		Request request = new BaseRequest();
		ConsigneeDTO consigneeDto = new ConsigneeDTO();
		consigneeDto.setId(9L);
		consigneeDto.setUserId(12L);
		consigneeDto.setCountry(1);
		consigneeDto.setProvince(3);
		consigneeDto.setCity(4);
		consigneeDto.setArea(4);
		consigneeDto.setConsignee("老三");
		consigneeDto.setAddress("文三路华星时代广场1206");
		consigneeDto.setMobileNo("13569874562");
		consigneeDto.setRemark("一个藤上7个瓜");
		request.setParam("consigneeDTO", consigneeDto);
		request.setCommand(ActionEnum.UPDATE_CONSIGNEE.getActionName());

		Response response = userService.execute(request);

	}

	@Test
	public void deltest() {
		Request request = new BaseRequest();
		request.setParam("userId", 12L);
		request.setParam("consigneeId", 8L);
		request.setCommand(ActionEnum.DELETE_CONSIGNEE.getActionName());
		Response response = userService.execute(request);
	}

	@Test
	public void queryConsignee() {
		Request request = new BaseRequest();
		request.setParam("userId", 11L);
		request.setCommand(ActionEnum.QUERY_CONSIGNEE.getActionName());
		Response response = userService.execute(request);
	}

	@Test
	public void setDefConfignee() {
		Request request = new BaseRequest();
		request.setParam("consigneeId", 8L);
		request.setParam("userId", 12L);
		request.setCommand(ActionEnum.SET_DEFAULT_CONSIGNEE.getActionName());
		Response response = userService.execute(request);
	}
}
