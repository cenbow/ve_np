package itemcategory;

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
import com.ve.itemcenter.common.domain.dto.ItemCategoryDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddItemCategoryTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正常插入
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
		itemCategoryDTO.setCateLevel(2);
		itemCategoryDTO.setCateName("书");
		itemCategoryDTO.setParentId(0);
		itemCategoryDTO.setSort(1);
		itemCategoryDTO.setTopid(1);
		request.setParam("itemCategoryDTO", itemCategoryDTO);
		request.setCommand(ActionEnum.ADD_ITEM_CATEGORY.getActionName());
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
	 * itemCategoryDTO为空
	 */
	public void test002() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_ITEM_CATEGORY.getActionName());
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
	 * 父ID不合法
	 */
	public void test003() {
		Request request = new BaseRequest();
		ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
		itemCategoryDTO.setCateLevel(2);
		itemCategoryDTO.setCateName("书");
		itemCategoryDTO.setParentId(9999);
		itemCategoryDTO.setSort(1);
		itemCategoryDTO.setTopid(1);
		request.setParam("itemCategoryDTO", itemCategoryDTO);
		request.setCommand(ActionEnum.ADD_ITEM_CATEGORY.getActionName());
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
	 * 类目名称为空
	 */
	public void test004() {
		Request request = new BaseRequest();
		ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
		itemCategoryDTO.setCateLevel(2);
		itemCategoryDTO.setParentId(0);
		itemCategoryDTO.setSort(1);
		itemCategoryDTO.setTopid(1);
		request.setParam("itemCategoryDTO", itemCategoryDTO);
		request.setCommand(ActionEnum.ADD_ITEM_CATEGORY.getActionName());
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
	 * 层级为空
	 */
	public void test005() {
		Request request = new BaseRequest();
		ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
		itemCategoryDTO.setCateName("书");
		itemCategoryDTO.setParentId(0);
		itemCategoryDTO.setSort(1);
		itemCategoryDTO.setTopid(1);
		request.setParam("itemCategoryDTO", itemCategoryDTO);
		request.setCommand(ActionEnum.ADD_ITEM_CATEGORY.getActionName());
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
	 * 父ID为空
	 */
	public void test006() {
		Request request = new BaseRequest();
		ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
		itemCategoryDTO.setCateLevel(2);
		itemCategoryDTO.setCateName("书");
		itemCategoryDTO.setSort(1);
		itemCategoryDTO.setTopid(1);
		request.setParam("itemCategoryDTO", itemCategoryDTO);
		request.setCommand(ActionEnum.ADD_ITEM_CATEGORY.getActionName());
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
	 * 顶级ID为空
	 */
	public void test007() {
		Request request = new BaseRequest();
		ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
		itemCategoryDTO.setCateLevel(2);
		itemCategoryDTO.setCateName("书");
		itemCategoryDTO.setParentId(0);
		itemCategoryDTO.setSort(1);
		request.setParam("itemCategoryDTO", itemCategoryDTO);
		request.setCommand(ActionEnum.ADD_ITEM_CATEGORY.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
