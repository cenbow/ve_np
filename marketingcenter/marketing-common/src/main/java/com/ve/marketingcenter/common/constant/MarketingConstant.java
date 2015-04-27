package com.ve.marketingcenter.common.constant;

public final class MarketingConstant {
	
	private MarketingConstant(){}
	
	/***********************0-是(成功,已,包含,需要) 1-否(失败，未,不包含,不需要)********************/
	public static final int GLOBAL_FLAG_YES = 0;
	public static final int GLOBAL_FLAG_NO = 1;
	
	
	/**************************创建者类型*************************/
	public static final int CREATOR_TYPE_SUPPLIER = 1;//供应商
	
	public static final int CREATOR_TYPE_BUSINESS_OPERATOR = 2;//运营
	
	
	/***********************平台环境默认PLATEFORM_PC | PLATEFORM_YD********************/
	//前台和数据库值的对应关系为 2的(n-1)次幂，n为前台枚举值
	public static long PLATEFORM_DB_PC = 1;//pc端(对应前台1)
	public static long PLATEFORM_DB_YD = 2;//移动端(对应前台2)//以此类推
	//public static long PLATEFORM_DB_QT = 4;//移动端(对应前台3)
	//public static long PLATEFORM_DB_QT_1 = 8;//移动端(对应前台4)
	
	/**************************活动状态**************************/
	public static final int ACT_STATUS_SAVED = 0;//初始状态
	public static final int ACT_STATUS_AUDITING = 1;//审核中
	public static final int ACT_STATUS_APPROVED = 2;//审核通过
	public static final int ACT_STATUS_DENIED = 3;//审核拒绝
	public static final int ACT_STATUS_INVALID = 4;//失效
	
	
	/**************************参数类型*************************/
	public static final int PARAM_OWNER_TYPE_TOOL = 1;//工具参数
	public static final int PARAM_OWNER_TYPE_ACT = 2;//活动参数
	public static final int PARAM_OWNER_TYPE_COM = 3;//组件参数
	
	/**************************参数类型*************************/
	public static final int AUDIT_TYPE_APPLY = 1;//申请
	public static final int AUDIT_TYPE_CHECK = 2;//审核
	
	/**************************活动范围*************************/
	public static final int ACTIVITY_SCOPE_ALL = 0;//所有商品
	public static final int ACTIVITY_SCOPE_SPC = 1;//专场商品
	public static final int ACTIVITY_SCOPE_SIG = 2;//单个商品
	
	/**************************活动对象*************************/
	public static final String MARKETING_ACTIVITY_TARGET = "TARGET";
	
	/************************组件实现方式************************/
	public static final int IMPL_TYPE_BEAN = 1;//javaBean方式
	public static final int IMPL_TYPE_XML = 2;//xml方式
	public static final int IMPL_TYPE_JSON = 3;//JSON方式
	public static final int IMPL_TYPE_PARAM = 4;//参数配置方式
	
	/**************************条件组件类型*************************/
	public static final String CONDITION_COM_TYPE_GE = "GE";//大于等于
	public static final String CONDITION_COM_TYPE_FROM = "FROM";//来自
	public static final String CONDITION_COM_TYPE_MIX = "MIX";//混搭
	public static final String CONDITION_COM_TYPE_GB = "GB";//团购
	public static final String CONDITION_COM_TYPE_INTEGRAL = "INTEGRAL";//积分
	
	/**************************动作组件类型*************************/
	public static final String ACTIVITY_COM_TYPE_NO_POSTAGE = "NO_POSTAGE";//免邮费
	public static final String ACTIVITY_COM_TYPE_DISCOUNT = "DISCOUNT";//折扣
	public static final String ACTIVITY_COM_TYPE_SUBSTRACT = "SUBSTRACT";//减
	public static final String ACTIVITY_COM_TYPE_PRESENT = "PRESENT";//赠
	
//	/**************************活动参数*************************/
//	public static final String ACT_PARAM_TOOL = "TOOL";//工具参数
//	public static final String ACT_PARAM_SCOPE = "SCOPE";//范围参数
	
//	/**************************活动范围类型*************************/
//	public static final String ACT_SCOPE_PARAM_IN = "INCLUDE";//包含
//	public static final String ACT_SCOPE_PARAM_EX = "EXCLUDE";//不包含
//	
//	/**************************活动范围Key*************************/
//	public static final String ACT_PARAM_ALL = "ALL";//全场
//	public static final String ACT_PARAM_SPECIAL = "SPECIAL";//专场
//	public static final String ACT_PARAM_ITEM = "ITEM";//单品
	
