package com.spring.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.command.SearchListCommand;
import com.spring.service.DaydataService;


@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	
	@Autowired
	private DaydataService daydataService;
	
	@GetMapping("/main")
	   public String main()throws Exception{
	      String url = "/analysis/main";
	      return url;
	}
   @GetMapping("/predict")
   public String predict(SearchListCommand command, Model model)throws Exception{
	  String url = "/analysis/predict";

	  Map<String, Object> dataMap = daydataService.getDaydataList(command);
	  model.addAllAttributes(dataMap);
	  
      return url;
   }
   @GetMapping("/compare")
   public String compare(SearchListCommand command, Model model)throws Exception{
      String url = "/analysis/compare";
      
      Map<String, Object> dataMap = daydataService.getDaydataList(command);
      model.addAllAttributes(dataMap);
      
      return url;
   }   
      
}