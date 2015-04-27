package tool;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class GetToolTest {
	@Resource
	private  MarketingService<MarketingToolDTO> marketService;

	@Test
	public void test() {
		Request request = new BaseRequest();
		
		request.setParam(MarketingConstant.REQUEST_PARAM_PRIMARY_KEY,1);
		request.setCommand(ActionEnum.TOOL_GET.getActionName());
		
		long start = System.currentTimeMillis();
		Response<MarketingToolDTO> response = marketService.execute(request);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("**************************************");
		System.out.println("Model:" + JSONObject.toJSONString(response.getModule(),true));
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getResCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
		}
	
}
