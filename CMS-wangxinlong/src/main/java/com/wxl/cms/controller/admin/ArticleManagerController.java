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
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.service.AdminArticleManagerService;
import com.wxl.cms.service.AdminHomeService;
import com.wxl.cms.service.ArticleService;

@Controller
@RequestMapping("/admin/")
public class ArticleManagerController {
	
	@Autowired
	private AdminArticleManagerService adminArticleManagerService;
	
	/**
	 * 
	 * @Title: inArticleManager
	 * @Description: TODO	进入文章管理模块的处理器
	 * @param model
	 * @return    
	 * String    
	 *
	 */
	@RequestMapping("/articleManager")
	public String inArticleManager(Model model,ConditionsArticleManager con) {
		System.out.println("-+++++"+con);
		PageHelper.startPage(con.getCurrPage(),3);
		List<Article> list = adminArticleManagerService.selectArticle(con);
		
		List<Channel> channels = adminArticleManagerService.selectChannel();
		if(con!=null && con.getChannel()!=null && con.getChannel().equals("")){
			List<Category> categorys = adminArticleManagerService.selectCategory(con.getChannel());
			model.addAttribute("categorys", categorys);
		}
		PageInfo<Article> pageInfo = new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("con", con);
		model.addAttribute("channels", channels);
		model.addAttribute("pageInfo", pageInfo);
		
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
		
		List<Channel> channels = adminArticleManagerService.selectChannel();
		
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
		
		
		List<Category> categorys = adminArticleManagerService.selectCategory(channelId);
		
		return categorys;
	}
	
	
	
	@RequestMapping("/articleManager/setHot")
	public String setHot(String article_id) {
		Integer status = adminArticleManagerService.setHot(article_id);
		return "redirect:/admin/articleManager";
	}

	@ResponseBody
	@RequestMapping("/articleManager/status")
	public boolean status(Integer article_id) {
		boolean bool = adminArticleManagerService.status(article_id);
		return bool;
	}
}
