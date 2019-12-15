package com.wxl.cms.controller.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxl.cms.common.Conditions;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminHomeService;
import com.wxl.common.utils.EncodingUtil;

@Controller
@RequestMapping("/admin/")
public class AdminHomeController {
	
	@Autowired
	private AdminHomeService adminService;
	/**
	 * 	
	 * @Title: select
	 * @Description: TODO		直接跳转到后台登陆界面
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/")
	public String select() {
		
		return "admin/admin_login";
	}
	
	
	
	/**
	 * 
	 * @Title: inHome
	 * @Description: TODO	进入后台主页面
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/home")
	public String inHome() {
		
		return "admin/admin_home";
	}
	
	
	/**
	 * 
	 * @Title: inWelcome
	 * @Description: TODO		进入主页面后会发一个Ajax  到这里   然后返回一个html页面
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/welcome")
	public String inWelcome() {
		
		return "admin/modules/admin_welcome_content";
	}
	
	
	
	
	

	
	
//	@ResponseBody
//	@RequestMapping("/articleImg")
//	public String inArticleImg(Model model,@RequestParam("file")MultipartFile file) {
//		List<Article> list = adminService.selectArticle();
//
//		return "admin/modules/admin_articleManager_content";
//	}
	
	
	
	
	
	

}
