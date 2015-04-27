package com.ve.marketingcenter.core.manager.tool.impl;

import java.util.List;

import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingToolQTO;
import com.ve.marketingcenter.core.dao.tool.ToolDODAO;
import com.ve.marketingcenter.core.domain.ToolDO;
import com.ve.marketingcenter.core.exception.MarketingException;
import com.ve.marketingcenter.core.manager.tool.ToolManager;
import com.ve.marketingcenter.core.util.MarketingUtils;


public class ToolManagerImpl implements ToolManager {
	
	private ToolDODAO toolDao;
	
	@Override
	public Long addTool(MarketingToolDTO mdto) throws MarketingException {
		try {
			ToolDO tdo = new ToolDO();
			MarketingUtils.copyProperties(mdto, tdo);
			return toolDao.addTool(tdo);
			//CONTINUED 插入形参
		} catch (Exception e) {
			//CONTINUED exception
			throw new MarketingException();
		}
	}




	@Override
	public int updateTool(MarketingToolDTO baseDto) throws MarketingException {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public int updateToolStatus(Long id, int status) throws MarketingException {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public int deleteTool(long id) throws MarketingException {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public List<MarketingToolDTO> queryTool(MarketingToolQTO qto) throws MarketingException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public int queryToolCount(MarketingToolQTO qto) throws MarketingException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ToolDO getTool(Long id) throws MarketingException {
		return toolDao.getTool(id);
	}

	public void setToolDao(ToolDODAO toolDao) {
		this.toolDao = toolDao;
	}
}
