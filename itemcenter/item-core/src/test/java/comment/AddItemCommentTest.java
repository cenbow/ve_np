package comment;

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
import com.ve.itemcenter.common.domain.dto.ItemCommentDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddItemCommentTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正确添加评论
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemCommentDTO itemCommentDTO = new ItemCommentDTO();
		itemCommentDTO.setUserId(1L);
		itemCommentDTO.setUserName("hu6");
		itemCommentDTO.setItemId(999L);
		itemCommentDTO.setOrderId(3L);
		itemCommentDTO.setSellerId(4L);
		itemCommentDTO.setContent("aaaaaaa");
		request.setParam("itemCommentDTO", itemCommentDTO);
		request.setCommand(ActionEnum.ADD_ITEMCOMMENT.getActionName());
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
	 * ItemCommentDTO 为空
	 */
	public void test002() {
		Request request = new BaseRequest();
		request.setCommand(ActionEnum.ADD_ITEMCOMMENT.getActionName());
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
	 * 评论内容为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		ItemCommentDTO itemCommentDTO = new ItemCommentDTO();
		itemCommentDTO.setUserId(1L);
		itemCommentDTO.setUserName("hu6");
		itemCommentDTO.setItemId(999L);
		itemCommentDTO.setOrderId(3L);
		itemCommentDTO.setSellerId(4L);
		request.setParam("itemCommentDTO", itemCommentDTO);
		request.setCommand(ActionEnum.ADD_ITEMCOMMENT.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}

}
