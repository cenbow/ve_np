package activity;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.marketingcenter.common.api.BaseRequest;
import com.ve.marketingcenter.common.api.MarketingService;
import com.ve.marketingcenter.common.api.Request;
import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.constant.ActionEnum;
import com.ve.marketingcenter.common.constant.MarketingConstant;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AuditActivityTest {
	@Resource
	private  MarketingService<MarketingActivityDTO> activityService;

	@Test
	public void test() {
		Request request = new BaseRequest();
//		MarketingActivityDTO dto = get();
		request.setParam(MarketingConstant.REQUEST_PARAM_PRIMARY_KEY, 2);
		request.setParam(MarketingConstant.REQUEST_PARAM_USER_ID, 11000127);
		request.setCommand(ActionEnum.ACTIVITY_SUBMIT_AUDTING.getActionName());
		Response<MarketingActivityDTO> response = activityService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getResCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
