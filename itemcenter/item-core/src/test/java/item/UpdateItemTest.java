package item;

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
import com.ve.itemcenter.common.domain.dto.ItemDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UpdateItemTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正常更新
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(13L);
		itemDTO.setSupplierId(2L);
		itemDTO.setItemName("大头");
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.UPDATE_ITEM.getActionName());
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
	 * itemDTO为空
	 */
	public void test002() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.UPDATE_ITEM.getActionName());
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
	 * ID为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setSupplierId(2L);
		itemDTO.setItemName("大头");
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.UPDATE_ITEM.getActionName());
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
	public void test004() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(13L);
		itemDTO.setItemName("大头");
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.UPDATE_ITEM.getActionName());
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
	 * ID在数据库中不存在
	 */
	public void test005() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(99999L);
		itemDTO.setSupplierId(2L);
		itemDTO.setItemName("大头");
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.UPDATE_ITEM.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
