package com.wxl.cms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.common.JsonResult;
import com.wxl.cms.dao.UserArticleDao;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private UserArticleDao userArticleDao;
	
	
	@Override
	public JsonResult addArticle(Article article) {
		// TODO Auto-generated method stub
		article.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		article.setUpdated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		article.setHits(0);
		article.setHot(0);
		article.setDeleted(0);
		article.setCommentCnt(0);
		article.setStatus(0);
		article.setUser_id(1);
		System.out.println("w1111111111111111111111"+article);
		int i = userArticleDao.addArticle(article);
		if(i>0) {
			return JsonResult.success();
		}
		return JsonResult.fail(400, "位置错误");
	}

	@Override
	public List<Channel> queryChannelAll() {
		// TODO Auto-generated method stub
		return userArticleDao.queryChannelAll();
	}

	@Override
	public List<Article> selectArticle(ConditionsArticleManager con,Integer id) {
		// TODO Auto-generated method stub
		return userArticleDao.selectArticle(con,id);
	}
	
	
}
