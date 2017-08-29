package com.forward.video.service;

import java.util.List;

import com.forward.video.model.Course;
import com.forward.video.util.Page;

public interface CourseService {
	
	List<Course> selectCourseAll();

	@SuppressWarnings("rawtypes")
	Page loadPage(int currentPage);

	void addCourse(Course course);

	void deleteCourseById(String id);

	Course selectCourseById(String id);

	void updateCourseById(Course course);

	List<Course> selectCourseBySubjectId(String subjectId);
}
