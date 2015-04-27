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
import com.ve.tradecenter.common.domain.AlipaymentDTO;
import com.ve.tradecenter.core.service.action.ActionEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AlipayCallbackTest {

	@Resource
	private TradeService tradeService;

	@Test
	public void test(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ALIPAY_CALLBACK.getActionName());
		System.out.println("begin alipayCallback");
		
		AlipaymentDTO alipaymentDTO= new AlipaymentDTO();
		alipaymentDTO.setOutTradeNo("111111");
		alipaymentDTO.setSign("abcdedg");
		alipaymentDTO.setToSign("abcdweef");
		alipaymentDTO.setTotalFee(1000L);
		alipaymentDTO.setTradeNo("111111");
		alipaymentDTO.setTradeStatus("TRADE_SUCCESS");
		alipaymentDTO.setUserId(11L);
		alipaymentDTO.setSupplierId(11L);
		
		request.setParam("alipaymentDTO",alipaymentDTO);
		
		Response response = tradeService.execute(request);
		System.out.println("end alipayCallback");
		System.out.println(response);
	}
}