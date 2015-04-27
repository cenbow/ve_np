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
import com.ve.tradecenter.common.domain.CartItemDTO;
import com.ve.tradecenter.core.service.action.ActionEnum;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UpdateUserCartItemTest {

	@Resource
	private TradeService tradeService;
	
	@Test  // done
	public void test() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = null;
		Integer number = null;
		Long userId = null;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test2() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = 12L;
		Integer number = null;
		Long userId = 10L;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test3() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = 12L;
		Integer number = 2;
		Long userId = null;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test4() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = null;
		Integer number = 2;
		Long userId = 10L;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test5() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = 12L;
		Integer number = 2;
		Long userId = null;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test6() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = null;
		Integer number = 2;
		Long userId = 10L;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test7() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = 12L;
		Integer number = null;
		Long userId = 10L;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test8() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = 12L;
		Integer number = 2;
		Long userId = 10L;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("number", number);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
}
