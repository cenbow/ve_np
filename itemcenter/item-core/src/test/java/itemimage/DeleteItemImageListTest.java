package itemimage;

import java.util.ArrayList;
import java.util.List;

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
import com.ve.itemcenter.common.domain.dto.ItemImageDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DeleteItemImageListTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正常删除
	 */
	public void test001() {
		Request request = new BaseRequest();
		List<ItemImageDTO> deletedImageDTOList = new ArrayList<ItemImageDTO>();

		ItemImageDTO itemImageDTO = new ItemImageDTO();
		itemImageDTO.setId(29L);
		itemImageDTO.setSupplierId(1L);

		ItemImageDTO itemImageDTO2 = new ItemImageDTO();
		itemImageDTO2.setId(30L);
		itemImageDTO2.setSupplierId(1L);

		deletedImageDTOList.add(itemImageDTO);
		deletedImageDTOList.add(itemImageDTO2);

		request.setParam("deletedImageDTOList", deletedImageDTOList);

		request.setCommand(ActionEnum.DELETE_ITEM_IMAGELIST.getActionName());
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
	 * deletedImageDTOList为空
	 */
	public void test002() {
		Request request = new BaseRequest();

		request.setCommand(ActionEnum.DELETE_ITEM_IMAGELIST.getActionName());
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
	 * deletedImageDTOList size为0
	 */
	public void test003() {
		Request request = new BaseRequest();
		List<ItemImageDTO> deletedImageDTOList = new ArrayList<ItemImageDTO>();
		request.setParam("deletedImageDTOList", deletedImageDTOList);
		request.setCommand(ActionEnum.DELETE_ITEM_IMAGELIST.getActionName());
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
	 * itemImage id 为空
	 */
	public void test004() {
		Request request = new BaseRequest();
		List<ItemImageDTO> deletedImageDTOList = new ArrayList<ItemImageDTO>();
		ItemImageDTO itemImageDTO = new ItemImageDTO();
		itemImageDTO.setSupplierId(1L);
		deletedImageDTOList.add(itemImageDTO);
		request.setParam("deletedImageDTOList", deletedImageDTOList);

		request.setCommand(ActionEnum.DELETE_ITEM_IMAGELIST.getActionName());
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
	 * 供应商Id为空
	 */
	public void test005() {
		Request request = new BaseRequest();
		List<ItemImageDTO> deletedImageDTOList = new ArrayList<ItemImageDTO>();
		ItemImageDTO itemImageDTO = new ItemImageDTO();
		itemImageDTO.setId(29L);
		deletedImageDTOList.add(itemImageDTO);
		request.setParam("deletedImageDTOList", deletedImageDTOList);
		request.setCommand(ActionEnum.DELETE_ITEM_IMAGELIST.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
