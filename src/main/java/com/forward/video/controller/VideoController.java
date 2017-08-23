package com.forward.video.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.forward.video.model.KeyVO;
import com.forward.video.model.Video;
import com.forward.video.service.CourseService;
import com.forward.video.service.SpeakerService;
import com.forward.video.service.VideoService;
import com.forward.video.util.Page;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/videoManagementList.action")
	public String videoManagementList(Model m,KeyVO kvo,@RequestParam(defaultValue="1")String page){
		
		int currentPage = Integer.parseInt(page);
		Page pages = vs.loadPage(kvo,currentPage);
		m.addAttribute("speakerList", ss.selectSpeakerAll());
		m.addAttribute("courseList", cs.selectCourseAll());
		m.addAttribute("videoList", pages.getRows());
		m.addAttribute("page", pages);
		m.addAttribute("kvo", kvo);
		return "forward:/WEB-INF/view/video/videoManagementList.jsp";
	}
	
	@RequestMapping(value="/addVideo.action",method=RequestMethod.GET)
	public String addVideo(Model m){
		m.addAttribute("speakerList", ss.selectSpeakerAll());
		m.addAttribute("courseList", cs.selectCourseAll());
		return "video/addVideo";
	}
	
	@RequestMapping(value="/addVideo.action",method=RequestMethod.POST)
	public String saveVideo(Video v){
		vs.saveVideo(v);
		return "redirect:/video/videoManagementList.action";
	}
	
	@RequestMapping(value="/deleteVideoById.action",method=RequestMethod.GET)
	public String deleteVideoById(String id){
		vs.deleteVideoById(id);
		return "redirect:/video/videoManagementList.action";
	}
	
	@RequestMapping(value="/deleteVideoByQuery.action",method=RequestMethod.GET)
	public String deleteVideoByQuery(String[] id){
		vs.deleteVideoByQuery(id);
		return "redirect:/video/videoManagementList.action";
	}
	
	@RequestMapping(value="/editorVideoById.action",method=RequestMethod.GET)
	public String editorVideoById(String id,Model m){
		Video v = vs.selectVideoById(id);
		m.addAttribute("speakerList", ss.selectSpeakerAll());
		m.addAttribute("courseList", cs.selectCourseAll());
		m.addAttribute("video", v);
		return "/video/editorVideoInfo";
	}
	
	@RequestMapping(value="/editorVideoById.action",method=RequestMethod.POST)
	public String saveVideoById(Video v){
		vs.updateVideoById(v);
		return "redirect:/video/videoManagementList.action";
	}
}
