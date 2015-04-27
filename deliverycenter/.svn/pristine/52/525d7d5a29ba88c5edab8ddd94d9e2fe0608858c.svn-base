package com.ve.deliverycenter.core.service.action.fee;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ve.deliverycenter.common.api.BaseRequest;
import com.ve.deliverycenter.common.api.DeliveryService;
import com.ve.deliverycenter.common.api.Request;
import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.constant.ActionEnum;
import com.ve.deliverycenter.common.dto.fee.RegionDTO;
import com.ve.deliverycenter.common.qto.fee.RegionQTO;
import com.ve.deliverycenter.core.service.BaseTest;

public class QueryRegionTest extends BaseTest {

	@Resource
	private DeliveryService deliveryService;

	/**
	 * 测试查询有数据分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		// 创建一个QTO并赋值
		RegionQTO regionQTO = new RegionQTO();
		regionQTO.setPageNo(1);
		regionQTO.setPageSize(50);
		regionQTO.setParentId(0);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_REGION.getActionName());
		request.setParam("regionQTO", regionQTO);
		// 执行分发执行对应Action
		Response<List<RegionDTO>> response = deliveryService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Assert.assertTrue(response.getModule().size() > 0);
	}

	/**
	 * 测试查询parentId不存在没有数据分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		// 创建一个QTO并赋值
		RegionQTO regionQTO = new RegionQTO();
		regionQTO.setPageNo(1);
		regionQTO.setPageSize(50);
		regionQTO.setParentId(9);
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_REGION.getActionName());
		request.setParam("regionQTO", regionQTO);
		// 执行分发执行对应Action
		Response<List<RegionDTO>> response = deliveryService.execute(request);
		Assert.assertEquals(true, response.isSuccess());
		Assert.assertTrue(response.getModule().size() == 0);
	}

	/**
	 * 测试参数为空分支
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		// 创建request对象并赋值
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_REGION.getActionName());
		request.setParam("regionQTO", null);
		// 执行分发执行对应Action
		Response<List<RegionDTO>> response = deliveryService.execute(request);
		Assert.assertEquals(false, response.isSuccess());
	}
}
