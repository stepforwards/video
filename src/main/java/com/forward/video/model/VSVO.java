package com.forward.video.model;

public class VSVO {
	private String videoId;
	private String subjectId;
	
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	@Override
	public String toString() {
		return "VSVO [videoId=" + videoId + ", subjectId=" + subjectId + "]";
	}

}
