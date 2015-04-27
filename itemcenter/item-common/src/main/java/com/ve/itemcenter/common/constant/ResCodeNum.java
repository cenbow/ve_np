package com.ve.itemcenter.common.constant;

public enum ResCodeNum {
	
	SUCCESS("200","系统调用成功"),
	
	/**
	 *系统异常 
	 */
	
    SYS_E_DEFAULT_ERROR("S1001","系统开小差中，请稍后再试"),
    SYS_E_SERVICE_EXCEPTION("S1002","服务端异常"),
    SYS_E_SERVICE_UNAVAIABLE("S1003","服务端不可用"),
    SYS_E_SERVICE_TIMEOUT("S1004","服务端超时"),
    SYS_E_DB_DELETE("S2001","数据库删除异常"),
    SYS_E_DB_UPDATE("S2002","数据库更新异常"),
    
    /**
	 *参数异常 
	 */
    PARAM_E_INVALID("P2001","参数不正确"),
    PARAM_E_MISSING("P2002","缺少参数"),
    
    /**
	 *业务异常 
	 */
    BASE_PARAM_E_RECORD_NOT_EXIST("B2003","请求的记录不存在"),
    BASE_STATE_E_NO_LOGIN("B2101","没有登录或登录已超时，请重新登录"),
    BASE_STATE_E_NO_PERMISSION("B2102","没有权限"),
    BASE_STATE_E_ACTION_NO_EXIST("B2103","访问的接口不存在"),
    BASE_STATE_E_REQUEST_FORBBIDEN("B2104","请求被禁止"),
    BASE_STATE_E_USER_NO_EXIST("B2105","用户不存在"),
    BASE_STATE_E_STOCK_INSUFFICIENT("B2106","库存不足"),
    BASE_STATE_E_NOT_ALLOW_CATEGORY_DELETED("B2107","不允许删除子类目");
    
    
    private String code;
    private String comment;
    private ResCodeNum(String p_code, String p_comment){
		this.code = p_code;
        this.comment = p_comment;
    }

    public String getCode() {
        return this.code;
    }

    public String getComment() {
        return comment;
    }

}
