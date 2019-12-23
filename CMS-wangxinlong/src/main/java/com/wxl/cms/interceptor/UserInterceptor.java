package com.wxl.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.pojo.User;

public class UserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute(CmsConstant.userSessionKey);
		if(user!=null) {
			return true;
		}
		
		response.sendRedirect("/user/toLogin");
		return false;
	}

}
