package test.order;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.tradecenter.common.api.BaseRequest;
import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.Response;
import com.ve.tradecenter.common.api.TradeService;
import com.ve.tradecenter.common.domain.OrderQTO;
import com.ve.tradecenter.core.service.action.ActionEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class QueryUserOrdersTest {

	@Resource
	private TradeService tradeService;

	@Test
	public void test4(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.QUERY_USER_ORDER.getActionName());
		
		System.out.println("begin queryUserOrders");
		
		Date now = new Date();
		OrderQTO orderQTO = new OrderQTO();
		
		Date timeBegin = new Date(now.getTime() - 3*24*3600*1000);
		Date timeEnd = new Date(now.getTime() - 12*3600*1000);
		
		orderQTO.setTimeBegin(timeBegin);
		orderQTO.setTimeEnd(null);
		
		orderQTO.setStart(0);
		orderQTO.setOffset(5);
		orderQTO.setUserId(12L);
		
		orderQTO.setPayStatus(null);
		orderQTO.setDeliveryStatus(null);
		orderQTO.setOrderStatus(null);
		orderQTO.setAfterSale(1);
		
		request.setParam("orderQTO",orderQTO);
		
		Response response = tradeService.execute(request);
		
		System.out.println("end queryUserOrders");
		System.out.println("beign: " + orderQTO.getTimeBegin() +  " end : " + orderQTO.getTimeEnd());
		System.out.println(response);
	}
}
