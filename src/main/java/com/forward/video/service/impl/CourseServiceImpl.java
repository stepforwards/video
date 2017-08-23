package com.forward.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video.mapper.CourseMapper;
import com.forward.video.model.Course;
import com.forward.video.service.CourseService;
import com.forward.video.util.Page;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseMapper cm;
	
	@Override
	public List<Course> selectCourseAll() {
		return cm.selectByExample(null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(int currentPage) {
		Page<Course> page = new Page<>();
		int currentStrip = (currentPage-1)*5;
		page.setPage(currentPage);
		page.setSize(5);
		page.setTotal(cm.countByExample(null));
		page.setRows(cm.selectCourseAllInfo(currentStrip));
		return page;
	}

	@Override
	public void addCourse(Course course) {
		cm.insertSelective(course);
	}

	@Override
	public void deleteCourseById(String id) {
		cm.deleteByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public Course selectCourseById(String id) {
		return cm.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public void updateCourseById(Course course) {
		cm.updateByPrimaryKeySelective(course);
	}

}
