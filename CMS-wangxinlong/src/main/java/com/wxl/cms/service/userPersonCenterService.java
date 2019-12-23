package com.wxl.cms.service;

import java.util.List;

import com.wxl.cms.pojo.Article;

public interface userPersonCenterService {

	List<Article> queryMyCollet(Integer id);


	Integer collect(Integer article_id, Integer user_id);


	Integer unCollect(Integer article_id, Integer id);

}
