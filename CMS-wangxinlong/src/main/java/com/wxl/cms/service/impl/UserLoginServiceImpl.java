package com.wxl.cms.service.impl;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.common.JsonResult;
import com.wxl.cms.dao.UserLoginDao;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.UserLoginService;
import com.wxl.cms.service.UserService;
import com.wxl.common.utils.EncodingUtil;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	private UserLoginDao userLoginDao;

	@Override
	public List<User> selectUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertOneUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertBatchUser(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOneUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteBatchUser(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonResult userIsExis(User user,HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pwd = user.getPassword();
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
		
		User userIsExis = userLoginDao.userIsExis(user);
		System.out.println(userIsExis);
		if(userIsExis==null) {
			return JsonResult.fail(204, "账号或密码输入有误!");
		}else if(userIsExis!=null){
//			if("0".equals(user.getRole())) {
//				return JsonResult.fail(206, "对不起,你不是管理员!");
//			}
			if("1".equals(user.getLocked())) {
				return JsonResult.fail(205, "你的账号以被禁用,请联系<a>超级管理员</a>");
			}
			request.getSession().setAttribute(CmsConstant.userSessionKey, userIsExis);
			
			response.addCookie(new Cookie("username",URLEncoder.encode(user.getUsername())));
			response.addCookie(new Cookie("password",URLEncoder.encode(pwd)));
			
			return JsonResult.success();
		}else {
			return JsonResult.success();
		}
	}

	@Override
	public JsonResult registerUser(User user) {
		// TODO Auto-generated method stub
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		user.setCreate_time(format);
		user.setUpdate_time(format);
		int i = userLoginDao.registerUser(user);
		if(i>0) {
			return new JsonResult(true,200,"注册成功");
		}else {
			return new JsonResult(false,500,"注册失败");
		}
	}

}
