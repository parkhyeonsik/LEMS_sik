package com.spring.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.command.PageMaker;
import com.spring.command.SearchListCommand;
import com.spring.dao.DaydataDAO;
import com.spring.dto.DaydataVO;

public class DaydataServiceImpl implements DaydataService{

	private DaydataDAO daydataDAO;
	public void setDaydataDAO(DaydataDAO daydataDAO) {
		this.daydataDAO = daydataDAO;
	}
	
	@Override
	public Map<String,Object> getMonthDataList(SearchListCommand command) throws Exception{
		Map<String,Object> dataMap = new HashMap<String,Object>();
		Map<String, Object> staticMap = new HashMap<String, Object>();
		List<DaydataVO> dayMonthList = daydataDAO.selectDaydataList();
		List<DaydataVO> monthData = new ArrayList<DaydataVO>();
		String[] hwCode= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"};
		LocalDate now = LocalDate.now();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
		String currentMonth = now.format(formatter);
		int[] traffSum={0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		float[] spdAvg={0,0,0,0,0,0,0,0,0,0,0,0,0,0};

		//initialize
		for(int i=0;i<hwCode.length;i++) {
			dataMap.put(hwCode[i]+"monthTraff", 0);
			dataMap.put(hwCode[i]+"monthSpd", 0);
		}
		
		for(int i=0;i<dayMonthList.size();i++) {
			if(format.format(dayMonthList.get(i).getDayDate()).substring(0,7).equals(currentMonth)) {
				for(int j=0;j<hwCode.length;j++) {
					if(hwCode[j].equals(dayMonthList.get(i).getHwCode())) {
						traffSum[j]+= Integer.parseInt(dayMonthList.get(i).getDayTrf());
						//System.out.println(dayMonthList.get(i).getHwCode()+" : "+traffSum[j]);
						spdAvg[j]+=Float.parseFloat(dayMonthList.get(i).getDaySpd());
						//System.out.println(dayMonthList.get(i).getHwCode()+" : "+spdAvg[j]);
					}
				}
			}
		}
		for(int i=0;i<hwCode.length;i++) {
			monthData.add(new DaydataVO());
			monthData.get(i).setStrDate(currentMonth);
			monthData.get(i).setDayTrf(traffSum[i]+"");
			monthData.get(i).setHwCode(hwCode[i]);
			float tmp=spdAvg[i]/(dayMonthList.size()/14);
			monthData.get(i).setDaySpd(String.format("%.1f", tmp));
		}

		float Montrasum=0; 
		float Monspsum=0;
		int Montramin=0;
		int Montramax=0;
		float Monspmin=0;
		float Monspmax=0;
		int Montradevi=0;
		int Monspdevi=0;
		
		if(dayMonthList.size()>0) {
			Montramin= Integer.parseInt(dayMonthList.get(0).getDayTrf());
			Montramax= Integer.parseInt(dayMonthList.get(0).getDayTrf());
			Monspmin=Float.parseFloat(dayMonthList.get(0).getDaySpd());
			Monspmax=Float.parseFloat(dayMonthList.get(0).getDaySpd());
			
			for (int i=0;i<dayMonthList.size();i++) {
				Montrasum+= Float.parseFloat(dayMonthList.get(i).getDayTrf());
				Monspsum+= Float.parseFloat(dayMonthList.get(i).getDaySpd());
				
				Montramin=(Montramin>Integer.parseInt(dayMonthList.get(i).getDayTrf())) ? Integer.parseInt(dayMonthList.get(i).getDayTrf()) : Montramin; 
				Montramax=(Montramax<Integer.parseInt(dayMonthList.get(i).getDayTrf())) ? Integer.parseInt(dayMonthList.get(i).getDayTrf()) : Montramax;
				Monspmin=(Monspmin>Float.parseFloat(dayMonthList.get(i).getDaySpd())) ? Float.parseFloat(dayMonthList.get(i).getDaySpd()) : Monspmin;
				Monspmax=(Monspmax<Float.parseFloat(dayMonthList.get(i).getDaySpd())) ? Float.parseFloat(dayMonthList.get(i).getDaySpd()) : Monspmax;
			}
		}
		staticMap.put("Montramin", String.format("%d", Montramin));
		staticMap.put("Montramax", String.format("%d", Montramax));
		staticMap.put("Monspmin",  String.format("%.1f", Monspmin));
		staticMap.put("Monspmax",  String.format("%.1f", Monspmax));
		
		staticMap.put("MontraAvg", String.format("%.1f", (Montrasum/dayMonthList.size())));
		staticMap.put("MonspAvg", String.format("%.1f", (Monspsum/dayMonthList.size())));
		
		for(int i=0; i<dayMonthList.size();i++) {
			float tmp = Math.round(Integer.parseInt(dayMonthList.get(i).getDayTrf())-(Montrasum/dayMonthList.size()));
			Montradevi+=Math.pow(tmp,2);
			tmp =  Math.round(Float.parseFloat(dayMonthList.get(i).getDaySpd())-(Monspsum/dayMonthList.size()));
			Monspdevi+=Math.pow(tmp, 2);
			System.out.println("Montradevi : "+Montradevi+"Monspdevi :"+Monspdevi);
		}
		
		staticMap.put("Montradevi", String.format("%.1f",Math.sqrt((Montradevi/dayMonthList.size()))));
		staticMap.put("Monspdevi",  String.format("%.1f",Math.sqrt((Monspdevi/dayMonthList.size()))));
		System.out.println("Montradevi : "+staticMap.get("Montradevi")+"Monspdevi :"+staticMap.get("Monspdevi")+ dayMonthList.size());

		dataMap.put("staticMap", staticMap);
		dataMap.put("dayMonthList", dayMonthList);
		dataMap.put("monthData", monthData);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCommand(command);
		pageMaker.setTotalCount(daydataDAO.selectSearchDaydataListCount(command));
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}
	
	@Override
	public Map<String, Object> getDaydataList(SearchListCommand command) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> staticMap = new HashMap<String, String>();
		
		List<DaydataVO> daydataList = daydataDAO.selectSearchDaydataList(command);
		
		float trasum=0; 
		float spsum=0;
		int tramin=0;
		int tramax=0;
		float spmin=0;
		float spmax=0;
		float tradevi=0;
		float spdevi=0;
		
		if(daydataList.size()>0) { 

			for (int i=0;i<daydataList.size();i++) {
				//SpeedAvg
				float satmp = Float.parseFloat(daydataList.get(i).getDaySpd());
				daydataList.get(i).setDaySpd(String.format("%.1f", satmp));
				
				float dptmp = Float.parseFloat(daydataList.get(i).getDayPre());
				daydataList.get(i).setDayPre(String.format("%.1f", dptmp));
				
				//occ
				//float occtmp = Float.parseFloat(daydataList.get(i).getDayOcc());
				//daydataList.get(i).setDayOcc(String.format("%.1f", occtmp));
				
				//합계
				trasum+= Float.parseFloat(daydataList.get(i).getDayTrf());
				spsum+=Float.parseFloat(daydataList.get(i).getDaySpd());
				
				//min,max
				tramin=(tramin>Integer.parseInt(daydataList.get(i).getDayTrf())) ? Integer.parseInt(daydataList.get(i).getDayTrf()) : tramin; 
				tramax=(tramax<Integer.parseInt(daydataList.get(i).getDayTrf())) ? Integer.parseInt(daydataList.get(i).getDayTrf()) : tramax; 
				spmin=(spmin>Float.parseFloat(daydataList.get(i).getDaySpd())) ? Float.parseFloat(daydataList.get(i).getDaySpd()) : spmin; 
				spmax=(spmax<Float.parseFloat(daydataList.get(i).getDaySpd())) ? Float.parseFloat(daydataList.get(i).getDaySpd()) : spmax; 
			}
		}
		staticMap.put("traMin", String.format("%d", tramin));
		staticMap.put("traMax", String.format("%d", tramax));
		staticMap.put("spMin",  String.format("%.1f", spmin));
		staticMap.put("spMax",  String.format("%.1f", spmax));
		

		//staticCommand.setTraMin(tramintmp+"");
		// 평균
		staticMap.put("traAvg", String.format("%.1f", (trasum/daydataList.size())));
		staticMap.put("spAvg", String.format("%.1f", (spsum/daydataList.size())));
		
		// 표준편차 
		for(int i=0; i<daydataList.size();i++) {
			tradevi+=Math.pow(((Float.parseFloat(daydataList.get(i).getDayTrf()))-(trasum/daydataList.size())),2);
			spdevi+=Math.pow(((Float.parseFloat(daydataList.get(i).getDaySpd()))-(spsum/daydataList.size())), 2);
		}
		
		staticMap.put("traDevi", String.format("%.1f",Math.sqrt((tradevi/daydataList.size()))));
		staticMap.put("spDevi",  String.format("%.1f",Math.sqrt((spdevi/daydataList.size()))));
		
		dataMap.put("staticMap", staticMap);
		dataMap.put("daydataList", daydataList);
		
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCommand(command);
		pageMaker.setTotalCount(daydataDAO.selectSearchDaydataListCount(command));
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public DaydataVO getDaydata(String dayNum) throws SQLException {
		DaydataVO daydata = daydataDAO.selectDaydataBydaynum(dayNum);
		return daydata;
	}

}