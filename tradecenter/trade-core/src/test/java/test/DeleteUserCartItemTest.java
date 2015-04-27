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
public class DeleteUserCartItemTest {
	@Resource
	private TradeService tradeService;
	
	@Test  // done
	public void test() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_USER_CART_ITEM.getActionName());
		
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		request.setParam("cartItemId",124L);
		request.setParam("userId", 111L);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test2() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_USER_CART_ITEM.getActionName());
		
		CartItemDTO cartItemDTO = new CartItemDTO();
		Long cartItemId = null;
		Long userId = null;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test3() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = 11L;
		Long userId = null;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  // done
	public void test4() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = null;
		Long userId = 12L;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test5() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELETE_USER_CART_ITEM.getActionName());
		
		Long cartItemId = 121L;
		Long userId = 88L;
		
		request.setParam("cartItemId",cartItemId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
}
