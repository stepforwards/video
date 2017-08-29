package com.forward.video.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.forward.video.model.Data;
import com.forward.video.model.Result;
import com.forward.video.model.User;
import com.forward.video.service.UserService;

@Controller
@RequestMapping("/front/user")
public class FrontUserController {
	
	@Autowired
	UserService us;
	
	@RequestMapping("/regist.action")
	@ResponseBody
	public Result userRegist(User u){
		Result result = new Result();
		result.setSuccess(us.userRegist(u));
		result.setMessage("该邮箱已注册！");
		return result;
	}
	
	@RequestMapping("/login.action")
	@ResponseBody
	public Result userLogin(User u,HttpSession session){
		Result result = new Result();
		User user = us.userLogin(u);
		result.setSuccess(user == null ? false : true);
		result.setMessage("用户名或密码错误！");
		session.setAttribute("_front_user", user);
		session.setAttribute("user", user);
		return result;
	}
	
	
	@RequestMapping("/logout.action")
	public String userLogout(HttpSession session){
		session.invalidate();
		return "redirect:/front/indexFront.action";
	}
	
	
	@RequestMapping(value="/forgetpwd.action",method=RequestMethod.GET)
	public String userForgetpwd(){
		return "/front/user/forget_pwd";
	}
	
	@RequestMapping(value="/forgetpwd.action",method=RequestMethod.POST)
	public String captchaEqual(User u,Model m){
		if(us.captchaEqual(u)){
			m.addAttribute("email", u.getEmail());
			m.addAttribute("captcha", u.getCaptcha());
			return "/front/user/reset_pwd";
		}
		m.addAttribute("msg", "验证码不正确！");
		return "/front/user/forget_pwd";
	}
	
	@RequestMapping("/sendemail.action")
	@ResponseBody
	public Data sendemail(User u){
		Data data = new Data();
		data.setSuccess(us.sendEmail(u));
		data.setMessage("该邮箱不存在！");
		return data;
	}
	
	@RequestMapping("/resetpwd.action")
	public String resetPwd(User u){
		us.resetPwd(u);
		return "redirect:/front/indexFront.action";
	}
	
	@RequestMapping("/index.action")
	public String userInfo(){
		return "/front/user/index";
	}
	
	
	@RequestMapping(value="/profile.action",method=RequestMethod.GET)
	public String profile(){
		return "/front/user/profile";
	}
	
	@RequestMapping(value="/profile.action",method=RequestMethod.POST)
	public String updataProfile(User u,HttpSession session){
		session.setAttribute("user", us.updataProfile(u));
		return "redirect:/front/user/index.action";
	}
	
	@RequestMapping(value="/password.action",method=RequestMethod.GET)
	public String userPassword(){
		return "/front/user/password";
	}
	
	@RequestMapping(value="/password.action",method=RequestMethod.POST)
	public String userUpdataPWd(User u,Model m){
		if(us.updataPwd(u)){
			return "redirect:/front/logout.action";
		}
		m.addAttribute("pwdmsg", "密码错误！");
		return "/front/user/password";
	}
	
	@RequestMapping(value="/avatar.action",method=RequestMethod.GET)
	public String userAvatar(){
		return "/front/user/avatar";
	}
	
	@RequestMapping(value="/avatar.action",method=RequestMethod.POST)
	public String userUpdataAvatar(User u,MultipartFile image_file,HttpSession session) throws Exception{
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String extension = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String fileName = uuid + "." + extension;
		String pathname = "D:\\upload";
		u.setHeadUrl("upload/"+fileName);
		image_file.transferTo(new File(pathname+"\\"+fileName));
		session.setAttribute("user", us.updataAvatar(u));
		return "redirect:/front/user/index.action";
	}
}
