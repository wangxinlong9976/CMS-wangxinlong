package com.wxl.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.userPersonCenterService;

@Controller
@RequestMapping("/user/")
public class UserPersonCenterController {
	
	@Autowired
	private userPersonCenterService userPersonCenterService;
	
	@RequestMapping("/userPersonCenter")
	public String toPersonCenter(Model model) {
		
		return "/forward/user_personCenter";
	}
	
	@RequestMapping("/userPersonCenter/myCollect")
	public String myCollect(HttpSession session,Model model) {
		User user = (User)session.getAttribute(CmsConstant.userSessionKey);
		List<Article> listMyCollect = userPersonCenterService.queryMyCollet(user.getId());
		model.addAttribute("listMyCollect", listMyCollect);
		System.out.println(listMyCollect);
		return "/forward/user_myCollect";
	}
	
	@RequestMapping("/userPersonCenter/myCollect/collect")
	public String collect(Integer article_id,HttpSession session) {
		User obj = (User)session.getAttribute(CmsConstant.userSessionKey);
		Integer bool = userPersonCenterService.collect(article_id,obj.getId());
		return "redirect:/user/article/"+article_id+".html";
	}
	
	@RequestMapping("/userPersonCenter/myCollect/unCollect")
	public String unCollect(Integer article_id,HttpSession session) {
		User obj = (User)session.getAttribute(CmsConstant.userSessionKey);
		Integer bool = userPersonCenterService.unCollect(article_id,obj.getId());
		
		return "redirect:/user/article/"+article_id+".html";
	}
}
