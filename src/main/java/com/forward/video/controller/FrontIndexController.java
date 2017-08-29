package com.forward.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/front")
public class FrontIndexController {
	
	
	@RequestMapping("/indexFront.action")
	public String goFrontIndex(){
		return "/front/index";
	}
	
}
