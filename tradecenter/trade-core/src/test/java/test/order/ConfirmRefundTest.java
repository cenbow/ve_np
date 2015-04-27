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
import com.ve.tradecenter.common.domain.ReturnOrderDTO;
import com.ve.tradecenter.common.domain.ReturnOrderItemDTO;
import com.ve.tradecenter.core.service.action.ActionEnum;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ConfirmRefundTest {

	@Resource
	private TradeService tradeService;
	
	
	@Test
	public void test4(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.CONFIRM_REFUND.getActionName());
		
		System.out.println("begin confirmRefund");
		
		Long orderId = 10L;
		Long userId = 11L;
	
		request.setParam("orderId", orderId);
		request.setParam("userId", userId);
		
		Response response = tradeService.execute(request);
		System.out.println("end confirmRefund");
		System.out.println(response);
	}
}