package com.forward.video.service;

import java.util.List;

import com.forward.video.model.KeyVO;
import com.forward.video.model.Speaker;
import com.forward.video.util.Page;

public interface SpeakerService {
	List<Speaker> selectSpeakerAll();

	void addSpeaker(Speaker speaker);

	void deleteSpeakerById(String id);

	Speaker selectSpeakerById(String id);

	void updateSpeakerById(Speaker speaker);

	List<Speaker> selectSpeakerByKey(KeyVO kvo);

	@SuppressWarnings("rawtypes")
	Page loadPage(KeyVO kvo, int page);
}
