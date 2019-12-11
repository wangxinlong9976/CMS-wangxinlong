package com.wxl.cms.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
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
}
