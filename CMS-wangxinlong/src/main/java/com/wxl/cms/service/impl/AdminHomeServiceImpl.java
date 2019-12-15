package com.wxl.cms.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.JsonResult;
import com.wxl.cms.dao.AdminHomeDao;
import com.wxl.cms.pojo.Article;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminHomeService;
import com.wxl.common.utils.EncodingUtil;

@Service
public class AdminHomeServiceImpl implements AdminHomeService{
	
	@Autowired
	private AdminHomeDao adminDao;
}
