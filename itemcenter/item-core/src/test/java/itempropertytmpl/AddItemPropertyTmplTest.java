package itempropertytmpl;

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
import com.ve.itemcenter.common.domain.dto.ItemPropertyTmplDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddItemPropertyTmplTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正常插入
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemPropertyTmplDTO itemPropertyTmplDTO = new ItemPropertyTmplDTO();
		itemPropertyTmplDTO.setTmplName("服饰222");
		itemPropertyTmplDTO.setPropertyType(0);
		itemPropertyTmplDTO.setKeyName("颜色");
		itemPropertyTmplDTO.setVal("天蓝色");
		itemPropertyTmplDTO.setValType(1);
		itemPropertyTmplDTO.setCategoryId(3);
		request.setParam("itemPropertyTmplDTO", itemPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY_TMPL.getActionName());
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
	 * itemPropertyTmplDTO为空
	 */
	public void test002() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY_TMPL.getActionName());
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
	 * 模板名字为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		ItemPropertyTmplDTO itemPropertyTmplDTO = new ItemPropertyTmplDTO();
		itemPropertyTmplDTO.setPropertyType(0);
		itemPropertyTmplDTO.setKeyName("颜色");
		itemPropertyTmplDTO.setVal("天蓝色");
		itemPropertyTmplDTO.setValType(1);
		itemPropertyTmplDTO.setCategoryId(3);
		request.setParam("itemPropertyTmplDTO", itemPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY_TMPL.getActionName());
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
	 * key_name 为空
	 */
	public void test004() {
		Request request = new BaseRequest();
		ItemPropertyTmplDTO itemPropertyTmplDTO = new ItemPropertyTmplDTO();
		itemPropertyTmplDTO.setTmplName("服饰222");
		itemPropertyTmplDTO.setPropertyType(0);
		itemPropertyTmplDTO.setVal("天蓝色");
		itemPropertyTmplDTO.setValType(1);
		itemPropertyTmplDTO.setCategoryId(3);
		request.setParam("itemPropertyTmplDTO", itemPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY_TMPL.getActionName());
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
	public void test005() {
		Request request = new BaseRequest();
		ItemPropertyTmplDTO itemPropertyTmplDTO = new ItemPropertyTmplDTO();
		itemPropertyTmplDTO.setTmplName("服饰222");
		itemPropertyTmplDTO.setPropertyType(0);
		itemPropertyTmplDTO.setKeyName("颜色");
		itemPropertyTmplDTO.setValType(1);
		itemPropertyTmplDTO.setCategoryId(3);
		request.setParam("itemPropertyTmplDTO", itemPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY_TMPL.getActionName());
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
	 * categoryId 为空
	 */
	public void test006() {
		Request request = new BaseRequest();
		ItemPropertyTmplDTO itemPropertyTmplDTO = new ItemPropertyTmplDTO();
		itemPropertyTmplDTO.setTmplName("服饰222");
		itemPropertyTmplDTO.setPropertyType(0);
		itemPropertyTmplDTO.setKeyName("颜色");
		itemPropertyTmplDTO.setVal("天蓝色");
		itemPropertyTmplDTO.setValType(1);
		request.setParam("itemPropertyTmplDTO", itemPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY_TMPL.getActionName());
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
	 * CategoryId在数据库中不存在
	 */
	public void test007() {
		Request request = new BaseRequest();
		ItemPropertyTmplDTO itemPropertyTmplDTO = new ItemPropertyTmplDTO();
		itemPropertyTmplDTO.setTmplName("服饰222");
		itemPropertyTmplDTO.setPropertyType(0);
		itemPropertyTmplDTO.setKeyName("颜色");
		itemPropertyTmplDTO.setVal("天蓝色");
		itemPropertyTmplDTO.setValType(1);
		itemPropertyTmplDTO.setCategoryId(9999);
		request.setParam("itemPropertyTmplDTO", itemPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_ITEM_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
