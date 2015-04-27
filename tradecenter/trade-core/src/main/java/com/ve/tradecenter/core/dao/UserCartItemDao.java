package com.ve.tradecenter.core.dao;

import java.util.List;

import com.ve.tradecenter.core.domain.CartItemDO;
import com.ve.tradecenter.core.exception.DAOException;
import com.ve.tradecenter.core.exception.TradeException;

public interface UserCartItemDao {

	/** 
	 * 写入用户购物车商品到db
	 * @param record
	 * @return
	 * @throws DAOException
	 */
	public Long addUserCartItem(CartItemDO cartItemDO);

	/**
	 * 删除用户购物车商品
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public int deleteUserCartItem(CartItemDO cartItemDO);
	
	/**
	 * 清空该用户ID下所有的购物车商品
	 * @return
	 */
	public int cleanUserCart(Long userId);
	
	/**
	 * 查询用户购物车列表
	 * @param userId
	 * @return
	 */
	public List<CartItemDO> queryUserCartItems(Long userId);
	
	/**
	 * 更新用户购物车商品数目
	 * @param userId
	 * @return
	 */
	public int updateUserCartItem(CartItemDO cartItemDO);
	
	/**
	 * 查询已经加入用户购物车的商品ID
	 * @param user
	 * @return
	 */
	public List<Long> queryUserCartItemId(Long userId);

	/**
	 * 批量写入购物车项
	 * @param cartItemDOList
	 * @return
	 */
	public int addCartItems(List<CartItemDO> cartItemDOList)throws TradeException;
	
	/**
	 * 移除用户购物车中的赠品项
	 * @param userId
	 * @return
	 * @throws TradeException
	 */
    public int deleteGiftItems(Long userId);
    
    /**
     * 更新用户购物车商品的数量
     * @param cartItemDO
     * @return
     */
	public int updateUserCartItemNumber(CartItemDO cartItemDO);

}