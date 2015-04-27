package com.ve.deliverycenter.core.service;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ve.deliverycenter.client.ExpressClient;
import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.dto.express.ExpressRegionDTO;

public class HessianConsumerTest {

	public static void main(String[] args) throws Throwable {

		String serviceUrl = "http://127.0.0.1:8080/dubbo";
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setUser("hessian");
		factory.setPassword("hessian");
		ExpressClient searchService = (ExpressClient) factory.create(ExpressClient.class, serviceUrl);
		
		ExpressRegionDTO expressRegionDTO = new ExpressRegionDTO();
		expressRegionDTO.setExpressCode("shunfeng");
		expressRegionDTO.setProvince("福建省");
		expressRegionDTO.setCity("福州市");
		expressRegionDTO.setArea("鼓楼区");
		expressRegionDTO.setTown("温泉街道");
		
		Response<Boolean> result = searchService.checkRegionSupported(expressRegionDTO);

		System.out.println(result.getModule());

	}

}
