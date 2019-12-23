package com.wxl.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.wxl.cms.common.CmsConstant;
import com.wxl.cms.pojo.User;

public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute(CmsConstant.adminSessionKey);
		if(user!=null) {
			return true;
		}
		response.sendRedirect("/admin/toLogin");
		return false;
	}
	
}
