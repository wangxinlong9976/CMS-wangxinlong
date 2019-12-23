package com.wxl.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wxl.cms.dao.UserPersonCenterDao;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.service.UserArticleService;
import com.wxl.cms.service.userPersonCenterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class TestMain {
	
	@Autowired
	private UserArticleService userArticleService;
	@Autowired
	private UserPersonCenterDao dao;
	
	@Test
	public void selectArticle() {
		List<Article> queryAllArticle = userArticleService.queryAllArticle();
		for (Article article : queryAllArticle) {
			System.out.println(article);
		}
	}
	
	@Test
	public void queryMyCollect() {
		List<Article> listMyCollect = dao.queryMyCollect(1);
		for (Article article : listMyCollect) {
			System.out.println(article);
		}
	}
}
