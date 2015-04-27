package com.ve.itemcenter.core.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.itemcenter.common.domain.dto.SalesFieldDTO;
import com.ve.itemcenter.common.domain.qto.SalesFieldQTO;
import com.ve.itemcenter.core.exception.ItemException;

@Service
public interface SalesFieldManager {

	/**
	 * 添加专场
	 * 
	 * @param salesFieldDO
	 * @return
	 * @throws ItemException
	 */
	public SalesFieldDTO addSalesField(SalesFieldDTO salesFieldDTO) throws ItemException;

	/**
	 * 添加专场
	 * 
	 * @param salesFieldDTO
	 * @return
	 * @throws ItemException
	 */
	public boolean updateSalesField(SalesFieldDTO salesFieldDTO) throws ItemException;

	/**
	 * 查看专场
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public SalesFieldDTO getSalesField(Integer id) throws ItemException;

	/**
	 * 删除专场
	 * 
	 * @param id
	 * @return
	 * @throws ItemException
	 */
	public boolean deleteSalesField(Integer id) throws ItemException;

	/**
	 * 查询专场列表
	 * 
	 * @param salesFieldQTO
	 * @return
	 * @throws ItemException
	 */
	public List<SalesFieldDTO> querySalesField(SalesFieldQTO salesFieldQTO) throws ItemException;

}
