package com.forward.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forward.video.model.VSVO;
import com.forward.video.model.Video;
import com.forward.video.service.CourseService;
import com.forward.video.service.SpeakerService;
import com.forward.video.service.SubjectService;
import com.forward.video.service.VideoService;

@Controller
@RequestMapping("/front/video")
public class FrontVideoController {
	
	@Autowired
	SubjectService ss;
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService speakerService;
	@Autowired
	CourseService cs;
	
	@RequestMapping("/index.action")
	public String index(VSVO vsvo,Model m){
		m.addAttribute("subject", ss.selectSubjectById(vsvo.getSubjectId()));
		m.addAttribute("videoId", vsvo.getVideoId());
		return "/front/video/index";
	}
	
	
	@RequestMapping("/state.action")
	public void state(String videoId){
		vs.updateVideoStateById(videoId);
	}
	
	@RequestMapping("/videoData.action")
	public String videoData(VSVO vsvo,Model m){
		Video video = vs.selectVideoByIdAllInfo(vsvo.getVideoId());
		m.addAttribute("course", cs.selectCourseById(video.getCourseId()+""));
		m.addAttribute("speaker", speakerService.selectSpeakerById(video.getSpeakerId()+""));
		m.addAttribute("video", video);
		m.addAttribute("subjectId", video.getSpeakerId());
		m.addAttribute("videoList", vs.selectVideobyCourseIds(video.getCourseId()));
		return "/front/video/content";
	}
}
