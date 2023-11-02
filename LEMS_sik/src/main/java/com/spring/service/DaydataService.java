package com.spring.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.spring.command.SearchListCommand;
import com.spring.dto.DaydataVO;

public interface DaydataService {

	public Map<String, Object> getDaydataList(SearchListCommand command) throws Exception;
	
	public DaydataVO getDaydata(String dayNum) throws SQLException;
	
	public Map<String,Object> getMonthDataList(SearchListCommand command) throws Exception;
}
