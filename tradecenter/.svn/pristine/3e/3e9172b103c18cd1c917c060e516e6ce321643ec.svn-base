package test.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.tradecenter.common.api.BaseRequest;
import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.Response;
import com.ve.tradecenter.common.api.TradeService;
import com.ve.tradecenter.common.domain.DeliveryNoticeDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.core.service.action.ActionEnum;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class GetOrderTest {

	@Resource
	private TradeService tradeService;

	@Test
	public void test(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GET_ORDER.getActionName());
		System.out.println("test");
		
		Long orderId = null;
		Long userId = null;
		request.setParam("userId",userId);
		request.setParam("orderId",orderId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test
	public void test2(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GET_ORDER.getActionName());
		System.out.println("test2");
		
		Long orderId = 10L;
		Long userId = null;
		request.setParam("userId",userId);
		request.setParam("orderId",orderId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test
	public void test3(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GET_ORDER.getActionName());
		System.out.println("test3");
		
		Long orderId = null;
		Long userId = 11L;
		request.setParam("userId",userId);
		request.setParam("orderId",orderId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test
	public void test4(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GET_ORDER.getActionName());
		System.out.println("test4");
		
		Long orderId = 10L;
		Long userId = 11L;
		request.setParam("userId",userId);
		request.setParam("orderId",orderId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test
	public void test5(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GET_ORDER.getActionName());
		System.out.println("test5");
		
		Long orderId = 10L;
		Long userId = 12L;
		request.setParam("userId",userId);
		request.setParam("orderId",orderId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
}

