package activity;

import java.util.ArrayList;
import java.util.Date;
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
import com.ve.marketingcenter.common.domain.dto.MarketingActualParamDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingScopeDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddActivityTest {
	@Resource
	private  MarketingService<MarketingActivityDTO> activityService;

	@Test
	public void test() {
		Request request = new BaseRequest();
		MarketingActivityDTO dto = get();
		request.setParam(MarketingConstant.REQUEST_PARAM_KEY_ENTITY, dto);
		request.setCommand(ActionEnum.ACTIVITY_ADD.getActionName());
		Response<MarketingActivityDTO> response = activityService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getResCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
		}
	
	private MarketingActivityDTO get(){
		MarketingActivityDTO dto = new MarketingActivityDTO();
		
		dto.setActName("满100减10");
		dto.setCouponFlag(MarketingConstant.GLOBAL_FLAG_NO);
		dto.setCouponType(MarketingConstant.GLOBAL_FLAG_NO);
		dto.setCreatorType(MarketingConstant.CREATOR_TYPE_BUSINESS_OPERATOR);
		dto.setCreatorUserId(123578L);
		dto.setStartTime(new Date());
		dto.setEndTime(new Date());
		dto.setPlatform("1,2");//前台传过来
		dto.setRepellentFlag(MarketingConstant.GLOBAL_FLAG_NO);
		dto.setToolId(1L);
		
		List<MarketingScopeDTO> scopes = new ArrayList<MarketingScopeDTO>();
		
		MarketingScopeDTO includeAll = new MarketingScopeDTO();
		includeAll.setCludeType(MarketingConstant.GLOBAL_FLAG_YES);
		includeAll.setMarketType(MarketingConstant.ACTIVITY_SCOPE_ALL);
		scopes.add(includeAll);
		
		MarketingScopeDTO excludeItem = new MarketingScopeDTO();
		excludeItem.setCludeType(MarketingConstant.GLOBAL_FLAG_NO);
		excludeItem.setMarketType(MarketingConstant.ACTIVITY_SCOPE_SIG);
		excludeItem.setCludeId(5555555L);
		scopes.add(excludeItem);
		
		MarketingScopeDTO excludeSpecial = new MarketingScopeDTO();
		excludeSpecial.setCludeType(MarketingConstant.GLOBAL_FLAG_NO);
		excludeSpecial.setMarketType(MarketingConstant.ACTIVITY_SCOPE_SPC);
		excludeSpecial.setCludeId(666666L);
		scopes.add(excludeSpecial);
		
		dto.setMarketScopes(scopes);
		
		
		List<MarketingActualParamDTO> marketParams = new ArrayList<MarketingActualParamDTO>();
		
		MarketingActualParamDTO condition = new MarketingActualParamDTO();
//		condition.setOwnerId(dto.getToolId());
		condition.setOwnerType(MarketingConstant.PARAM_OWNER_TYPE_ACT);
		condition.setParamName(MarketingConstant.CONDITION_COM_TYPE_GE);
		condition.setParamValue("100");
		marketParams.add(condition);
		
		MarketingActualParamDTO action = new MarketingActualParamDTO();
//		action.setOwnerId(dto.getToolId());
		action.setOwnerType(MarketingConstant.PARAM_OWNER_TYPE_ACT);
		action.setParamName(MarketingConstant.ACTIVITY_COM_TYPE_SUBSTRACT);
		action.setParamValue("10");
		marketParams.add(action);
		
		MarketingActualParamDTO target = new MarketingActualParamDTO();
		target.setOwnerType(MarketingConstant.PARAM_OWNER_TYPE_ACT);
		target.setParamName(MarketingConstant.MARKETING_ACTIVITY_TARGET);
		target.setParamValue(MarketingConstant.USER_TYPE_ALL);
		marketParams.add(target);
		dto.setMarketParams(marketParams);
		
		
//		Map<String,Map<String,List<Long>>> smap = new HashMap<String,Map<String,List<Long>>>();
//		
//		Map<String,List<Long>> include = new HashMap<String,List<Long>>();
//		Map<String,List<Long>> exclude = new HashMap<String,List<Long>>();
//		
//		include.put(MarketingConstant.ACT_PARAM_ALL, null);
//		
//		List<Long> exSpecialList = new ArrayList<Long>();
//		exSpecialList.add(111111111L);
//		exclude.put(MarketingConstant.ACT_PARAM_SPECIAL, exSpecialList);
//		
//		List<Long> exItemList = new ArrayList<Long>();
//		exItemList.add(222222222L);
//		exclude.put(MarketingConstant.ACT_PARAM_ITEM, exItemList);
//		
//		smap.put(MarketingConstant.ACT_SCOPE_PARAM_IN, include);
//		smap.put(MarketingConstant.ACT_SCOPE_PARAM_EX, exclude);
//		dto.setScopeParams(smap);
//		
//		Map<String,String> tmap = new HashMap<String,String>();
//		tmap.put("GE", "100");
//		tmap.put("SUBSTRACT", "10");
//		dto.setToolParams(tmap);
		
		return dto;
	}
}
