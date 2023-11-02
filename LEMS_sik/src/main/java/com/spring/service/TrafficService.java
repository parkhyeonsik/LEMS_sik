
package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchListCommand;
import com.spring.dto.TrafficVO;

public interface TrafficService {

	public Map<String, Object> getTrafficList(SearchListCommand command) throws Exception;

	public TrafficVO getTraffic(String traffnum) throws SQLException;

	public TrafficVO getTrafficByHwCode(String hwCode) throws SQLException;
}
