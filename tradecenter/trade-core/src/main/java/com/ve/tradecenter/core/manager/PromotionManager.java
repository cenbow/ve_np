package com.ve.tradecenter.core.manager;

import java.util.ArrayList;
import java.util.List;

import com.ve.tradecenter.common.domain.FavorableInfoDTO;
import com.ve.tradecenter.common.domain.ItemSkuQTO;
import com.ve.tradecenter.core.domain.CartItemDO;
import com.ve.tradecenter.core.exception.TradeException;

/**
 * 促销模块的调用接口处理类
 * @author cwr
 */
public interface PromotionManager {

	/**
	 * 根据购物车商品列表调用促销平台查询信息
	 * @return
	 */
	public List<FavorableInfoDTO> getPromotionItems(List<ItemSkuQTO> itemSkus)throws TradeException;
	
	/**
	 * 构造促销平台的查询条件
	 * @return
	 */
	public List<ItemSkuQTO> getPromotionQueryCondition(List<CartItemDO> cartItems);
	
	/**
	 * 下单时候根据商品列表、优惠券号计算优惠信息
	 * @param itemSkuQTOList
	 * @return
	 */
	public List<FavorableInfoDTO> getPromotionItems(List<ItemSkuQTO> itemSkuQTOList,long userId,List<Long> couponId,int source)throws TradeException; 
} 
