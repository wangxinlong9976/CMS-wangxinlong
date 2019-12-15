package com.wxl.cms.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.common.JsonResult;
import com.wxl.cms.pojo.User;

public interface AdminLoginManagerService {
	
	/**
	 * 
	 * @Title: userIsExis
	 * @Description: TODO	查询用户是否存在
	 * @param user
	 * @param request 
	 * @return    
	 * boolean    
	 *
	 */
	JsonResult userIsExis(@Param("user")User user, HttpServletRequest request);
}
