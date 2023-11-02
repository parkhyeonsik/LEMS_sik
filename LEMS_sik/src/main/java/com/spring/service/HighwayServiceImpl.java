package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.command.PageMaker;
import com.spring.command.SearchListCommand;
import com.spring.dao.HighwayDAO;
import com.spring.dto.HighwayVO;

public class HighwayServiceImpl implements HighwayService{

	private HighwayDAO highwayDAO;
	public void setHighwayDAO(HighwayDAO highwayDAO) {
		this.highwayDAO = highwayDAO;
	}
	
	@Override
	public Map<String, Object> getHighwayList(SearchListCommand command) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<HighwayVO> highwayList = highwayDAO.selectSearchHighwayList(command);
		dataMap.put("highList", highwayList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCommand(command);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public HighwayVO getHighway(String hwcode) throws SQLException {

		HighwayVO highway = highwayDAO.selectHighwayByHwcode(hwcode);
		return highway;
	}

}
