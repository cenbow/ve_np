package itemsku;

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
import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddItemSkuTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正常插入
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		itemSkuDTO.setItemId(2L);
		itemSkuDTO.setMaterialCode("aaaaa");
		itemSkuDTO.setBarCode("xxxxx");
		itemSkuDTO.setSellerId(1L);
		itemSkuDTO.setMarketPrice(100);
		itemSkuDTO.setPromotionPrice(90);
		itemSkuDTO.setWirelessPrice(80);
		itemSkuDTO.setStockNum(1000L);
		itemSkuDTO.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO1 = new SkuPropertyDTO();
		skuPropertyDTO1.setKeyName("重量");
		skuPropertyDTO1.setSellerId(1L);
		skuPropertyDTO1.setSort(2);
		skuPropertyDTO1.setVal("99kg");
		skuPropertyDTO1.setValType(1);

		SkuPropertyDTO skuPropertyDTO2 = new SkuPropertyDTO();
		skuPropertyDTO2.setKeyName("尺寸");
		skuPropertyDTO2.setSellerId(1L);
		skuPropertyDTO2.setSort(3);
		skuPropertyDTO2.setVal("XXL");
		skuPropertyDTO2.setValType(1);

		SkuPropertyDTO skuPropertyDTO3 = new SkuPropertyDTO();
		skuPropertyDTO3.setKeyName("颜色");
		skuPropertyDTO3.setSellerId(1L);
		skuPropertyDTO3.setSort(1);
		skuPropertyDTO3.setVal("水蓝色");
		skuPropertyDTO3.setValType(1);

		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList.add(skuPropertyDTO1);
		skuPropertyDTOList.add(skuPropertyDTO2);
		skuPropertyDTOList.add(skuPropertyDTO3);

		request.setParam("itemSkuDTO", itemSkuDTO);
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);

		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
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
	 * skuPropertyDTOList为null
	 */
	public void test002() {
		Request request = new BaseRequest();
		ItemSkuDTO itemSkuDTO = null;
		List<SkuPropertyDTO> skuPropertyDTOList = null;
		request.setParam("itemSkuDTO", itemSkuDTO);
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);
		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
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
	 * itemSkuDTO为null
	 */
	public void test003() {
		Request request = new BaseRequest();
		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);
		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
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
	 * MaterialCode is null
	 */
	public void test004() {
		Request request = new BaseRequest();
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		itemSkuDTO.setItemId(2L);
		itemSkuDTO.setBarCode("xxxxx");
		itemSkuDTO.setSellerId(1L);
		itemSkuDTO.setMarketPrice(100);
		itemSkuDTO.setPromotionPrice(90);
		itemSkuDTO.setWirelessPrice(80);
		itemSkuDTO.setStockNum(1000L);
		itemSkuDTO.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO1 = new SkuPropertyDTO();
		skuPropertyDTO1.setKeyName("重量");
		skuPropertyDTO1.setSellerId(1L);
		skuPropertyDTO1.setSort(2);
		skuPropertyDTO1.setVal("99kg");
		skuPropertyDTO1.setValType(1);


		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList.add(skuPropertyDTO1);

		request.setParam("itemSkuDTO", itemSkuDTO);
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);

		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
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
	 * BarCode is null
	 */
	public void test005() {
		Request request = new BaseRequest();
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		itemSkuDTO.setItemId(2L);
		itemSkuDTO.setMaterialCode("aaaxxxxx");
		itemSkuDTO.setSellerId(1L);
		itemSkuDTO.setMarketPrice(100);
		itemSkuDTO.setPromotionPrice(90);
		itemSkuDTO.setWirelessPrice(80);
		itemSkuDTO.setStockNum(1000L);
		itemSkuDTO.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO1 = new SkuPropertyDTO();
		skuPropertyDTO1.setKeyName("重量");
		skuPropertyDTO1.setSellerId(1L);
		skuPropertyDTO1.setSort(2);
		skuPropertyDTO1.setVal("99kg");
		skuPropertyDTO1.setValType(1);


		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList.add(skuPropertyDTO1);

		request.setParam("itemSkuDTO", itemSkuDTO);
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);

		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
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
	 * sellerId is null
	 */
	public void test006() {
		Request request = new BaseRequest();
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		itemSkuDTO.setItemId(2L);
		itemSkuDTO.setBarCode("b");
		itemSkuDTO.setMaterialCode("aaaxxxxx");
		itemSkuDTO.setMarketPrice(100);
		itemSkuDTO.setPromotionPrice(90);
		itemSkuDTO.setWirelessPrice(80);
		itemSkuDTO.setStockNum(1000L);
		itemSkuDTO.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO1 = new SkuPropertyDTO();
		skuPropertyDTO1.setKeyName("重量");
		skuPropertyDTO1.setSellerId(1L);
		skuPropertyDTO1.setSort(2);
		skuPropertyDTO1.setVal("99kg");
		skuPropertyDTO1.setValType(1);


		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList.add(skuPropertyDTO1);

		request.setParam("itemSkuDTO", itemSkuDTO);
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);

		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
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
	 * itemId is null
	 */
	public void test007() {
		Request request = new BaseRequest();
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		itemSkuDTO.setBarCode("b");
		itemSkuDTO.setSellerId(1L);
		itemSkuDTO.setMaterialCode("aaaxxxxx");
		itemSkuDTO.setMarketPrice(100);
		itemSkuDTO.setPromotionPrice(90);
		itemSkuDTO.setWirelessPrice(80);
		itemSkuDTO.setStockNum(1000L);
		itemSkuDTO.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO1 = new SkuPropertyDTO();
		skuPropertyDTO1.setKeyName("重量");
		skuPropertyDTO1.setSellerId(1L);
		skuPropertyDTO1.setSort(2);
		skuPropertyDTO1.setVal("99kg");
		skuPropertyDTO1.setValType(1);


		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList.add(skuPropertyDTO1);

		request.setParam("itemSkuDTO", itemSkuDTO);
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);

		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
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
	public void test008() {
		Request request = new BaseRequest();
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		itemSkuDTO.setBarCode("b");
		itemSkuDTO.setItemId(999999L);
		itemSkuDTO.setSellerId(1L);
		itemSkuDTO.setMaterialCode("aaaxxxxx");
		itemSkuDTO.setMarketPrice(100);
		itemSkuDTO.setPromotionPrice(90);
		itemSkuDTO.setWirelessPrice(80);
		itemSkuDTO.setStockNum(1000L);
		itemSkuDTO.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO1 = new SkuPropertyDTO();
		skuPropertyDTO1.setKeyName("重量");
		skuPropertyDTO1.setSellerId(1L);
		skuPropertyDTO1.setSort(2);
		skuPropertyDTO1.setVal("99kg");
		skuPropertyDTO1.setValType(1);


		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList.add(skuPropertyDTO1);

		request.setParam("itemSkuDTO", itemSkuDTO);
		request.setParam("skuPropertyDTOList", skuPropertyDTOList);

		request.setCommand(ActionEnum.ADD_ITEM_SKU.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
