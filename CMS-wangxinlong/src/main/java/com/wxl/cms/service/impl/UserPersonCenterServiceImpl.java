package com.wxl.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.dao.UserPersonCenterDao;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.service.userPersonCenterService;

@Service
public class UserPersonCenterServiceImpl implements userPersonCenterService{
	
	@Autowired
	private UserPersonCenterDao userPersonCenterDao;

	@Override
	public List<Article> queryMyCollet(Integer id) {
		// TODO Auto-generated method stub
		
		return userPersonCenterDao.queryMyCollect(id);
	}

	@Override
	public Integer collect(Integer article_id, Integer user_id) {
		// TODO Auto-generated method stub
		return userPersonCenterDao.collect(article_id,user_id);
	}

	@Override
	public Integer unCollect(Integer article_id, Integer user_id) {
		// TODO Auto-generated method stub
		return userPersonCenterDao.unCollect(article_id,user_id);
	}
	
	
}
