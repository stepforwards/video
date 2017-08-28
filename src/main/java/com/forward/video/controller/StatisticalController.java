package com.forward.video.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forward.video.model.Video;
import com.forward.video.service.StatisticalService;

@Controller
@RequestMapping("/statistical")
public class StatisticalController {
	
	@Autowired
	StatisticalService ss;
	
	@RequestMapping("/statisticalAnalysis.action")
	public String statisticalAnalysis(Model m){
		List<Video> list = ss.courseStatisticalAnalysis();
		String courseNames = "";
		String coursePlays = "";
		for(int i = 0;i < list.size();i++){
			if(i == list.size()-1){
				courseNames += list.get(i).getCourseName();
				coursePlays += list.get(i).getAvg();
				break;
			}
			courseNames += list.get(i).getCourseName()+"\",\"";
			coursePlays += list.get(i).getAvg()+"\",\"";
		}
		m.addAttribute("courseNames",courseNames);
		m.addAttribute("coursePlays",coursePlays);
		return "/statistical/statisticalAnalysis";
	}
	
}
