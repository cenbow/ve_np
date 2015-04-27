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
public class AddSkuPropertyTmplTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正确插入
	 */
	public void test001() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		skuPropertyTmplDTO.setOwnerType(1);
		skuPropertyTmplDTO.setOwnerId(0L);
		skuPropertyTmplDTO.setKeyName("大衣尺寸");
		skuPropertyTmplDTO.setVal("M");
		skuPropertyTmplDTO.setValType(1);
		skuPropertyTmplDTO.setCategoryId(5);
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
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
		request.setCommand(ActionEnum.ADD_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * keyName为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * Value为空
	 */
	public void test004() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		skuPropertyTmplDTO.setOwnerType(1);
		skuPropertyTmplDTO.setOwnerId(0L);
		skuPropertyTmplDTO.setKeyName("大衣尺寸");
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * CategoryId为空
	 */
	public void test005() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		skuPropertyTmplDTO.setOwnerType(1);
		skuPropertyTmplDTO.setOwnerId(0L);
		skuPropertyTmplDTO.setKeyName("大衣尺寸");
		skuPropertyTmplDTO.setVal("M");
		skuPropertyTmplDTO.setValType(1);
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
	
	@Test
	/**
	 * CategoryId在数据库不存在
	 */
	public void test006() {
		Request request = new BaseRequest();
		SkuPropertyTmplDTO skuPropertyTmplDTO = new SkuPropertyTmplDTO();
		skuPropertyTmplDTO.setOwnerType(1);
		skuPropertyTmplDTO.setOwnerId(0L);
		skuPropertyTmplDTO.setKeyName("大衣尺寸");
		skuPropertyTmplDTO.setVal("M");
		skuPropertyTmplDTO.setValType(1);
		skuPropertyTmplDTO.setCategoryId(9999);
		request.setParam("skuPropertyTmplDTO", skuPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_SKU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
