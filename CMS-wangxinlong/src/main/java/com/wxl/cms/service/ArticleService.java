package com.wxl.cms.service;

import java.util.List;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.common.JsonResult;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Channel;

public interface ArticleService {

	JsonResult addArticle(Article article);

	List<Channel> queryChannelAll();

	List<Article> selectArticle(ConditionsArticleManager con, Integer user_id);

}
