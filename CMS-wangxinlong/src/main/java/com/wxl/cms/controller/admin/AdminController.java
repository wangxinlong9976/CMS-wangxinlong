package com.wxl.cms.controller.admin;

import java.io.IOException;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.Conditions;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
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
	 * @Title: adminLogin
	 * @Description: TODO		管理员登陆处理器
	 * @param u
	 * @param request
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/login")
	public String adminLogin(User u,HttpServletRequest request) {
		boolean bool = adminService.userIsExis(u);
		if(bool) {
			return "redirect:/admin/";
		}else {
			request.getSession().setAttribute("userName", u.getUsername());
			return "redirect:/admin/home";
		}
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
	
	/**
	 * 	
	 * @Title: inUserManager
	 * @Description: TODO		用户管理模块 ---- 列表页面
	 * @param model
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/userManager")
	public String inUserManager(Model model,Conditions con) {
		
		PageHelper.startPage(con.getCurrPage(),5);
		List<User> list = adminService.selectUser(con);
		
		PageInfo<User> pageInfo = new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
//		pageInfo.getNavigatepageNums()
		model.addAttribute("con", con);
		return "admin/modules/admin_userManager_content";
	}
	
	/**
	 * 	
	 * @Title: locaedStatus
	 * @Description: TODO		用户管理   禁用和启用
	 * @param id
	 * @param status
	 * @return    
	 * Object    
	 *
	 */
	@ResponseBody
	@RequestMapping("/userManager/locked")
	public Object locaedStatus(@RequestParam("id")Integer id,@RequestParam("status")Integer status) {
		
		boolean bool = adminService.lockedStatus(id,status);
		
		return bool;
	}
	

	@RequestMapping("/articleManager")
	public String inArticleManager(Model model) {
		

		return "admin/modules/admin_articleManager_content";
	}
	
	/**
	 * 
	 * @Title: selectChannel
	 * @Description: TODO	查询所有的频道
	 * @param model
	 * @return    
	 * String    
	 *
	 */
	@ResponseBody
	@RequestMapping("/articleManager/selectChannel")
	public Object selectChannel() {
		
		List<Channel> channels = adminService.selectChannel();
		
		return channels;
	}
	
	/**
	 * 
	 * @Title: selectCategory
	 * @Description: TODO	通过 频道id  查询分类   实现二级联动
	 * @param model
	 * @param channelId
	 * @return    
	 * String    
	 *
	 */
	@ResponseBody
	@RequestMapping("/articleManager/selectCategory")
	public Object selectCategory(@RequestParam(defaultValue="")Integer channelId) {
		
		
		List<Category> categorys = adminService.selectCategory(channelId);
		
		return categorys;
	}
	
	/**
	 * 
	 * @Title: inpersonCenter
	 * @Description: TODO	将个人中心模块加入主模块
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/personCenter")
	public String inpersonCenter() {
		
		return "admin/modules/admin_personCenter_content";
	}
	
	/**
	 * 
	 * @Title: inSystemManager
	 * @Description: TODO	将系统设置模块加入主模块
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/systemManager")
	public String inSystemManager() {
		
		return "admin/modules/admin_systemManager_content";
	}
	
	/**
	 * 	
	 * @Title: checkUserInfo
	 * @Description: TODO	查看用户信息功能   
	 * @param model
	 * @param id			用户id
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/checkUserInfo")
	public String checkUserInfo(Model model,@RequestParam("id")Integer id) {
		User user = adminService.getUserById(id);
		model.addAttribute("user", user);
		return "admin/modules/admin_userManager_checkInfo_content";
	}

}
