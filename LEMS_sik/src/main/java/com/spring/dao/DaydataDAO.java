package com.spring.dao;

import java.sql.SQLException;
import java.util.List;


import com.spring.command.SearchListCommand;
import com.spring.dto.DaydataVO;

public interface DaydataDAO {

	List<DaydataVO> selectSearchDaydataList(SearchListCommand command) throws Exception;
	
	List<DaydataVO> selectDaydataList() throws Exception;
	
	int selectSearchDaydataListCount(SearchListCommand command) throws Exception;
	
	DaydataVO selectDaydataBydaynum(String daynum) throws SQLException;
}