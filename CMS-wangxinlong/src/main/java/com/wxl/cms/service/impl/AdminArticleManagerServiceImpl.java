package com.wxl.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.controller.admin.ArticleManagerController;
import com.wxl.cms.dao.ArticleManagerDao;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.service.AdminArticleManagerService;

@Service
public class AdminArticleManagerServiceImpl implements AdminArticleManagerService{
	
	@Autowired
	private ArticleManagerDao articleManagerDao;
	
	@Override
	public List<Channel> selectChannel() {
		// TODO Auto-generated method stub
		return articleManagerDao.selectChannel();
	}

	@Override
	public List<Category> selectCategory(Integer channelId) {
		// TODO Auto-generated method stub
		return articleManagerDao.selectCategory(channelId);
	}

	@Override
	public List<Article> selectArticle(ConditionsArticleManager con) {
		// TODO Auto-generated method stub
		System.out.println(con);
		return articleManagerDao.selectArticle(con);
	}

	@Override
	public Integer setHot(String article_id) {
		// TODO Auto-generated method stub
		return articleManagerDao.setHot(article_id);
	}

	@Override
	public boolean status(Integer article_id) {
		// TODO Auto-generated method stub
		return articleManagerDao.status(article_id)>0;
	}
}
