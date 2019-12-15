package com.wxl.cms.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.common.JsonResult;
import com.wxl.cms.dao.AdminLoginManagerDao;
import com.wxl.cms.dao.ArticleManagerDao;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminLoginManagerService;
import com.wxl.common.utils.EncodingUtil;

@Service
public class AdminLoginManagerServiceImpl implements AdminLoginManagerService{
	
	@Autowired
	private AdminLoginManagerDao adminLoginManagerDao;
	
	@Override
	public JsonResult userIsExis(User user,HttpServletRequest request) {
		if(user==null) {
			return JsonResult.fail(500, "系统错误");
		}
		if("".equals(user.getUsername()) || "".equals(user.getUsername())) {
			return JsonResult.fail(300, "账号和密码不能为空!");
		}
		// TODO Auto-generated method stub
		try {
			user.setPassword(EncodingUtil.MD5Encoding(user.getPassword()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User userIsExis = adminLoginManagerDao.userIsExis(user);
		if(userIsExis==null) {
			return JsonResult.fail(204, "账号或密码输入有误!");
		}else if(userIsExis!=null){
			if("0".equals(user.getRole())) {
				return JsonResult.fail(206, "对不起,你不是管理员!");
			}
			if("1".equals(user.getLocked())) {
				return JsonResult.fail(205, "你的账号以被禁用,请联系<a>超级管理员</a>");
			}
			request.getSession().setAttribute(CmsConstant.adminSessionKey, user);
			return JsonResult.success();
		}else {
			return JsonResult.success();
		}
	}
}
