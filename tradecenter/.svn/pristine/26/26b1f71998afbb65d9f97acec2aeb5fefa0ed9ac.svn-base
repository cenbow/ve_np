package test.order;

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
public class ReturnGoodsTest {

	@Resource
	private TradeService tradeService;

	@Test
	public void test4(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.GET_ORDER.getActionName());
		
		System.out.println("begin getOrder");
		
		Long orderId = 10L;
		Long userId = 11L;
	
		request.setParam("userId",userId);
		request.setParam("orderId",orderId);
		
		Response response = tradeService.execute(request);
		System.out.println("end deliveryGoods");
		System.out.println(response);
	}
}
