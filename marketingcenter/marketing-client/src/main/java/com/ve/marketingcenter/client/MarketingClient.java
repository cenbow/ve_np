package com.ve.marketingcenter.client;

import java.util.List;

import com.ve.marketingcenter.common.api.Response;
import com.ve.marketingcenter.common.domain.dto.FavorableInfo;
import com.ve.marketingcenter.common.domain.dto.MarketingActivityDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingFormalParamDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingItemDTO;
import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;
import com.ve.marketingcenter.common.domain.dto.coupon.ActivityCouponDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingActivityQTO;
import com.ve.marketingcenter.common.domain.qto.MarketingToolQTO;

public interface MarketingClient {
	/*******************营销活动优惠信息*******************/
	/**
	 * 购物车优惠信息查询
	 * @param userId
	 * @param items
	 * @param plateform
	 * @return
	 */
	public List<FavorableInfo> getCartFavorableInfo(Long userId,String userType, List <MarketingItemDTO> items, Integer plateform);
	
	/**
	 * 订单优惠信息查询
	 * @param userId
	 * @param items
	 * @param plateform
	 * @param coupons
	 * @return
	 */
	public List<FavorableInfo> getOrderFavorableInfo(Long userId,String userType, List <MarketingItemDTO> items, Integer plateform,List<ActivityCouponDTO> coupons);
	
	/*******************营销组件管理(先不提供接口)*******************/
	/**
	 *注册营销组件
	 * @param dto
	 * @return
	 */
//	Response<MarketingComDto> registerComponent(MarketingComDto dto);
	
	/**
	 *	删除营销组件
	 * @param componentId
	 * @param deleteUserId
	 * @return
	 */
//	Response<MarketingComDto> deleteComponent(long componentId,long deleteUserId);
	
	/**
	 * 	查询营销组件(分页)
	 * @param qto
	 * @return
	 */
//	Response< MarketingComQto > findAndPage(MarketingComQto qto);
	
	
	/**
	 * 修改营销组件
	 * @param dto
	 * @return
	 */
//	Response<MarketingComDto> modifyComponent(MarketingComDto dto);
	
	/*******************营销工具管理*******************/
	/**
	 * 组装工具
	 * @param dto
	 * @return
	 */
	Response<MarketingToolDTO> addTool(MarketingToolDTO dto);
	
	/**
	 * 工具查询(分页)
	 * @param dto
	 * @return
	 */
	
	Response< MarketingToolQTO > queryTool (MarketingToolQTO qto);
	
	/**
	 * 根据id查询工具
	 * @param dto
	 * @return
	 */
	Response<MarketingToolDTO> getTool (long id);
	
	/**
	 * 更新工具
	 * @param dto
	 * @return
	 */
	Response<MarketingToolDTO> updateTool(MarketingToolDTO dto);
	
	/**
	 * 删除工具
	 * @param dto
	 * @return
	 */
	Response<MarketingToolDTO> deleteTool(long toolId,long deleteUserId);
	
	/**
	 * 工具提交审核
	 * @param dto
	 * @return
	 */
	Response<MarketingToolDTO> submitToolAuditing(long toolId,long auditUserId);
	
	/**
	 * 工具审核通过
	 * @param dto
	 * @return
	 */
	Response<MarketingToolDTO> auditToolApproved (long toolId, long auditUserId);
	
	/**
	 * 工具审核未通过
	 * @param dto
	 * @return
	 */
	Response<MarketingToolDTO> auditToolDenied (long toolId,long auditUserId);
	
	/*******************营销活动管理*******************/
	/**
	 * 新增活动
	 * @param dto
	 * @return
	 */
	Response<MarketingActivityDTO> addActivity(MarketingActivityDTO dto);
	
	/**
	 * 获取活动所使用的工具参数列表
	 * @param dto
	 * @return
	 */
	public List<MarketingFormalParamDTO> getToolParams(long toolId);
	
	/**
	 * 活动查询(分页)
	 * @param dto
	 * @return
	 */
	Response< MarketingActivityQTO> queryActivity (MarketingActivityQTO qto);	
	
	
	/**
	 * 更新活动
	 * @param dto
	 * @return
	 */
	Response<MarketingActivityDTO> updateActivity (MarketingActivityDTO dto);
	
	
	/**
	 * 活动提交审核
	 * @param dto
	 * @return
	 */
	Response<MarketingActivityDTO> submitActivityAuditing(List<Long> ids,long auditUserId);
	
	/**
	 * 活动审核通过
	 * @param dto
	 * @return
	 */
	Response<MarketingActivityDTO> auditActivityApproved(List<Long> ids,long auditUserId);
	
	/**
	 * 活动审核拒绝
	 * @param dto
	 * @return
	 */
	Response<MarketingActivityDTO> auditActivityDenied(List<Long> ids,long auditUserId);
	
	/**
	 * 删除活动(逻辑删除)
	 * @param dto
	 * @return
	 */
	Response<MarketingActivityDTO> deleteActivity (long id);
	
	
	/**
	 * 取消活动(修改状态)
	 * @param dto
	 * @return
	 */
	Response<MarketingActivityDTO> cancelActivity (long id);
	
}
