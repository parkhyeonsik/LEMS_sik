package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.command.PageMaker;
import com.spring.command.SearchListCommand;
import com.spring.dao.TrafficDAO;
import com.spring.dto.TrafficVO;

public class TrafficServiceImpl implements TrafficService {

	private TrafficDAO trafficDAO;

	public void setTrafficDAO(TrafficDAO trafficDAO) {
		this.trafficDAO = trafficDAO;
	}

	@Override
	public Map<String, Object> getTrafficList(SearchListCommand command) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<TrafficVO> trafficList = trafficDAO.selectsearchTrafficList(command);
		
		if(trafficList.size()>0) { 
		
			for (int i=0;i<trafficList.size();i++) {
				//SpeedAvg
				float satmp = Float.parseFloat(trafficList.get(i).getSpeedAvg());
				trafficList.get(i).setSpeedAvg(String.format("%.1f", satmp));
				
				//occ
				float occtmp = Float.parseFloat(trafficList.get(i).getOccupancy());
				trafficList.get(i).setOccupancy(String.format("%.1f", occtmp));

			}
		}

		dataMap.put("trafficList", trafficList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCommand(command);
		pageMaker.setTotalCount(trafficDAO.selectSearchTrafficListCount(command));
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public TrafficVO getTraffic(String traffnum) throws SQLException {

		TrafficVO traffic = trafficDAO.selectTrafficByTraffnum(traffnum);

		return traffic;
	}

	@Override
	public TrafficVO getTrafficByHwCode(String hwCode) throws SQLException {

		TrafficVO traffic = trafficDAO.selectTrafficByHwCode(hwCode);

		return traffic;
	}

}
