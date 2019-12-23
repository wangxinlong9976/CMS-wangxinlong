package com.wxl.cms.dao;

import java.util.List;

import com.wxl.cms.pojo.Comment;

public interface UserContentDao {

	List<Comment> queryContentByArticle(Integer article_id);

	Integer appednContent(Comment comment);

}
