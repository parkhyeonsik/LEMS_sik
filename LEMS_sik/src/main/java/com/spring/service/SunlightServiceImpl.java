package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.command.PageMaker;
import com.spring.command.SearchListCommand;
import com.spring.dao.SunlightDAO;
import com.spring.dto.SunlightVO;

public class SunlightServiceImpl implements SunlightService {

	private SunlightDAO sunlightDAO;

	public void setSunlightDAO(SunlightDAO sunlightDAO) {
		this.sunlightDAO = sunlightDAO;
	}

	@Override
	public Map<String, Object> getSunlightList(SearchListCommand command) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String ,Object>();
		Map<String,String> staticMap = new HashMap<String,String>();
		
		List<SunlightVO> sunlightList = sunlightDAO.selectSearchSunlightList(command);
		
		if(sunlightList.size()>0) {
			for (int i=0;i<sunlightList.size();i++) {
				//lightUse
				float lutmp = Float.parseFloat(sunlightList.get(i).getLightUse());
				sunlightList.get(i).setLightUse(String.format("%.1f", lutmp));
			}
		}
		
		int flsum=0;
		float eusum=0;
		int flmin=0;
		int flmax=0;
		float eumin=0;
		float eumax=0;
		int fldevi=0;
		float eudevi=0;
		
		if(sunlightList.size()>0) {

			flmin=Integer.parseInt(sunlightList.get(0).getFullLight());
			flmax=Integer.parseInt(sunlightList.get(0).getFullLight());
			eumin=Float.parseFloat(sunlightList.get(0).getLightUse());
			eumax=Float.parseFloat(sunlightList.get(0).getLightUse());
			for(int i=0;i<sunlightList.size();i++) {
				
				//sum
				flsum+=Integer.parseInt(sunlightList.get(i).getFullLight());
				eusum+=Float.parseFloat(sunlightList.get(i).getLightUse());
				
				//mix, max
				flmin=(flmin>Integer.parseInt(sunlightList.get(i).getFullLight()) ? Integer.parseInt(sunlightList.get(i).getFullLight()) : flmin);
				flmax=(flmax<Integer.parseInt(sunlightList.get(i).getFullLight()) ? Integer.parseInt(sunlightList.get(i).getFullLight()) : flmax);
				eumin=(eumin>Float.parseFloat(sunlightList.get(i).getLightUse())) ? Float.parseFloat(sunlightList.get(i).getLightUse()) : eumin;
				eumax=(eumax<Float.parseFloat(sunlightList.get(i).getLightUse())) ? Float.parseFloat(sunlightList.get(i).getLightUse()) : eumax;
			}
		}	
		
	
		staticMap.put("flMin", String.format("%d", flmin));
		staticMap.put("flMax", String.format("%d", flmax));
		staticMap.put("euMin", eumin+"");
		staticMap.put("euMax", eumax+"");
		

		//staticCommand.setTraMin(tramintmp+"");
		//평균
		staticMap.put("flAvg", String.format("%d", (flsum/sunlightList.size())));
		staticMap.put("euAvg", String.format("%.1f",(eusum/sunlightList.size())));
		
		//표준편차
		for(int i=0; i<sunlightList.size();i++) {
			fldevi+=Math.pow((Integer.parseInt(sunlightList.get(i).getFullLight())-(flsum/sunlightList.size())),2);
			eudevi+=Math.pow((Integer.parseInt(sunlightList.get(i).getSunRise())-(eusum/sunlightList.size())), 2);
		}
		
		//int tmp=(int)Math.floor(Math.sqrt(fldevi/sunlightList.size()));
		
		staticMap.put("flDevi", String.format("%.1f", Math.sqrt(fldevi/sunlightList.size())));
		staticMap.put("euDevi", String.format("%.1f", Math.sqrt(eudevi/sunlightList.size())));

		staticMap.replace("flMin", staticMap.get("flMin").substring(0,2) + ":" + staticMap.get("flMin").substring(2,4));
		staticMap.replace("flMax", staticMap.get("flMax").substring(0,2) + ":" + staticMap.get("flMax").substring(2,4));
		staticMap.replace("flAvg", staticMap.get("flAvg").substring(0,2) + ":" + staticMap.get("flAvg").substring(2,4));
//		staticMap.replace("flDevi",staticMap.get("flDevi").substring(0,2) + ":" + staticMap.get("flDevi").substring(2,4));
		
		

		dataMap.put("staticMap", staticMap);
		dataMap.put("sunlightList", sunlightList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCommand(command);
		pageMaker.setTotalCount(sunlightDAO.selectSearchSunlightListCount(command));
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public SunlightVO getSunlight(String sunnum) throws SQLException {

		SunlightVO sunlight = sunlightDAO.selectSunlightBySunnum(sunnum);

		return sunlight;
	}

	@Override
	public SunlightVO getSunlightByHwCode(String hwCode) throws SQLException {
		
		SunlightVO sunlight = sunlightDAO.selectSunlightByHwCode(hwCode);

		return sunlight;
	}

}
