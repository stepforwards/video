package com.forward.video.service;

import java.util.List;

import com.forward.video.model.KeyVO;
import com.forward.video.model.Video;
import com.forward.video.util.Page;

public interface VideoService {
	
	List<Video> selectVideoListByKey(KeyVO kvo);

	void saveVideo(Video v);

	void deleteVideoById(String id);

	Video selectVideoById(String id);

	void updateVideoById(Video v);

	void deleteVideoByQuery(String[] id);

	@SuppressWarnings("rawtypes")
	Page loadPage(KeyVO kvo, int currentPage);
}
