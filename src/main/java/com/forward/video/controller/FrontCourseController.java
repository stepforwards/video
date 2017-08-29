package com.forward.video.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forward.video.model.Course;
import com.forward.video.service.CourseService;
import com.forward.video.service.SubjectService;
import com.forward.video.service.VideoService;


@Controller
@RequestMapping("/front/course")
public class FrontCourseController {
	
	@Autowired
	SubjectService ss;
	@Autowired
	CourseService cs;
	@Autowired
	VideoService vs;
	
	@RequestMapping("/index.action")
	public String courseIndex(String subjectId,Model m){
		List<Course> courses = cs.selectCourseBySubjectId(subjectId);
		Integer [] courseIds = new Integer[courses.size()];
		for(int i = 0;i < courses.size();i++){
			courseIds[i] = new Integer(courses.get(i).getId());
			courses.get(i).setVideoList(vs.selectVideobyCourseId(courseIds[i]));
		}
		m.addAttribute("subjectId", subjectId);
		m.addAttribute("subject", ss.selectSubjectById(subjectId));
		m.addAttribute("courses", courses);
		m.addAttribute("course", courses);
		return "/front/course/index";
	} 
}
