package com.wxl.cms.service;

import java.util.List;

import com.wxl.cms.pojo.Comment;

public interface UserContentService {

	List<Comment> queryContentByArticle(Integer article_id);

	Integer appednContent(Comment comment);

}
