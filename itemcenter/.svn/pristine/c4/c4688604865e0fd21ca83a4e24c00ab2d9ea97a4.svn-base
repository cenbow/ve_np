package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.ItemCommentDTO;
import com.ve.itemcenter.common.domain.qto.ItemCommentQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface ItemCommentManager {

	/**
	 * 添加商品评论
	 * 
	 * @param itemCommentDO
	 * @return
	 * @throws ItemException
	 */
	public ItemCommentDTO addItemComment(ItemCommentDTO itemCommentDO) throws ItemException;

	/**
	 * 查看商品评论
	 * 
	 * @param sellerId
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public ItemCommentDTO getItemComment(Long id, Long sellerId) throws ItemException;

	/**
	 * 删除商品评论
	 * 
	 * @param sellerId
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteItemComment(Long id, Long sellerId) throws ItemException;

	/**
	 * 根据商品ID查询所有的评论
	 * 
	 * @param itemCommentDTO
	 * @return
	 * @throws ItemException
	 */
	public List<ItemCommentDTO> queryItemComment(ItemCommentQTO itemCommentDTO) throws ItemException;

}
