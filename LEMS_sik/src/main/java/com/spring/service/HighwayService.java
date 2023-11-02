	package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchListCommand;
import com.spring.dto.HighwayVO;

public interface HighwayService {

	public Map<String, Object> getHighwayList(SearchListCommand command) throws Exception;
	
	public HighwayVO getHighway(String hwcode) throws SQLException;
}
