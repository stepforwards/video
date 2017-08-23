package com.forward.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forward.video.model.KeyVO;
import com.forward.video.model.Speaker;
import com.forward.video.service.SpeakerService;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	
	@Autowired
	SpeakerService ss;
	
	@RequestMapping("/speakerManagementList.action")
	public String speakerList(Model m,KeyVO kvo){
		List<Speaker> list = ss.selectSpeakerAll();
		//List<Speaker> list = ss.selectSpeakerByKey(kvo);
		m.addAttribute("speakerList", list);
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
