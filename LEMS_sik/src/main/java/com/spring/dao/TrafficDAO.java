package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchListCommand;
import com.spring.dto.TrafficVO;

public interface TrafficDAO {

	List<TrafficVO> selectsearchTrafficList(SearchListCommand command) throws Exception;

	int selectSearchTrafficListCount(SearchListCommand command) throws Exception;

	TrafficVO selectTrafficByTraffnum(String traffnum) throws SQLException;

	TrafficVO selectTrafficByHwCode(String hwCode) throws SQLException;
}
