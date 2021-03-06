package com.forward.video.service.impl;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video.mapper.VideoMapper;
import com.forward.video.model.KeyVO;
import com.forward.video.model.Video;
import com.forward.video.model.VideoExample;
import com.forward.video.service.VideoService;
import com.forward.video.util.Page;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoMapper vm;
	
	@Override
	public List<Video> selectVideoListByKey(KeyVO kvo) {
		return vm.selectVideoListByKey(kvo);
	}
	
	@Override
	public void saveVideo(Video v) {
		v.setInsertTime(new Date(System.currentTimeMillis()));
		vm.insertSelective(v);
	}
	
	@Override
	public void deleteVideoById(String id) {
		vm.deleteByPrimaryKey(Integer.parseInt(id));
	}
	
	@Override
	public Video selectVideoById(String id) {
		return vm.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public void updateVideoById(Video v) {
		v.setUpdateTime(new Date(System.currentTimeMillis()));
		vm.updateByPrimaryKeySelective(v);
	}

	@Override
	public void deleteVideoByQuery(String[] id) {
		for(String e : id ){
			vm.deleteByPrimaryKey(Integer.parseInt(e));
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(KeyVO kvo, int currentPage) {
		Page<Video> page = new Page<>();
		kvo.setCurrentStrip((currentPage-1)*5);
		page.setTotal(vm.selectVideoListByKeyCount(kvo));
		page.setRows(vm.selectVideoListByKey(kvo));
		page.setSize(5);
		page.setPage(currentPage);
		return page;
	}

	@Override
	public List<Video> selectVideobyCourseIds(Integer[] courseIds) {
		List<Integer> asList = Arrays.asList(courseIds);
		VideoExample example = new VideoExample();
		example.createCriteria().andCourseIdIn(asList);
		return vm.selectByExample(example);
	}

	@Override
	public void updateVideoStateById(String videoId) {
		Video video = vm.selectByPrimaryKey(Integer.parseInt(videoId));
		video.setVideoPlayTimes(video.getVideoPlayTimes()+1);
		vm.updateByPrimaryKeySelective(video);
		
	}

	@Override
	public List<Video> selectVideobyCourseId(Integer integer) {
		VideoExample example = new VideoExample();
		example.createCriteria().andCourseIdEqualTo(integer);
		return vm.selectByExample(example);
	}

	@Override
	public Video selectVideoByIdAllInfo(String videoId) {
		return vm.selectVideoByIdAllInfo(videoId);
	}

	@Override
	public List<Video> selectVideobyCourseIds(Integer courseId) {
		return vm.selectVideoByCourseIds(courseId);
	}

}
