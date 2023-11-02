package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchListCommand;
import com.spring.dto.SunlightVO;

public interface SunlightService {

	public Map<String, Object> getSunlightList(SearchListCommand command) throws SQLException;

	public SunlightVO getSunlight(String sunnum) throws SQLException;

	public SunlightVO getSunlightByHwCode(String hwCode) throws SQLException;
}
