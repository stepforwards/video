package com.forward.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.forward.video.mapper.AdminMapper;
import com.forward.video.model.Admin;
import com.forward.video.model.AdminExample;
import com.forward.video.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper am;
	@Override
	public Admin login(String username, String password) {
		
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		AdminExample example = new AdminExample();
		example.createCriteria().andLoginNameEqualTo(username).andLoginPwdEqualTo(password);
		List<Admin> admin = am.selectByExample(example);
		for(Admin e : admin){
			return e;
		}
		return null;
	}

}
