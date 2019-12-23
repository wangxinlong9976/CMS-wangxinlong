package com.wxl.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.dao.UserArticleDao;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.service.UserArticleService;

@Service
public class UserArticleServiceImpl implements UserArticleService{
	
	@Autowired
	private UserArticleDao userArticleDao;

	@Override
	public List<Article> queryAllArticle() {
		// TODO Auto-generated method stub
		return userArticleDao.queryAllArticle();
	}

	@Override
	public List<Article> queryNewArticle() {
		// TODO Auto-generated method stub
		return userArticleDao.queryNewArticle();
	}

	@Override
	public List<Channel> queryChannels() {
		// TODO Auto-generated method stub
		return userArticleDao.queryChannels();
	}

	@Override
	public List<Category> queryCategorys(Integer channel_id) {
		// TODO Auto-generated method stub
		return userArticleDao.queryCategorys(channel_id);
	}

	@Override
	public List<Article> queryArticleByChannelAndCategory(Integer channel_id, Integer category_id) {
		// TODO Auto-generated method stub
		return userArticleDao.queryArticleByChannelAndCategory(channel_id,category_id);
	}

	@Override
	public Article queryArticlByArticleId(Integer article_id) {
		// TODO Auto-generated method stub
		return userArticleDao.queryArticlByArticleId(article_id);
	}

	@Override
	public Integer queryCategoryId(Integer id) {
		// TODO Auto-generated method stub
		return userArticleDao.queryCategoryId(id);
	}

	@Override
	public List<Article> queryArticleLike(Integer cid) {
		// TODO Auto-generated method stub
		return userArticleDao.queryArticleLike(cid);
	}

	@Override
	public Integer userHasCollect(int user_id, Integer article_id) {
		// TODO Auto-generated method stub
		return userArticleDao.userHasCollect(user_id,article_id);
	}
}
