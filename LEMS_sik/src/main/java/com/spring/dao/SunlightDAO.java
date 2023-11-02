package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchListCommand;
import com.spring.dto.SunlightVO;

public interface SunlightDAO {

	List<SunlightVO> selectSearchSunlightList(SearchListCommand command) throws SQLException;

	int selectSearchSunlightListCount(SearchListCommand command) throws SQLException;

	SunlightVO selectSunlightBySunnum(String sunnum) throws SQLException;

	SunlightVO selectSunlightByHwCode(String hwCode) throws SQLException;
}
