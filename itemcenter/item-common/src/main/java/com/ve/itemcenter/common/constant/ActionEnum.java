package com.ve.itemcenter.common.constant;

public enum ActionEnum {

	/**
	 * ----商品相关---------------------------------------
	 */

	// 增加商品
	ADD_ITEM("addItemAction"),

	// 更新商品
	UPDATE_ITEM("updateItemAction"),

	// 查看商品
	GET_ITEM("getItemAction"),

	// 删除商品
	DELETE_ITEM("deleteItemAction"),

	// 商品列表查询
	QUERY_ITEM("queryItemAction"),

	// 增加商品扩展信息
	ADD_ITEM_EXTRA_INFO("addItemExtraInfoAction"),

	// 更新商品扩展信息
	UPDATE_ITEM_EXTRA_INFO("updateItemExtraInfoAction"),

	// 查看商品扩展信息
	GET_ITEM_EXTRA_INFO("getItemExtraInfoAction"),

	// 删除商品扩展信息
	DELETE_ITEM_EXTRA_INFO("deleteItemExtraInfoAction"),

	// 商品列表查询扩展信息
	QUERY_ITEM_EXTRA_INFO("queryItemExtraInfoAction"),

	// 将商品移入回收站
	REMOVE_ITEM("removeItemAction"),

	// 增加商品图片
	ADD_ITEM_IMAGE("addItemImageAction"),

	// 查看商品图片
	GET_ITEM_IMAGE("getItemImageAction"),

	// 根据商品ID删除商品图片
	DELETE_ITEM_IMAGE_BY_ITEMID("deleteItemImageByItemIdAction"),

	// 删除商品图片
	DELETE_ITEM_IMAGELIST("deleteItemImageListAction"),

	// 查询商品图片列表
	QUERY_ITEM_IMAGE("queryItemImageTmplAction"),

	// 增加商品品牌
	ADD_ITEMBRAND("addItemBrandAction"),

	// 更新商品品牌
	UPDATE_ITEMBRAND("updateItemBrandAction"),

	// 查看商品品牌
	GET_ITEMBRAND("getItemBrandAction"),

	// 删除商品品牌
	DELETE_ITEMBRAND("deleteItemBrandAction"),

	// 商品品牌列表查询
	QUERY_ITEMBRAND("queryItemBrandAction"),

	// 增加商品评论
	ADD_ITEMCOMMENT("addItemCommentAction"),

	// 删除商品评论
	DELETE_ITEMCOMMENT("deleteItemCommentAction"),

	// 根据商品ID查询所有评论
	QUERY_ITEMCOMMENT("queryItemCommentAction"),

	// 增加商品属性模板
	ADD_ITEM_PROPERTY_TMPL("addItemPropertyTmplAction"),

	// 修改商品属性模板
	UPDATE_ITEM_PROPERTY_TMPL("updateItemPropertyTmplAction"),

	// 删除商品属性模板
	DELETE_ITEM_PROPERTY_TMPL("deleteItemPropertyTmplAction"),

	// 查看商品属性模板
	GET_ITEM_PROPERTY_TMPL("getItemPropertyTmplAction"),

	// 查询商品属性模板列表
	QUERY_ITEM_PROPERTY_TMPL("queryItemPropertyTmplAction"),

	// 增加商品属性
	ADD_ITEM_PROPERTY("addItemPropertyAction"),

	// 修改商品属性
	UPDATE_ITEM_PROPERTY("updateItemPropertyAction"),

	// 删除商品属性模板
	DELETE_ITEM_PROPERTY("deleteItemPropertyAction"),

	// 查看商品属性模板
	GET_ITEM_PROPERTY("getItemPropertyAction"),

	// 查询商品属性列表
	QUERY_ITEM_PROPERTY("queryItemPropertyAction"),

	// 增加商品类目
	ADD_ITEM_CATEGORY("addItemCategoryAction"),

	// 修改商品类目
	UPDATE_ITEM_CATEGORY("updateItemCategoryAction"),

	// 删除商品类目
	DELETE_ITEM_CATEGORY("deleteItemCategoryAction"),

	// 查看商品类目
	GET_ITEM_CATEGORY("getItemCategoryAction"),

	// 查询商品类目
	QUERY_ITEM_CATEGORY("queryItemCategoryAction"),

	/**
	 * ----商品相关--------------------------------------
	 */

	/**
	 * ----专场相关--------------------------------------
	 */

	// 增加专场
	ADD_SALES_FIELD("addSalesFieldItemAction"),

	// 更新专场
	UPDATE_SALES_FIELD("updateSalesFieldAction"),

	// 查看专场
	GET_SALES_FIELD("getSalesFieldAction"),

	// 删除专场
	DELETE_SALES_FIELD("deleteSalesFieldAction"),

	// 专场列表查询
	QUERY_SALES_FIELD("querySalesFieldAction"),

	/**
	 * ----专场相关--------------------------------------
	 */

	/**
	 * ----SKU相关--------------------------------------
	 */

	// 增加SKU属性模板
	ADD_SKU_PROPERTY_TMPL("addSkuPropertyTmplAction"),

	// 修改SKU属性模板
	UPDATE_SKU_PROPERTY_TMPL("updateSkuPropertyTmplAction"),

