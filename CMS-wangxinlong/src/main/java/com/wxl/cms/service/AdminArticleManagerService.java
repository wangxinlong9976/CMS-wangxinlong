package com.wxl.cms.service;

import java.util.List;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;

public interface AdminArticleManagerService {
	
	/**
	 * 
	 * @Title: selectChannel
	 * @Description: TODO		查询全部的频道
	 * @return    
	 * List<Channel>    
	 *
	 */
	List<Channel> selectChannel();

	/**
	 * 
	 * @Title: selectCategory
	 * @Description: TODO	通过频道(channel的id查询所有的分类)
	 * @return    
	 * List<Category>    
	 *
	 */
	List<Category> selectCategory(Integer channelId);
	
	/**
	 * 
	 * @Title: selectArticle
	 * @Description: TODO		查询所有文章
	 * @return    
	 * List<Article>    
	 *
	 */
	List<Article> selectArticle(ConditionsArticleManager con);

	Integer setHot(String article_id);

	boolean status(Integer article_id);
}
