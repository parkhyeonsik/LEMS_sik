package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchListCommand;
import com.spring.dto.HighwayVO;

public interface HighwayDAO {

	List<HighwayVO> selectSearchHighwayList(SearchListCommand command) throws Exception;
	
	HighwayVO selectHighwayByHwcode(String hwcode) throws SQLException;
}
