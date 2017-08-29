package com.forward.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video.mapper.SubjectMapper;
import com.forward.video.model.Subject;
import com.forward.video.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectMapper sm;
	
	@Override
	public List<Subject> selectSubjectAll() {
		return sm.selectByExample(null);
	}

	@Override
	public Subject selectSubjectById(String subjectId) {
		return sm.selectByPrimaryKey(Integer.parseInt(subjectId));
	}

}
