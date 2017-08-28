package com.forward.video.model;

public class SubjectPlaysJson {
	
	private String courseNames;
	private String coursePlays;
	public String getCourseNames() {
		return courseNames;
	}
	public void setCourseNames(String courseNames) {
		this.courseNames = courseNames;
	}
	public String getCoursePlays() {
		return coursePlays;
	}
	public void setCoursePlays(String coursePlays) {
		this.coursePlays = coursePlays;
	}
	@Override
	public String toString() {
		return "SubjectPlaysJson [courseNames=" + courseNames + ", coursePlays=" + coursePlays + "]";
	}
	
}
