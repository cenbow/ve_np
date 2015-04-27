package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.tradecenter.common.api.BaseRequest;
import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.Response;
import com.ve.tradecenter.common.api.TradeService;
import com.ve.tradecenter.core.service.action.ActionEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class QueryUserCartItemsTest {
	@Resource
	private TradeService tradeService;
	
	@Test  
	public void test() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_CART_ITEMS.getActionName());
		Long userId = null;
		Integer source = null;
		
		request.setParam("userId",userId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test2() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_CART_ITEMS.getActionName());
		Long userId = null;
		Integer source = 4;
		
		request.setParam("userId",userId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test3() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_CART_ITEMS.getActionName());
		Long userId = 10L;
		Integer source = null;
		
		request.setParam("userId",userId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test4() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_CART_ITEMS.getActionName());
		Long userId = 10L;
		Integer source = 1;
		
		request.setParam("userId",userId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test5() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_CART_ITEMS.getActionName());
		Long userId = 10L;
		Integer source = 3;
		
		request.setParam("userId",userId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test6() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_CART_ITEMS.getActionName());
		Long userId = 10L;
		Integer source = 4;
		
		request.setParam("userId",userId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test7() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_CART_ITEMS.getActionName());
		Long userId = 10L;
		Integer source = 5;
		
		request.setParam("userId",userId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
}
