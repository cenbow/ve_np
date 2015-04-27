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
import com.ve.tradecenter.common.domain.ItemSkuDTO;
import com.ve.tradecenter.common.domain.OrderDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.core.service.action.ActionEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddOrderTest {

	@Resource
	private TradeService tradeService;

	@Test
	public void test(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_ORDER.getActionName());
		System.out.println("begin addOrder");
		
		//TODO 总单归于ve名下
		
		OrderDTO order= new OrderDTO();
		order.setUserId(11L);
		order.setAddressId(11L);
		order.setIsCod(false);
		order.setUserMemo("user memo");
		order.setSource(3);
		order.setPaymentId(1);
		order.setDeliveryId(1);
		order.setIsCod(false);
		order.setTel("54875665");
		order.setMobile("15000138722");
		order.setConsignee("cwr");
		order.setUserMemo("userMemo");
		
		List<OrderItemDTO> toBuyItems = new ArrayList<OrderItemDTO>();
		
		OrderItemDTO item = new OrderItemDTO();
		/*item.setItemSkuId(111L);
		item.setSupplierId(11L);
		item.setSupplierType(2);
		item.setNumber(2);
		toBuyItems.add(item);
		order.setOrderItems(toBuyItems);
		
		OrderItemDTO item2 = new OrderItemDTO();
		item2.setItemSkuId(121L);
		item2.setSupplierId(12L);
		item2.setSupplierType(2);
		item2.setNumber(1);
		toBuyItems.add(item2);*/
		
		OrderItemDTO item3 = new OrderItemDTO();
		item3.setItemSkuId(141L);
		item3.setSupplierId(14L);
		item3.setSupplierType(2);
		toBuyItems.add(item3);
		item3.setNumber(1);
		
		order.setOrderItems(toBuyItems);
		
		request.setParam("orderDTO",order);
		
		Response response = tradeService.execute(request);
		System.out.println("end addOrder");
		System.out.println(response);
	}
}