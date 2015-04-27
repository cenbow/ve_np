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
public class AddUserCartItemTest {
	@Resource
	private TradeService tradeService;
	
	@Test  
	public void test() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = null;
		Integer number = null;
		Long userId = null;
		Long supplierId = null;
		Integer source = null;
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test2() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = null;
		Integer number = 2;
		Long userId = null;
		Long supplierId = null;
		Integer source = null;
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	
	@Test  
	public void test3() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 21L;
		Integer number = 2;
		Long userId = 10L;
		Long supplierId = null;
		Integer source = null;
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	
	@Test  
	public void test4() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 21L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = null;// 默认需要是pc
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test5() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 21L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 1;
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test6() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 22L;
		Integer number = 3;
		Long userId = 11L;
		Long supplierId = 11L;
		Integer source = 1; // pc
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}

	@Test  
	public void test7() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 23L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 3; //ios
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test8() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 24L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 4; // android
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test9() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 25L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 5; // html5
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test10() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 21L;
		Integer number = 1;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 1; 
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test11() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 21L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 3; 
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test12() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 21L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 4; 
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test13() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_USER_CART_ITEM.getActionName());
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		Long itemSkuId = 21L;
		Integer number = 3;
		Long userId = 10L;
		Long supplierId = 11L;
		Integer source = 5; 
		
		cartItemDTO.setItemSkuId(itemSkuId);
		cartItemDTO.setNumber(number);
		cartItemDTO.setUserId(userId);
		cartItemDTO.setSupplierId(supplierId);
		cartItemDTO.setSource(source);
		
		request.setParam("cartItemDTO",cartItemDTO);
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
}
