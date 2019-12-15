package com.wxl.cms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxl.cms.service.AdminHomeService;
import com.wxl.cms.service.AdminSettingService;
import com.wxl.cms.service.ArticleService;

@Controller
@RequestMapping("/admin/")
public class SettingManagerController {
	
	@Autowired
	private AdminSettingService adminService;
	
	
}
