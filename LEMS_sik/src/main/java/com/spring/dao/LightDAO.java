package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchListCommand;
import com.spring.dto.LightVO;

public interface LightDAO {
	/*
	List<LightVO> selectSearchLightList(SearchListCommand command) throws Exception;
	LightVO selectLightByLnum(String lnum) throws SQLException;
	LightVO selectLightByLstate(String lstate) throws SQLException;
	int selectSearchLightListCount(SearchListCommand command) throws Exception;
	*/
	List<LightVO> selectLightList() throws SQLException;
	List<LightVO> selectsearchLightList() throws SQLException;
	List<LightVO> selectLightByHwCode(String hwCode) throws SQLException;
	void updateLight(List<LightVO> light) throws Exception;
	LightVO selectLightByLnum(String lnum) throws SQLException;
}
