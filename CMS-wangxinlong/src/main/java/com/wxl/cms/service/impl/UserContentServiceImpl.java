package com.wxl.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.dao.UserContentDao;
import com.wxl.cms.pojo.Comment;
import com.wxl.cms.service.UserContentService;

@Service
public class UserContentServiceImpl implements UserContentService{

	@Autowired
	private UserContentDao userContentDao;

	@Override
	public List<Comment> queryContentByArticle(Integer article_id) {
		// TODO Auto-generated method stub
		return userContentDao.queryContentByArticle(article_id);
	}

	@Override
	public Integer appednContent(Comment comment) {
		// TODO Auto-generated method stub
		return userContentDao.appednContent(comment);
	}
}
