package com.wxl.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.common.JsonResult;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.service.ArticleService;
import com.wxl.cms.service.AdminArticleManagerService;

@Controller
@RequestMapping("/user/")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private AdminArticleManagerService adminArticleManagerService;
	
	@RequestMapping("/sendArticle")
	public String sendArticle(Model model) {
		List<Channel> list = articleService.queryChannelAll();
		model.addAttribute("channels", list);
		return "/forward/user_sendArticle";
	}
	
	@ResponseBody
	@RequestMapping("/userPersonCenter/addArticle")
	public JsonResult addArticle(Article article) {
		System.out.println(article+"-*-*-*-*-*-*");
		JsonResult jsonResult = articleService.addArticle(article);
		return jsonResult;
	}
	
	@ResponseBody
	@RequestMapping("/userPersonCenter/queryCategory")
	public Object queryCategoryById(Integer channelId) {
		List<Category> selectCategory = adminArticleManagerService.selectCategory(channelId);
		return selectCategory;
	}
	
	
	@RequestMapping("/article/myArticle")
	public String myArticle(Model model,ConditionsArticleManager con,Integer user_id) {
		List<Article> list = articleService.selectArticle(con,user_id);
		System.out.println(list);
		List<Channel> channels = adminArticleManagerService.selectChannel();
		if(con!=null && con.getChannel()!=null && con.getChannel().equals("")){
			List<Category> categorys = adminArticleManagerService.selectCategory(con.getChannel());
			model.addAttribute("categorys", categorys);
		}
		model.addAttribute("list", list);
		
		model.addAttribute("channels", channels);
		return "/forward/user_myArticle";
	}
	
}
