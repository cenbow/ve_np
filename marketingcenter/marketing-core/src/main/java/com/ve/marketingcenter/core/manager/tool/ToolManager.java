package com.ve.marketingcenter.core.manager.tool;

import java.util.List;

import com.ve.marketingcenter.common.domain.dto.MarketingToolDTO;
import com.ve.marketingcenter.common.domain.qto.MarketingToolQTO;
import com.ve.marketingcenter.core.domain.ToolDO;
import com.ve.marketingcenter.core.exception.MarketingException;

/**
 * 
 * @author pengfei.zhu
 *
 */
public interface ToolManager {
	public Long addTool(MarketingToolDTO baseDto) throws MarketingException;

	public int updateTool(MarketingToolDTO baseDto) throws MarketingException;
	
	public int updateToolStatus(Long id,int status) throws MarketingException;

	public int deleteTool(long id) throws MarketingException;

	public List<MarketingToolDTO> queryTool(MarketingToolQTO qto) throws MarketingException;
	
	public ToolDO getTool(Long id) throws MarketingException;
	
	public int queryToolCount(MarketingToolQTO qto) throws MarketingException;
}
