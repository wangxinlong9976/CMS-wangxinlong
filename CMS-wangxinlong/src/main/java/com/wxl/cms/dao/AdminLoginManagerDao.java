package com.wxl.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.User;

public interface AdminLoginManagerDao {
	
	/**
	 * 
	 * @Title: userIsExis
	 * @Description: TODO	查询用户是否存在
	 * @param user
	 * @return    
	 * boolean    
	 *
	 */
	User userIsExis(@Param("user")User user);


}