	// 删除SKU属性模板
	DELETE_SKU_PROPERTY_TMPL("deleteSkuPropertyTmplAction"),

	// 查看SKU属性模板
	GET_SKU_PROPERTY_TMPL("getSkuPropertyTmplAction"),

	// 查询SKU模板列表
	QUERY_SKU_PROPERTY_TMPL("querySkuPropertyTmplAction"),

	// 增加SKU属性
	ADD_SKU_PROPERTY("addSkuPropertyAction"),

	// 修改SKU属性
	UPDATE_SKU_PROPERTY("updateSkuPropertyAction"),

	// 删除SKU属性
	DELETE_SKU_PROPERTY("deleteSkuPropertyAction"),

	// 查看SKU属性
	GET_SKU_PROPERTY("getSkuPropertyAction"),

	// 查询SKU
	QUERY_SKU_PROPERTY("querySkuPropertyAction"),

	// 增加商品销售属性(ItemSku)
	ADD_ITEM_SKU("addItemSkuAction"),

	// 修改商品销售属性(ItemSku)
	UPDATE_ITEM_SKU("updateItemSkuAction"),

	// 删除商品销售属性(ItemSku)
	DELETE_ITEM_SKU("deleteItemSkuAction"),

	// 查看商品销售属性(ItemSku)
	GET_ITEM_SKU("getItemSkuAction"),

	// 查询商品销售属性(ItemSku)
	QUERY_ITEM_SKU("queryItemSkuAction"),

	// 增加SKU库存
	INCREASE_ITEM_SKU_STOCK("increaseItemSkuStockAction"),

	// 减少SKU库存
	DECREASE_ITEM_SKU_STOCK("decreaseItemSkuStockAction"),

	/**
	 * ----SKU相关--------------------------------------
	 */

	/**
	 * ----SPU相关--------------------------------------
	 */

	// 增加SPU属性模板
	ADD_SPU_PROPERTY_TMPL("addSpuPropertyTmplAction"),

	// 修改SPU属性模板
	UPDATE_SPU_PROPERTY_TMPL("updateSpuPropertyTmplAction"),

	// 删除SPU属性模板
	DELETE_SPU_PROPERTY_TMPL("deleteSpuPropertyTmplAction"),

	// 查看SPU属性模板
	GET_SPU_PROPERTY_TMPL("getSpuPropertyTmplAction"),

	// 查询SPU模板列表
	QUERY_SPU_PROPERTY_TMPL("querySpuPropertyTmplAction"),

	// 增加SPU属性
	ADD_SPU_PROPERTY("addSpuPropertyAction"),

	// 修改SPU属性
	UPDATE_SPU_PROPERTY("updateSpuPropertyAction"),

	// 删除SPU属性
	DELETE_SPU_PROPERTY("deleteSpuPropertyAction"),

	// 查看SPU属性
	GET_SPU_PROPERTY("getSpuPropertyAction"),

	// 查询SPU属性
	QUERY_SPU_PROPERTY("querySpuPropertyAction"),

	// 增加SPU_Info信息
	ADD_SPU_INFO("addSpuInfoAction"),

	// 修改SPU_Info信息
	UPDATE_SPU_INFO("updateSpuInfoAction"),

	// 删除SPU_Info信息
	DELETE_SPU_INFO("deleteSpuInfoAction"),

	// 查看SPU_Info信息
	GET_SPU_INFO("getSpuInfoAction"),

	// 查询SPU_Info信息
	QUERY_SPU_INFO("querySpuInfoAction"),

	/**
	 * ----SPU相关--------------------------------------
	 */

	/**
	 * ----全局属性--------------------------------------
	 */
	// 增加全局属性
	ADD_GLOBAL_PROPERTY("addGlobalPropertyAction"),

	// 修改全局属性
	UPDATE_GLOBAL_PROPERTY("updateGlobalPropertyAction"),

	// 删除全局属性
	DELETE_GLOBAL_PROPERTY("deleteGlobalPropertyAction"),

	// 查看全局属性
	GET_GLOBAL_PROPERTY("getGlobalPropertyAction"),

	// 查询全局属性
	QUERY_GLOBAL_PROPERTY("queryGlobalPropertyAction"),

	// 增加全局属性值域
	ADD_GLOBAL_PROPERTY_VALUE("addGlobalPropertyValueAction"),

	// 修改全局属性值域
	UPDATE_GLOBAL_PROPERTY_VALUE("updateGlobalPropertyValueAction"),

	// 删除全局属性值域
	DELETE_GLOBAL_PROPERTY_VALUE("deleteGlobalPropertyValueAction"),

	// 查看全局属性值域
	GET_GLOBAL_PROPERTY_VALUE("getGlobalPropertyValueAction"),

	// 查询全局属性值域
	QUERY_GLOBAL_PROPERTY_VALUE("queryGlobalPropertyValueAction");
	/**
	 * ----全局属性--------------------------------------
	 */

	private String actionName;

	private ActionEnum(String actionName) {
		this.actionName = actionName;
	}

	public static ActionEnum getActionEnum(String actionName) {
		for (ActionEnum ae : ActionEnum.values()) {
			if (ae.actionName.equals(actionName)) {
				return ae;
			}
		}
		return null;
	}

	public String getActionName() {
		return actionName;
	}
}
