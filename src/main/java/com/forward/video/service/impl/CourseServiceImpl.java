package com.forward.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video.mapper.CourseMapper;
import com.forward.video.model.Course;
import com.forward.video.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseMapper cm;
	
	@Override
	public List<Course> selectCourseAll() {
		return cm.selectByExample(null);
	}

}
