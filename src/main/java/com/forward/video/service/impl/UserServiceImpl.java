package com.forward.video.service.impl;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video.mapper.UserMapper;
import com.forward.video.model.User;
import com.forward.video.model.UserExample;
import com.forward.video.service.UserService;
import com.forward.video.util.MailUtil;
import com.forward.video.util.MyCaptcha;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper um;

	@Override
	public boolean userRegist(User u) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(u.getEmail());
		if(um.selectByExample(example).isEmpty()){
			u.setInsertTime(new Date(System.currentTimeMillis()));
			um.insertSelective(u);
			return true;
		}
		return false;
	}

	@Override
	public User userLogin(User u) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		if(um.selectByExample(example).isEmpty()){
			return null;
		}
		return um.selectByExample(example).get(0);
	}

	@Override
	public boolean sendEmail(User u) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(u.getEmail());
		if(um.selectByExample(example).isEmpty()){
			return false;
		}
		String captcha = MyCaptcha.createCaptcha();
		u.setCaptcha(captcha);
		um.updateByExampleSelective(u, example);
		try {
			MailUtil.send(u.getEmail(), "Video找回密码", "验证码："+captcha+"\r\n如果不是本人请忽略此邮件!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean captchaEqual(User u) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		if(um.selectByExample(example).isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public void resetPwd(User u) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		um.updateByExampleSelective(u, example);
	}

	@Override
	public User updataProfile(User u) {
		u.setUpdateTime(new Date(System.currentTimeMillis()));
		um.updateByPrimaryKeySelective(u);
		return um.selectByPrimaryKey(u.getId());
	}

	@Override
	public boolean updataPwd(User u) {
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(u.getId()).andPasswordEqualTo(u.getOldPassword());
		List<User> list = um.selectByExample(example);
		if(list.isEmpty()){
			return false;
		}
		u.setPwdNMD5(u.getNewPassword());
		um.updateByExampleSelective(u, example);
		return true;
	}

	@Override
	public User updataAvatar(User u) {
		um.updateByPrimaryKeySelective(u);
		return um.selectByPrimaryKey(u.getId());
	}
	
}
