package spupropertytmpl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.itemcenter.common.api.BaseRequest;
import com.ve.itemcenter.common.api.ItemService;
import com.ve.itemcenter.common.api.Request;
import com.ve.itemcenter.common.api.Response;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.domain.dto.SpuPropertyTmplDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddSpuPropertyTmplTest {
	@Resource
	private ItemService itemService;

	@Test
	public void test() {
		Request request = new BaseRequest();
		SpuPropertyTmplDTO spuPropertyTmplDTO = new SpuPropertyTmplDTO();
		spuPropertyTmplDTO.setOwnerType(1);
		spuPropertyTmplDTO.setOwnerType(0);
		spuPropertyTmplDTO.setKeyName("颜色");
		spuPropertyTmplDTO.setVal("玫瑰色");
		spuPropertyTmplDTO.setValType(1);
		spuPropertyTmplDTO.setCategoryId(1);
		request.setParam("spuPropertyTmplDTO", spuPropertyTmplDTO);
		request.setCommand(ActionEnum.ADD_SPU_PROPERTY_TMPL.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
