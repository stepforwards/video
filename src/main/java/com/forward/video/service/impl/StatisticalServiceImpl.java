package com.forward.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video.mapper.VideoMapper;
import com.forward.video.model.Video;
import com.forward.video.service.StatisticalService;

@Service
public class StatisticalServiceImpl implements StatisticalService {
	
	@Autowired
	VideoMapper vm;
	@Override
	public List<Video> courseStatisticalAnalysis() {
		
		return vm.courseStatisticalAnalysis();
	}

}
