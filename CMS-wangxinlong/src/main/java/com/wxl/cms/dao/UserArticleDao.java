package com.wxl.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;

public interface UserArticleDao {

	List<Article> queryAllArticle();

	int addArticle(Article article);

	List<Channel> queryChannelAll();

	List<Article> selectArticle(@Param("con")ConditionsArticleManager con,@Param("id")Integer id);

	List<Article> queryNewArticle();

	List<Channel> queryChannels();

	List<Category> queryCategorys(@Param("id")Integer id);

	List<Article> queryArticleByChannelAndCategory(@Param("channel_id")Integer channel_id,@Param("category_id")Integer category_id);

	Article queryArticlByArticleId(Integer article_id);

	Integer queryCategoryId(Integer id);

	List<Article> queryArticleLike(Integer cid);

	Integer userHasCollect(@Param("user_id")int user_id, @Param("article_id")Integer article_id);

}
