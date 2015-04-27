package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CartFavorableTest {
	@Resource
	private  MarketingService<MarketingActivityDTO> activityService;

	@Test
	public void test() {
		Request request = new BaseRequest();
//		MarketingActivityDTO dto = get();
		request.setParam(MarketingConstant.REQUEST_PARAM_USER_ID, 11000127);
		request.setParam(MarketingConstant.REQUEST_PARAM_USER_TYPE,MarketingConstant.USER_TYPE_ALL);
		request.setParam(MarketingConstant.REQUEST_PARAM_ITEM_LIST, getList());
		request.setParam(MarketingConstant.REQUEST_PARAM_COUPON_LIST, Collections.EMPTY_LIST);
		request.setParam(MarketingConstant.REQUEST_PARAM_PLATFORM, "1,2");
		
		
		request.setCommand(ActionEnum.COMPUTE_CART_FAVORABLE.getActionName());
		Response<MarketingActivityDTO> response = activityService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getResCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	private List<MarketingItemDTO> getList(){
		List<MarketingItemDTO> items = new ArrayList<MarketingItemDTO>();
		MarketingItemDTO dto = new MarketingItemDTO();
		dto.setItemSkuId(11000L);
		dto.setItemName("牙膏");
		dto.setUnitPrice(10L);
		dto.setNumber(10);
		items.add(dto);
		return items;
	}
}
