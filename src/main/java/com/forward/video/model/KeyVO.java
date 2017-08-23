package com.forward.video.model;

public class KeyVO {
	private String videoTitle = "";
	private Integer speaker;
	private Integer course;
	private Integer currentStrip;
	private String speakerName = "";
	private String speakerJob = "";
	
	
	
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName == null ? "" : speakerName;
	}
	public String getSpeakerJob() {
		return speakerJob;
	}
	public void setSpeakerJob(String speakerJob) {
		this.speakerJob = speakerJob == null ? "" : speakerJob;
	}
	public Integer getCurrentStrip() {
		return currentStrip;
	}
	public void setCurrentStrip(Integer currentStrip) {
		this.currentStrip = currentStrip;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle == null ? "" : videoTitle;
	}
	public Integer getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Integer speaker) {
		this.speaker = speaker;
	}
	public Integer getCourse() {
		return course;
	}
	public void setCourse(Integer course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "KeyVO [videoTitle=" + videoTitle + ", speaker=" + speaker + ", course=" + course + ", currentStrip="
				+ currentStrip + ", speakerName=" + speakerName + ", speakerJob=" + speakerJob + "]";
	}
	
}
