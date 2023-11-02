package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.command.SearchListCommand;
import com.spring.service.DaydataService;
import com.spring.service.SunlightService;
import com.spring.service.TrafficService;

@Controller
@RequestMapping("/envdata")
public class EnvdataController {

	@Autowired
	private TrafficService trafficService;

	@Autowired
	private DaydataService daydataService;

	
	@Autowired
	private SunlightService sunlightService;

	@GetMapping("/main")
	public void main(SearchListCommand command, Model model) throws Exception{
		
	}

	@GetMapping("/traffic")
	public String traffic(SearchListCommand command, Model model)throws Exception{
		String url = "/envdata/traffic";
		
		Map<String, Object> dataMap = trafficService.getTrafficList(command);
		
		model.addAllAttributes(dataMap);

		return url;
	}

	@GetMapping("/trafficDetail")

	public String trafficDetail(SearchListCommand command, Model model) throws Exception {
		String url = "/envdata/trafficDetail";

		Map<String, Object> dataMap = daydataService.getDaydataList(command);

		model.addAllAttributes(dataMap);

		return url;
	}

	@GetMapping("/trafficDetailMonth")
	public String trafficDetailMonth(SearchListCommand command, Model model)throws Exception{
		String url = "/envdata/trafficDetailMonth";
		
		Map<String,Object> dataMap = daydataService.getMonthDataList(command);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}

	@GetMapping("/sun")
	public String sun(SearchListCommand command, Model model) throws Exception {
		String url = "/envdata/sun";

		Map<String, Object> dataMap = sunlightService.getSunlightList(command);

		model.addAllAttributes(dataMap);

		return url;
	}

	@GetMapping("/sunDetail")
	public String sunDetail(SearchListCommand command, Model model)throws Exception{
		String url = "/envdata/sunDetail";
		
		Map<String, Object> dataMap = sunlightService.getSunlightList(command);
		
		model.addAllAttributes(dataMap);

		return url;
	}

}