	/****************************用户级别************************/
	/**
	 * 所有用户
	 */
	public static final String USER_TYPE_ALL = "ALL";
	
	/**
	 * A、未知新客 - 不清楚客户具体身份的群体
	 */
	//全新用户
	//PC/H5用户： 用户第一次来，没有cookie值。
	//Android用户：当前设备第一次来，macid不在macid库中。
	//IOS用户：第一次安装APP，本地唯一ID不存在， 唯一ID不在库中
	public static final String USER_TYPE_A1 = "A1";
	
	//全新用户(未注册、登录)
	//PC/H5用户： 用户非第一次来，有cookie值。
	//Android用户： 设备非第一次来，macid存在macid库中。 
	//IOS用户： 本地唯一ID存在，唯一ID在库中。
	public static final String USER_TYPE_A2 = "A2";
	
	/**
	 * B、已知新客 - 有注册帐号的客户、已注册帐号，但没有购买
	 */
	//B1 ： 新用户(在PC端注册)
	public static final String USER_TYPE_B1 = "B1";
	//B2 ：新用户(在移动端注册)
	public static final String USER_TYPE_B2 = "B2";

	/**
	 * C、已知老客 - 曾经购买过商品的客户
	 */
	//C1 ：老用户(只在网站下过单)
	public static final String USER_TYPE_C1 = "C1";
	//C2 ：老用户(只在移动端下过单)
	public static final String USER_TYPE_C2 = "C2";
	//C3 ：老用户(网站/移动同时下过单)
	public static final String USER_TYPE_C3 = "C3";
	
	
	public static final String REQUEST_PARAM_KEY_ENTITY = "PARAM_ENTITY";
	
	public static final String REQUEST_PARAM_PRIMARY_KEY = "PARAM_PRIMARY_KEY";
	
//	public static final String REQUEST_PARAM_OWNER_TYPE = "PARAM_OWNER_TYPE";
	
	public static final String REQUEST_PARAM_USER_ID = "PARAM_USER_ID";
	
	public static final String REQUEST_PARAM_ITEM_LIST = "PARAM_ITEM_LIST";
	
	public static final String REQUEST_PARAM_COUPON_LIST = "PARAM_COUPON_LIST";
	
	public static final String REQUEST_PARAM_PLATFORM = "PARAM_PLATFORM";
	
	public static final String REQUEST_PARAM_USER_TYPE = "PARAM_USER_TYPE";
	
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	
	
	
	
	/***********************组件类型****************************/
	public static final short MODULE_TYPE_RUL = 1;//条件组件
	public static final short MODULE_TYPE_ACT = 2;//动作组件
	public static final short MODULE_TYPE_RES = 3;//资源组件
	
	

	
	
	/**************************工具状态**************************/
	public static final short TOOL_STATUS_SAVED = 1;//保存
	public static final short TOOL_STATUS_AUDITING = 2;//待审核
	public static final short TOOL_STATUS_POSITIVE = 3;//审核通过
	public static final short TOOL_STATUS_DISABLED = 4;//不可用
	
//
//	/****************************营销级别***********************/
//	public static final short ACTIVITY_LEVEL_PRODUCT = 1;//商品级
//	public static final short ACTIVITY_LEVEL_ORDER = 2;//订单级
//	public static final short ACTIVITY_LEVEL_STORE = 3;//店铺级
//	public static final short ACTIVITY_LEVEL_SPECIAL = 4;//专场级
	
}
