package com.forward.video.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forward.video.model.KeyVO;
import com.forward.video.model.Speaker;
import com.forward.video.service.SpeakerService;
import com.forward.video.util.Page;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	
	@Autowired
	SpeakerService ss;
	
	@RequestMapping("/speakerManagementList.action")
	public String speakerList(Model m,KeyVO kvo,@RequestParam(defaultValue="1")String page){
		int currentPage = Integer.parseInt(page);
		@SuppressWarnings("rawtypes")
		Page pages = ss.loadPage(kvo,currentPage);
		m.addAttribute("kvo", kvo);
		m.addAttribute("page", pages);
		m.addAttribute("speakerList", pages.getRows());
		return "/speaker/speakerManagementList";
	}
	
	@RequestMapping(value="/addSpeaker.action",method=RequestMethod.GET)
	public String addSpeaker(){
		return "/speaker/addSpeaker";
	}
	
	@RequestMapping(value="/addSpeaker.action",method=RequestMethod.POST)
	public String addSpeaker(Speaker speaker){
		ss.addSpeaker(speaker);
		return "redirect:/speaker/speakerManagementList.action";
	}
	
	@RequestMapping(value="/deleteSpeakerById.action",method=RequestMethod.GET)
	public String deleteSpeakerById(String id){
		ss.deleteSpeakerById(id);
		return "redirect:/speaker/speakerManagementList.action";
	}
	
	@RequestMapping(value="/deleteSpeakerByIdAjax.action",method=RequestMethod.GET)
	@ResponseBody
	public String deleteSpeakerByIdAjax(String id){
		ss.deleteSpeakerById(id);
		return "true";
	}
	
	@RequestMapping(value="/editorSpeaker.action",method=RequestMethod.GET)
	public String editorSpeaker(String id,Model m){
		Speaker speaker = ss.selectSpeakerById(id);
		m.addAttribute("speaker", speaker);
		return "/speaker/editorSpeaker";
	}
	
	@RequestMapping(value="/editorSpeaker.action",method=RequestMethod.POST)
	public String editorSpeaker(Speaker speaker){
		ss.updateSpeakerById(speaker);
		return "redirect:/speaker/speakerManagementList.action";
	}
	
}
