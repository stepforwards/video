package com.forward.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.forward.video.model.Course;
import com.forward.video.service.CourseService;
import com.forward.video.service.SubjectService;
import com.forward.video.util.Page;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	
	@SuppressWarnings({ "rawtypes"})
	@RequestMapping("/courseManagementList.action")
	public String courseManagementList(Model m,@RequestParam(defaultValue="1")String page){
		int currentPage = Integer.parseInt(page);
		Page pages = cs.loadPage(currentPage); 
		m.addAttribute("courseList",pages.getRows());
		m.addAttribute("page", pages);
		return "/course/courseManagementList";
	}
	
	@RequestMapping(value="/addCourse.action",method=RequestMethod.GET)
	public String addCourse(Model m){
		m.addAttribute("subjectList", ss.selectSubjectAll());
		return "/course/addCourse";
	}
	
	@RequestMapping(value="/addCourse.action",method=RequestMethod.POST)
	public String addCourse(Course course){
		cs.addCourse(course);
		return "redirect:/course/courseManagementList.action";
	}
	
	@RequestMapping(value="/deleteCourseById.action",method=RequestMethod.GET)
	public String deleteCourseById(String id){
		cs.deleteCourseById(id);
		return "redirect:/course/courseManagementList.action";
	}
	
	@RequestMapping(value="/editorCourse.action",method=RequestMethod.GET)
	public String editorCourse(Model m,String id){
		m.addAttribute("subjectList", ss.selectSubjectAll());
		m.addAttribute("course", cs.selectCourseById(id));
		return "/course/editorCourse";
	}
	
	@RequestMapping(value="/editorCourse.action",method=RequestMethod.POST)
	public String saveCourse(Course course){
		cs.updateCourseById(course);
		return "redirect:/course/courseManagementList.action";
	}
}
