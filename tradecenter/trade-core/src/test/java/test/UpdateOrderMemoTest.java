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
public class UpdateOrderMemoTest {

	@Resource
	private TradeService tradeService;
	
	/*@Test  
	public void test() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_ORDER_MEMO.getActionName());
		
		String newMemo = null;
		Integer memoType = null;
		Long orderId = null;
		Long userId = null;
		
		request.setParam("newMemo",newMemo);
		request.setParam("memoType", memoType);
		request.setParam("orderId", orderId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	@Test  
	public void test2() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_ORDER_MEMO.getActionName());
		
		String newMemo = "new Memo";
		Integer memoType = null;
		Long orderId = null;
		Long userId = null;
		
		request.setParam("newMemo",newMemo);
		request.setParam("memoType", memoType);
		request.setParam("orderId", orderId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	
	
	@Test  
	public void test3() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_ORDER_MEMO.getActionName());
		
		String newMemo = "new Memo";
		Integer memoType = 2;
		Long orderId = 21L;
		Long userId = 20L;
		
		request.setParam("newMemo",newMemo);
		request.setParam("memoType", memoType);
		request.setParam("orderId", orderId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
	*/
	@Test  
	public void test4() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_ORDER_MEMO.getActionName());
		
		String newMemo = "new Memo";
		Integer memoType = 3;
		Long orderId = 31L;
		Long userId = 30L;
		
		request.setParam("newMemo",newMemo);
		request.setParam("memoType", memoType);
		request.setParam("orderId", orderId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println(response);
	}
}
