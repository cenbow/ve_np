package com.ve.itemcenter.core.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.qto.ItemCommentQTO;
import com.ve.itemcenter.core.domain.ItemCommentDO;

@Service
public interface ItemCommentDAO {

	/**
	 * 增加商品评论
	 * 
	 * @param itemCommentDO
	 * @return
	 */
	Long addItemComment(ItemCommentDO itemCommentDO);

	/**
	 * 获取商品评论
	 * 
	 * @param id
	 * @return
	 */
	ItemCommentDO getItemComment(Long id, Long sellerId);

	/**
	 * 更新商品评论
	 * 
	 * @param itemCommentDO
	 * @return
	 */
	int updateItemComment(ItemCommentDO itemCommentDO);

	/**
	 * 删除商品评论
	 * 
	 * @param sellerId
	 * @param id
	 * @return
	 */
	int deleteItemComment(Long id, Long sellerId);

	/**
	 * 根据商品ID查询所有的评论
	 * 
	 * @param itemCommentQTO
	 * @return
	 */
	List<ItemCommentDO> queryItemCommentByItemId(ItemCommentQTO itemCommentQTO);

}