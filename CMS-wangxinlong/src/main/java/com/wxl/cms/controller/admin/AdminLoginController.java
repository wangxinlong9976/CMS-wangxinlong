package com.wxl.cms.controller.admin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxl.cms.common.JsonResult;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminHomeService;
import com.wxl.cms.service.AdminLoginManagerService;
import com.wxl.cms.service.ArticleService;
import com.wxl.common.utils.EncodingUtil;

@Controller
@RequestMapping("/admin/")
public class AdminLoginController {
	
	@Autowired
	private AdminLoginManagerService adminLoginManagerService;
	
	/**
	 * 
	 * @Title: adminLogin
	 * @Description: TODO		管理员登陆处理器
	 * @param u
	 * @param request
	 * @return    
	 * String    
	 *
	 */
	@ResponseBody
	@RequestMapping("/login")
	public JsonResult adminLogin(User user,HttpServletRequest request) {
		
		return adminLoginManagerService.userIsExis(user,request);
	}
	
	
	
}
