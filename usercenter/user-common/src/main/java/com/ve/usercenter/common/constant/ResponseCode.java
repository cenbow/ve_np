package com.ve.usercenter.common.constant;

public enum ResponseCode {
	/**
	 * 请求成功
	 * */
	REQUEST_SUCCESS("200", "request success"),

	/**
	 * 系统异常
	 * */
	SYS_E_SERVICE_EXCEPTION("S001", "system exception"),

	/*********** 参数错误 ************/
	// NAME_LENGTH_ERROR("P001","用户名长度错误"),
	// PWD_FORMAT_ERROR("P002","密码的长度必须为8-20,并且由字母，数字和下划线组成"),
	// EMAIL_FORMAT_ERROR("P003","邮箱格式错误"),
	// MOBILE_FORMAT_ERROR("P004","手机格式错误"),
	// NAME_AND_PWD_IS_NULL("P005","用户名或密码为空"),
	// NAME_ALREADY_REG("P006","用户名已经被注册"),
	// EMAIL_ALREADY_REG("P007","邮箱已经被注册"),
	// MOBILE_ALREADY_REG("P008","号码已经被注册"),
	// USER_NOT_EXIST("P009","用户不存在"),
	// PARAM_E_PARAM_INVALID("P010","参数错误"),
	// USRE_ID_IS_NULL("P011","用户id为空"),
	P_PARAM_ERROR("P001", "param error"), P_PARAM_NULL("P002", "param null"),

	/********* 业务错误 ***********/
	// B_OLDPWD_NEWPWD_IS_SAME("B001","新老密码相同"),
	// B_PWD_IS_ERROR("B002","密码错误"),
	// B_RECORD_IS_EXIST("B003","记录已存在,重复添加记录"),
	// B_RECORD_IS_NOT_EXIST("B004","不存在指定的记录，不能修改");
	B_ADD_ERROR("B001", "add error"), B_UPDATE_ERROR("B002", "update error"), B_DELETE_ERROR(
			"B003", "delete error"), B_SELECT_ERROR("B004", "select error"),
	/**
	 * 访问的接口不存在
	 * */
	B_ACTION_NO_EXIST("B005", "action no exist"),
	/**
	 * 请求被禁用
	 * */
	B_REQUEST_FORBBIDEN("B006", "request forbbiden"),
	/**
	 * 邮箱已存在
	 */
	B_EMAIL_IS_EXIST("B1007", "email is exist"),
	/**
	 * 手机号 已存在
	 */
	B_MOBILE_IS_EXIST("B1008", "mobile is exist"),
	/**
	 * 原密码错误
	 */
	B_OLDPWD_ERROR("B1009", "old password is error"),

	/**
	 * 账号不存在
	 */
	B_ACCOUNT_NOT_EXIST("B1010", "account not exist"),

	/**
	 * 密码错误
	 */
	B_PASSWORD_ERROR("B1011", "password error");

	private String code;
	private String message;

	private ResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
