package com.ve.itemcenter.core.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.qto.GlobalPropertyValueQTO;
import com.ve.itemcenter.core.domain.GlobalPropertyValueDO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface GlobalPropertyValueDAO {

	/**
	 * 增加全局属性值域
	 * 
	 * @param globalPropertyValueDO
	 * @return
	 */
	Long addGlobalPropertyValue(GlobalPropertyValueDO globalPropertyValueDO);

	/**
	 * 根据id获取全局属性值域
	 * 
	 * @param id
	 * @return
	 */
	GlobalPropertyValueDO getGlobalPropertyValue(Long id);

	/**
	 * 根据id删除全局属性值域
	 * 
	 * @param id
	 * @return
	 */
	int deleteGlobalPropertyValue(Long id);

	/**
	 * 根据globalPropertyId删除全局属性值域
	 * 
	 * @param globalPropertyId
	 * @return
	 * @throws ItemException
	 */
	int deleteGlobalPropertyValueListByGlobalPropertyId(Long globalPropertyId) throws ItemException;

	/**
	 * 更新全局属性值域信息
	 * 
	 * @param globalPropertyValueDO
	 * @return
	 */
	int updateGlobalPropertyValue(GlobalPropertyValueDO globalPropertyValueDO);

	/**
	 * 返回全局属性值域列表
	 * 
	 * @param globalPropertyValueQTO
	 * @return
	 */
	List<GlobalPropertyValueDO> queryGlobalPropertyValue(GlobalPropertyValueQTO globalPropertyValueQTO);

}