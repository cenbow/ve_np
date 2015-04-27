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
public class AuditReturnApplyTest {

	@Resource
	private TradeService tradeService;
	
	@Test
	public void test(){
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.AUDIT_RETURN_APPLY.getActionName());
		
		System.out.println("begin auditReturnApply");
		ReturnOrderDTO returnOrderDTO = new ReturnOrderDTO();
		returnOrderDTO.setOrderId(10L);
		returnOrderDTO.setUserId(11L);
		List<ReturnOrderItemDTO> list = new ArrayList<ReturnOrderItemDTO>();
		
		ReturnOrderItemDTO item = new ReturnOrderItemDTO();
		
		
		long orderId = 10L;
		long userId = 11;
		int auditResult = 1;
		String memo = "memo";
	
		request.setParam("orderId", orderId);
		request.setParam("userId", userId);
		request.setParam("auditResult", auditResult);
		request.setParam("memo", memo);
		
		Response response = tradeService.execute(request);
		System.out.println("end");
		System.out.println(response);
	}
}
