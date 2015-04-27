package skupropertytmpl;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.itemcenter.common.api.BaseRequest;
import com.ve.itemcenter.common.api.ItemService;
import com.ve.itemcenter.common.api.Request;
import com.ve.itemcenter.common.api.Response;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.domain.dto.SkuPropertyTmplDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UpdateSkuPropertyTmplTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正确更新
	 */
	public void test001() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		skuPropertyTmplDTO.setId(3L);
		skuPropertyTmplDTO.setOwnerId(1L);
		skuPropertyTmplDTO.setOwnerType(0);
		skuPropertyTmplDTO.setKeyName("尺寸");
		skuPropertyTmplDTO.setVal("XXX");
		skuPropertyTmplDTO.setValType(1);
		skuPropertyTmplDTO.setCategoryId(5);
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.UPDATE_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * skuPropertyTmplDTO 为空
	 */
	public void test002() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * 更新时时主键为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.UPDATE_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * 更新时categoryId在数据库不存在
	 */
	public void test004() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		skuPropertyTmplDTO.setId(3L);
		skuPropertyTmplDTO.setCategoryId(9999);
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.UPDATE_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * 更新时主键在数据库中不存在
	 */
	public void test005() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		skuPropertyTmplDTO.setId(99999L);
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.UPDATE_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
