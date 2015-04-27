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
public class QueryCartItemsTest {

	@Resource
	private TradeService tradeService;
	
	@Test  
	public void test() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_CART_ITEMS.getActionName());
		
		String sessionId = null;
		Integer source = null;
		
		request.setParam("sessionId",sessionId);
		request.setParam("source", source);
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test2() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_CART_ITEMS.getActionName());
		
		String sessionId = null;
		Integer source = 4;
		
		request.setParam("sessionId",sessionId);
		request.setParam("source", source);
		
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test3() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_CART_ITEMS.getActionName());
		
		String sessionId = "abcd" ;
		Integer source = null;
		
		request.setParam("sessionId",sessionId);
		request.setParam("source", source);
		
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
	
	@Test  
	public void test4() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_CART_ITEMS.getActionName());
		
		String sessionId = "abcd";
		Integer source = 4;
		
		request.setParam("sessionId",sessionId);
		request.setParam("source", source);
		
		Response response = tradeService.execute(request);
		
		System.out.println(response);
	}
}
