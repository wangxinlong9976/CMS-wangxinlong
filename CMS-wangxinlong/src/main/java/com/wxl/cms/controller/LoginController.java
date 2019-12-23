package com.wxl.cms.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.common.JsonResult;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.UserLoginService;

@Controller
@RequestMapping("/user/")
public class LoginController {
	
	@Autowired
	private UserLoginService UserLoginService;
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		
		return "/forward/user_login";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public JsonResult login(User user,Integer memory,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("------------"+user);
		JsonResult res = UserLoginService.userIsExis(user,request,response);
		
		return res;
	}
	
	@RequestMapping("/logout")
	public String outLogin(HttpSession session) {
		session.removeAttribute(CmsConstant.userSessionKey);
		return "/forward/user_login";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "/forward/user_register";
	}
	
	@RequestMapping("/register")
	public JsonResult register(User user) {
		JsonResult jsonResult = UserLoginService.registerUser(user);
		return jsonResult;	
	}
	
	@RequestMapping("/register/regUserName")
	public Object regUserName(String username) {
		
		return false;
	}
}
