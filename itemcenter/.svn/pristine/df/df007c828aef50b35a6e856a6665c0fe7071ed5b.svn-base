package item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.ve.itemcenter.common.api.BaseRequest;
import com.ve.itemcenter.common.api.ItemService;
import com.ve.itemcenter.common.api.Request;
import com.ve.itemcenter.common.api.Response;
import com.ve.itemcenter.common.constant.ActionEnum;
import com.ve.itemcenter.common.domain.dto.ItemDTO;
import com.ve.itemcenter.common.domain.dto.ItemImageDTO;
import com.ve.itemcenter.common.domain.dto.ItemSkuDTO;
import com.ve.itemcenter.common.domain.dto.SkuPropertyDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddItemTest {
	@Resource
	private ItemService itemService;

	@Test
	/**
	 * 正常插入
	 */
	public void test001() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setItemBrandId(1);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(1);
		itemDTO.setIsSellerPost(1);

		List<ItemSkuDTO> retItemSkuDTOList = new ArrayList<ItemSkuDTO>();
		ItemSkuDTO itemSkuDTO = new ItemSkuDTO();
		itemSkuDTO.setMaterialCode("aa");
		itemSkuDTO.setBarCode("a");
		itemSkuDTO.setMarketPrice(100);
		itemSkuDTO.setPromotionPrice(90);
		itemSkuDTO.setWirelessPrice(80);
		itemSkuDTO.setStockNum(1000L);
		itemSkuDTO.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO1 = new SkuPropertyDTO();
		skuPropertyDTO1.setKeyName("尺寸");
		skuPropertyDTO1.setSort(1);
		skuPropertyDTO1.setVal("16码");
		skuPropertyDTO1.setValType(1);

		SkuPropertyDTO skuPropertyDTO2 = new SkuPropertyDTO();
		skuPropertyDTO2.setKeyName("颜色");
		skuPropertyDTO2.setSort(2);
		skuPropertyDTO2.setVal("红色");
		skuPropertyDTO2.setValType(1);

		List<SkuPropertyDTO> skuPropertyDTOList = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList.add(skuPropertyDTO1);
		skuPropertyDTOList.add(skuPropertyDTO2);
		itemSkuDTO.setSkuPropertyDTOList(skuPropertyDTOList);

		ItemSkuDTO itemSkuDTO2 = new ItemSkuDTO();
		itemSkuDTO2.setMaterialCode("bb");
		itemSkuDTO2.setBarCode("b");
		itemSkuDTO2.setMarketPrice(100);
		itemSkuDTO2.setPromotionPrice(90);
		itemSkuDTO2.setWirelessPrice(80);
		itemSkuDTO2.setStockNum(1000L);
		itemSkuDTO2.setSoldNum(1L);

		SkuPropertyDTO skuPropertyDTO3 = new SkuPropertyDTO();
		skuPropertyDTO3.setKeyName("尺寸");
		skuPropertyDTO3.setSort(2);
		skuPropertyDTO3.setVal("17码");
		skuPropertyDTO3.setValType(1);

		SkuPropertyDTO skuPropertyDTO4 = new SkuPropertyDTO();
		skuPropertyDTO4.setKeyName("颜色");
		skuPropertyDTO4.setSort(1);
		skuPropertyDTO4.setVal("蓝色");
		skuPropertyDTO4.setValType(1);

		List<SkuPropertyDTO> skuPropertyDTOList2 = new ArrayList<SkuPropertyDTO>();
		skuPropertyDTOList2.add(skuPropertyDTO3);
		skuPropertyDTOList2.add(skuPropertyDTO4);
		itemSkuDTO2.setSkuPropertyDTOList(skuPropertyDTOList2);

		retItemSkuDTOList.add(itemSkuDTO);
		retItemSkuDTOList.add(itemSkuDTO2);

		itemDTO.setItemSkuDTOList(retItemSkuDTOList);

		ItemImageDTO itemImageDTO = new ItemImageDTO();
		itemImageDTO.setImageName("测试狗11");
		itemImageDTO.setImageType(2);
		itemImageDTO.setImgUrl("http://www.163.com/a.jpeg");

		ItemImageDTO itemImageDTO2 = new ItemImageDTO();
		itemImageDTO2.setImageName("测试狗22");
		itemImageDTO2.setImageType(2);
		itemImageDTO2.setImgUrl("http://www.163.com/a.jpeg");
		List<ItemImageDTO> itemImageDTOList = new ArrayList<ItemImageDTO>();
		itemImageDTOList.add(itemImageDTO);
		itemImageDTOList.add(itemImageDTO2);

		itemDTO.setItemImageDTOList(itemImageDTOList);

		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 商品名为空
	 */
	public void test003() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setItemBrandId(1);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(1);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 商品简称为空
	 */
	public void test004() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBrandId(1);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(1);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 商品类型为空
	 */
	public void test005() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBrandId(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(1);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 主图图片地址为空
	 */
	public void test006() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setItemBrandId(1);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setCategoryId(1);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 类目ID为空
	 */
	public void test007() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setItemBrandId(1);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	public void test008() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setItemBrandId(1);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(1);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 类目ID在数据库不存在
	 */
	public void test009() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setItemBrandId(1);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(9999);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 品牌ID在数据库不存在
	 */
	public void test010() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setItemBrandId(9999);
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(1);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
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
	 * 品牌ID为空
	 */
	public void test011() {
		Request request = new BaseRequest();
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemName("婴儿毛巾444");
		itemDTO.setSupplierId(1L);
		itemDTO.setItemBriefName("商品简称");
		itemDTO.setBriefIntroduction("商品简介");
		itemDTO.setItemType(1);
		itemDTO.setIconUrl("http://www.163.com/e.jpeg");
		itemDTO.setCategoryId(1);
		request.setParam("itemDTO", itemDTO);
		request.setCommand(ActionEnum.ADD_ITEM.getActionName());
		Response response = itemService.execute(request);
		System.out.println("**************************************");
		System.out.println("Model:" + response.getModule());
		System.out.println("message:" + response.getMessage());
		System.out.println("ErrorCode:" + response.getErrorCode());
		System.out.println("TotalCount:" + response.getTotalCount());
		System.out.println("**************************************");
	}
}
