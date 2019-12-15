package com.wxl.cms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminHomeService;
import com.wxl.cms.service.AdminUserManagerService;
import com.wxl.cms.service.ArticleService;

@Controller
@RequestMapping("/admin/")
public class UserManagerController {
	
	@Autowired
	private AdminUserManagerService adminUserManagerService;
	
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
		List<User> list = adminUserManagerService.selectUser(con);
		
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
		
		boolean bool = adminUserManagerService.lockedStatus(id,status);
		
		return bool;
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
	@RequestMapping("/userManager/checkUserInfo")
	public String checkUserInfo(Model model,@RequestParam("id")Integer id) {
		User user = adminUserManagerService.getUserById(id);
		model.addAttribute("user", user);
		return "admin/modules/admin_userManager_checkInfo_content";
	}
	
}
