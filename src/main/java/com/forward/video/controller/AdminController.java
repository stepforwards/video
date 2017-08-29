package com.forward.video.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forward.video.model.Admin;
import com.forward.video.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService as;
	
	@RequestMapping(value="/indexBackstage.action",method=RequestMethod.GET)
	public String indexBackstage(){
		return "/admin/indexBackstage";
	}
	
	/*admin登录*/
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		Admin admin = as.login(username, password);
		if(admin != null){
			session.setAttribute("admin", admin);
			return "forward:/video/videoManagementList.action";
		}
		return "redirect:/index.jsp";
	}
	
	/*admin退出*/
	@RequestMapping(value="/logout.action",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "/admin/indexBackstage";
	}
	
}
