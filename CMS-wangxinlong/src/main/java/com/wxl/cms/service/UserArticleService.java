package com.wxl.cms.service;

import java.util.List;

import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;

public interface UserArticleService {

	List<Article> queryAllArticle();

	List<Article> queryNewArticle();

	List<Channel> queryChannels();

	List<Category> queryCategorys(Integer channel_id);

	List<Article> queryArticleByChannelAndCategory(Integer channel_id, Integer category_id);

	Article queryArticlByArticleId(Integer article_id);

	Integer queryCategoryId(Integer article_id);

	List<Article> queryArticleLike(Integer cid);

	Integer userHasCollect(int user_id, Integer article_id);

}
