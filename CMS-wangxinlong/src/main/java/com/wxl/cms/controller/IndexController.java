package com.wxl.cms.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.UserArticleService;
import com.wxl.cms.service.UserService;

@Controller
@RequestMapping("/user/")
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private UserArticleService userArticleService;
	
	@RequestMapping("/toIndex/{channel_id}/0.html")
	public String toIndex(Model model,@PathVariable()Integer channel_id) {
		model.addAttribute("channel_id", channel_id);
		/**   轮播图    **/
		
		
		/**   全部频道    **/
		List<Channel> listChannel = userArticleService.queryChannels();
		model.addAttribute("listChannel", listChannel);
		
		/**   全部分类    **/
		if(channel_id!=null && channel_id!=0) {
			List<Category> listCategorys = userArticleService.queryCategorys(channel_id);
			model.addAttribute("listCategorys", listCategorys);
		}
		
		
		/**   热点文章    **/
//		PageHelper.startPage(currPage,5);
		List<Article> articleList = userArticleService.queryAllArticle();
//		PageInfo<Article> pageInfo = new PageInfo<>(articleList);
		model.addAttribute("articleList", articleList);
//		model.addAttribute("pageInfo", pageInfo);
		
		/**   最新文章    **/
		
		List<Article> articleListNew = userArticleService.queryNewArticle();
		model.addAttribute("articleListNew", articleListNew);
		return "index";
	}
	
	@RequestMapping("/toIndex/{channel_id}/{category_id}/{currPage}.html")
	public String toIndexType(Model model,@PathVariable()Integer channel_id,@PathVariable()Integer category_id,@PathVariable()Integer currPage) {
		model.addAttribute("channel", channel_id);
		model.addAttribute("category_id", category_id);
		model.addAttribute("currPage", currPage);
//		model.addAttribute("", attributeValue)
		/**   全部频道    **/
		List<Channel> listChannel = userArticleService.queryChannels();
		model.addAttribute("listChannel", listChannel);
		/**   全部分类    **/
		List<Category> listCategorys = userArticleService.queryCategorys(channel_id);
		model.addAttribute("listCategorys", listCategorys);
		/**   分类下的文章    **/
		System.out.println("currPage:  "+currPage);
		if(currPage==null || currPage==0) {
			currPage=1;
		}
		PageHelper.startPage(currPage,5);
		List<Article> articleList = userArticleService.queryArticleByChannelAndCategory(channel_id,category_id);
		model.addAttribute("articleList", articleList);
		
		PageInfo<Article> pageInfo = new PageInfo<>(articleList);
		model.addAttribute("pageInfo", pageInfo);
		/**   最新文章    **/
		List<Article> articleListNew = userArticleService.queryNewArticle();
		model.addAttribute("articleListNew", articleListNew);
		/**   轮播图    **/
		
		return "index";
	}
	
	@RequestMapping("/article/{article_id}.html")
	public String articleDeatil(Model model,@PathVariable()Integer article_id,HttpSession session) {
		Article article = userArticleService.queryArticlByArticleId(article_id);
		model.addAttribute("article", article);
//		userArticleService.queryAtricleLikeKeyName();
		Integer cid = userArticleService.queryCategoryId(article_id);
		System.out.println(cid);
		List<Article> listArticle = userArticleService.queryArticleLike(cid);
		model.addAttribute("articleList", listArticle);
		User user = (User)session.getAttribute(CmsConstant.userSessionKey);
		Integer isCollect = userArticleService.userHasCollect(user.getId(),article_id);
		model.addAttribute("isCollect", isCollect);
		System.out.println(listArticle);
		return "/forward/article_detail";
	}
}
