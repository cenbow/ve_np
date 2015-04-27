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
import com.ve.tradecenter.common.domain.DeliveryNoticeDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.core.service.action.ActionEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DeliveryGoodsTest {

	@Resource
	private TradeService tradeService;

	@Test
	public void test(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.DELIVERY_GOODS.getActionName());
		
		System.out.println("test");
		
		Long orderId = 10L;
		Long userId = 11L;
	
		DeliveryNoticeDTO deliveryNoticeDTO = new DeliveryNoticeDTO();
		deliveryNoticeDTO.setDeliveryId(1);
		deliveryNoticeDTO.setExpress("sf");
		deliveryNoticeDTO.setExpressNo("1111111");
		deliveryNoticeDTO.setMemo("memo");
		deliveryNoticeDTO.setOperator("wiliam");
		deliveryNoticeDTO.setOrderId(10L);
		deliveryNoticeDTO.setUserId(11L);
		
		List<OrderItemDTO> orderItems = new ArrayList<OrderItemDTO>();
		OrderItemDTO item  = new OrderItemDTO();
		item.setItemSkuId(111L);
		item.setId(3L);
		item.setNumber(2);
		
		orderItems.add(item);
		
		deliveryNoticeDTO.setOrderItems(orderItems);
		
		request.setParam("deliveryNoticeDTO",deliveryNoticeDTO);
		Response response = tradeService.execute(request);
		System.out.println("end deliveryGoods");
		System.out.println(response);
	}
}
