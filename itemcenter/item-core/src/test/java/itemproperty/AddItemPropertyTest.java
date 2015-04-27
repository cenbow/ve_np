package itemproperty;

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
import com.ve.itemcenter.common.domain.dto.ItemPropertyDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddItemPropertyTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正常插入
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemPropertyDTO itemPropertyDTO = new ItemPropertyDTO();
		itemPropertyDTO.setItemId(1L);
		itemPropertyDTO.setSupplierId(2L);
		itemPropertyDTO.setPropertyType(0);
		itemPropertyDTO.setKeyName("颜色");
		itemPropertyDTO.setVal("红红33色");
		itemPropertyDTO.setValType(1);
		request.setParam("itemPropertyDTO", itemPropertyDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY.getActionName());
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
	 * itemPropertyDTO为空
	 */
	public void test002() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY.getActionName());
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
	 * key_name为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		ItemPropertyDTO itemPropertyDTO = new ItemPropertyDTO();
		itemPropertyDTO.setItemId(1L);
		itemPropertyDTO.setSupplierId(2L);
		itemPropertyDTO.setPropertyType(0);
		itemPropertyDTO.setVal("红红33色");
		itemPropertyDTO.setValType(1);
		request.setParam("itemPropertyDTO", itemPropertyDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY.getActionName());
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
	 * value为空
	 */
	public void test004() {
		Request request = new BaseRequest();
		ItemPropertyDTO itemPropertyDTO = new ItemPropertyDTO();
		itemPropertyDTO.setItemId(1L);
		itemPropertyDTO.setSupplierId(2L);
		itemPropertyDTO.setPropertyType(0);
		itemPropertyDTO.setKeyName("颜色");
		itemPropertyDTO.setValType(1);
		request.setParam("itemPropertyDTO", itemPropertyDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY.getActionName());
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
	 * item_id为空
	 */
	public void test005() {
		Request request = new BaseRequest();
		ItemPropertyDTO itemPropertyDTO = new ItemPropertyDTO();
		itemPropertyDTO.setSupplierId(2L);
		itemPropertyDTO.setPropertyType(0);
		itemPropertyDTO.setKeyName("颜色");
		itemPropertyDTO.setVal("红红33色");
		itemPropertyDTO.setValType(1);
		request.setParam("itemPropertyDTO", itemPropertyDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY.getActionName());
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
	 * 供应商ID为空
	 */
	public void test006() {
		Request request = new BaseRequest();
		ItemPropertyDTO itemPropertyDTO = new ItemPropertyDTO();
		itemPropertyDTO.setItemId(1L);
		itemPropertyDTO.setPropertyType(0);
		itemPropertyDTO.setKeyName("颜色");
		itemPropertyDTO.setVal("红红33色");
		itemPropertyDTO.setValType(1);
		request.setParam("itemPropertyDTO", itemPropertyDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY.getActionName());
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
	 * itemId在数据库不存在
	 */
	public void test007() {
		Request request = new BaseRequest();
		ItemPropertyDTO itemPropertyDTO = new ItemPropertyDTO();
		itemPropertyDTO.setItemId(99999L);
		itemPropertyDTO.setSupplierId(2L);
		itemPropertyDTO.setPropertyType(0);
		itemPropertyDTO.setKeyName("颜色");
		itemPropertyDTO.setVal("红红33色");
		itemPropertyDTO.setValType(1);
		request.setParam("itemPropertyDTO", itemPropertyDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
