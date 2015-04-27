package com.ve.tradecenter.core.dao;

import java.util.List;

import com.ve.tradecenter.core.domain.CartItemDO;

public interface CartItemDao {
	
	/**
	 * 写入购物车项
	 * @param record
	 * @return
	 */
    public Long addCartItem(CartItemDO record);
    
    /**
     * 删除购物车项
     * @param id
     * @return
     */
    public int deleteCartItem(Long id);
    
    /**
     * 根据sessionId删除购物车
     * @param sessionId
     * @return
     */
    public int cleanCart(String sessionId);
    
    /**
     * 查出购物车列表
     * @param sessionId
     * @return
     */
    public List<CartItemDO> querytCartItems(String sessionId);
    
    /**
     * 移除用户购物车中的赠品
     * @param userId
     * @return
     */
    public int deleteGiftItems(String sessionId);
    
    /**
     * 更新购物车的商品的数量
     * @param cartItemDO
     * @return
     */
	public int updateCartItemNumber(CartItemDO cartItemDO);

}
