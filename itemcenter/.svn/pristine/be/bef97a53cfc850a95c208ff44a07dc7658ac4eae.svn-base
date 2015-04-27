package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.GlobalPropertyDTO;
import com.ve.itemcenter.common.domain.qto.GlobalPropertyQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface GlobalPropertyManager {

	/**
	 * 添加全局属性
	 * 
	 * @param globalPropertyDO
	 * @return
	 * @throws ItemException
	 */
	public GlobalPropertyDTO addGlobalProperty(GlobalPropertyDTO globalPropertyDTO) throws ItemException;

	/**
	 * 添加全局属性
	 * 
	 * @param globalPropertyDTO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateGlobalProperty(GlobalPropertyDTO globalPropertyDTO) throws ItemException;

	/**
	 * 查看全局属性
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public GlobalPropertyDTO getGlobalProperty(Long id) throws ItemException;

	/**
	 * 删除全局属性
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteGlobalProperty(Long id) throws ItemException;


	/**
	 * 查询全局属性列表
	 * 
	 * @param globalPropertyQTO
	 * @return
	 * @throws ItemException
	 */
	public List<GlobalPropertyDTO> queryGlobalProperty(GlobalPropertyQTO globalPropertyQTO) throws ItemException;

}
