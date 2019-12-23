package com.wxl.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.pojo.Comment;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.UserContentService;

@Controller
@RequestMapping("/user/")
public class ContentController {

	@Autowired
	private UserContentService userContentService;
	
	@RequestMapping("/content")
	public String appendContent(Model model,Integer article_id) {
		List<Comment> list = userContentService.queryContentByArticle(article_id);
		model.addAttribute("list", list);
		return "/forward/user_content";
	}
	
	@RequestMapping("/content/appendContent")
	public String appendContent(Integer article_id,String content,HttpSession session) {
		Comment comment = new Comment();
		comment.setArticleid(article_id);
		comment.setContent(content);
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		comment.setCreated(new Date());
		User user = (User)session.getAttribute(CmsConstant.userSessionKey);
		comment.setUserid(user.getId());
		Integer com = userContentService.appednContent(comment);
		return "redirect:/user/content?article_id="+article_id;
	}
}
