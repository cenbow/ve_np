package itembrand;

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
import com.ve.itemcenter.common.domain.dto.ItemBrandDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddItemBrandTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 *正确的插入 
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemBrandDTO itemBrandDTO = new ItemBrandDTO();
		itemBrandDTO.setCname("AK65");
		itemBrandDTO.setEname("CK");
		itemBrandDTO.setLogoUrl("http://www.163.com/a.jpg");
		request.setParam("itemBrandDTO", itemBrandDTO);
		request.setCommand(ActionEnum.ADD_ITEMBRAND.getActionName());
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
	 *itemBrandDTO为null 
	 */
	public void test002() {
		Request request = new BaseRequest();
		ItemBrandDTO itemBrandDTO = null;
		request.setParam("itemBrandDTO", itemBrandDTO);
		request.setCommand(ActionEnum.ADD_ITEMBRAND.getActionName());
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
	 * 品牌中文名cname为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		ItemBrandDTO itemBrandDTO = new ItemBrandDTO();
		itemBrandDTO.setEname("CK");
		itemBrandDTO.setLogoUrl("http://www.163.com/a.jpg");
		request.setParam("itemBrandDTO", itemBrandDTO);
		request.setCommand(ActionEnum.ADD_ITEMBRAND.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");

	}
}
