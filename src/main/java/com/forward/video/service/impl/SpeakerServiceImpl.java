package com.forward.video.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video.mapper.SpeakerMapper;
import com.forward.video.model.KeyVO;
import com.forward.video.model.Speaker;
import com.forward.video.model.SpeakerExample;
import com.forward.video.service.SpeakerService;
import com.forward.video.util.Page;

@Service
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	SpeakerMapper sm;
	
	@Override
	public List<Speaker> selectSpeakerAll() {
		return sm.selectByExample(null);
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		speaker.setInsertTime(new Date(System.currentTimeMillis()));
		sm.insertSelective(speaker);
	}

	@Override
	public void deleteSpeakerById(String id) {
		sm.deleteByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public Speaker selectSpeakerById(String id) {
		return sm.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public void updateSpeakerById(Speaker speaker) {
		speaker.setUpdateTime(new Date(System.currentTimeMillis()));
		sm.updateByPrimaryKeySelective(speaker);
	}

	@Override
	public List<Speaker> selectSpeakerByKey(KeyVO kvo) {
		SpeakerExample example = new SpeakerExample();
		example.createCriteria().andSpeakerNameLike("%"+kvo.getSpeakerName()+"%").andSpeakerJobLike("%"+kvo.getSpeakerJob()+"%");
		return sm.selectByExample(example);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(KeyVO kvo, int currentPage) {
		SpeakerExample example = new SpeakerExample();
		example.createCriteria().andSpeakerNameLike("%"+kvo.getSpeakerName()+"%").andSpeakerJobLike("%"+kvo.getSpeakerJob()+"%");
		kvo.setCurrentStrip((currentPage-1)*5);
		Page<Speaker> page = new Page<>();
		page.setPage(currentPage);
		page.setSize(5);
		page.setTotal(sm.countByExample(example));
		page.setRows(sm.selectByKeylimit(kvo));
		return page;
	}

}
