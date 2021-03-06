package com.ve.tradecenter.core.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.dao.UserCartItemDao;
import com.ve.tradecenter.core.domain.CartItemDO;
import com.ve.tradecenter.core.exception.TradeException;

/**
 * 用户购物车DAO实现类
 * @author cwr
 */
public class UserCartItemDaoImpl extends SqlMapClientDaoSupport implements UserCartItemDao {
	
	@Override
	public Long addUserCartItem(CartItemDO cartItemDO){
       return (Long)this.getSqlMapClientTemplate().insert("user_cart.addUserCartItem", cartItemDO);
	}

	@Override
	public int deleteUserCartItem(CartItemDO cartItemDO){
		return this.getSqlMapClientTemplate().delete("user_cart.deleteUserCartItem",cartItemDO);
	}

	@Override
	public int cleanUserCart(Long userId){
		return this.getSqlMapClientTemplate().delete("user_cart.cleanUserCart",userId);
	}

	@Override
	public List<CartItemDO> queryUserCartItems(Long userId) {
		return this.getSqlMapClientTemplate().queryForList("user_cart.queryUserCartItems",userId);
	}

	@Override
	public int updateUserCartItem(CartItemDO cartItemDO) {
		return this.getSqlMapClientTemplate().update("user_cart.updateUserCartItem",cartItemDO);
	}

	@Override
	public List<Long> queryUserCartItemId(Long userId) {
		return this.getSqlMapClientTemplate().queryForList("user_cart.queryUserCartItemId",userId);
	}

	@Override
	public int addCartItems(List<CartItemDO> cartItemDOList)throws TradeException{
		int result = 0;
		try {
			this.getSqlMapClient().startBatch();
			for (CartItemDO item : cartItemDOList) {
				this.getSqlMapClientTemplate().insert("user_cart.addUserCartItem",item);
			}
			result = this.getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		return result;
	}
	
	@Override
    public int deleteGiftItems(Long userId){
		return this.getSqlMapClientTemplate().delete("user_cart.deleteGiftItems",userId);
    }
	
	@Override
	public int updateUserCartItemNumber(CartItemDO cartItemDO){
		return this.getSqlMapClientTemplate().update("user_cart.updateUserCartItemNumber",cartItemDO);
	}
 

}