package com.ve.marketingcenter.common.constant;

public enum ActionEnum {
	/************************************ 优惠券相关操作接口 ********************************************/
	/**
	 * 关联营销活动
	 */
	RELATE_ORDER_ACTIVITY("RelateOrderActivity"),
	/**
	 * 取消关联营销活动
	 */
	CANCEL_ORDER_ACTIVITY("CancelOrderActivity"),
	/**
	 * 使用营销活动
	 */
	USE_ORDER_ACTIVITY("UseOrderActivity"),
	/**
	 * 激活营销活动券
	 */
	ACTIVATE_COUPON("ActivateCoupon"),
	/**
	 * 查询用户的营销活动券
	 */
	QUERY_USER_COUPON("QueryUserCoupon"),
	/**
	 * 生成营销活动优惠券
	 */
	GENERATE_ACTIVITY_COUPON("GenerateActivityCoupon"),
	/**
	 * 发放(领用)营销活动优惠券
	 */
	GRANT_ACTIVITY_COUPON("GrantActivityCoupon"),
	/**
	 * 查询活动包含的营销活动券
	 */
	QUERY_ACTIVITY_COUPON("QueryActivityCoupon"),

	ACTIVITY_ADD("addActivityAction"), // 新增营销活动
	ACTIVITY_UPDATE("updateActivityAction"), // 修改营销活动
	ACTIVITY_DELETE("deleteActivityAction"), // 删除营销活动(逻辑删除)
	ACTIVITY_QUERY("queryActivityAction"), // 查询
	ACTIVITY_GET("getActivityAction"), // 查询
	ACTIVITY_SUBMIT_AUDTING("auditingActivityAction"), // 提交审核活动
	ACTIVITY_AUDIT_APPROVED("approvedActivityAction"), // 审核通过
	ACTIVITY_AUDIT_DENIED("deniedActivityAction"), // 审核未通过
	ACTIVITY_CANCEL("cancelActivityAction"), // 取消活动
	ACTIVITY_QUERY_FORMAL_PARAM("queryToolFormalParamAction"), // 查询工具形参

	TOOL_ADD("addToolAction"), TOOL_DELETE("deleteToolAction"), TOOL_UPDATE(
			"updateToolAction"), TOOL_QUERY("queryToolAction"), TOOL_GET(
			"getToolAction"),

	COMPUTE_CART_FAVORABLE("computeCartFavorable"), // 购物车阶段优惠
	COMPUTE_ORDER_FAVORABLE("computeOrderFavorable"), // 结算阶段优惠
	;

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
