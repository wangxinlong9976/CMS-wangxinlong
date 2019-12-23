package com.wxl.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.User;

public interface ArticleManagerDao {

	/**
	 * 
	 * @Title: selectChannel
	 * @Description: TODO		查询所有的频道
	 * @return    
	 * List<Channel>    
	 *
	 */
	List<Channel> selectChannel();

	/**
	 * 	
	 * @Title: selectCategory
	 * @Description: TODO		查询所有的分类  通过频道id
	 * @param channelId
	 * @return    
	 * List<Category>    
	 *
	 */
	List<Category> selectCategory(@Param("channelId")Integer channelId);

	/**
	 * 
	 * @Title: selectArticle
	 * @Description: TODO	查询所有文章
	 * @return    
	 * List<Article>    
	 *
	 */
	List<Article> selectArticle(ConditionsArticleManager con);

	Integer setHot(String id);

	int status(Integer article_id);
}
