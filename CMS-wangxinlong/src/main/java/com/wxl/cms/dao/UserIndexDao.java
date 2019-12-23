package com.wxl.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.pojo.User;

public interface UserIndexDao {
	/**
	 * 
	 * @Title: selectUser
	 * @Description: TODO	查询所有的user
	 * @param user
	 * @return    
	 * List<User>    
	 *
	 */
	List<User> selectUser(@Param("user")User user);
	
	/**
	 * 
	 * @Title: getUserById
	 * @Description: TODO	通过Id获取User
	 * @param id
	 * @return    
	 * User    
	 *
	 */
	User getUserById(@Param("id")Integer id);
	
}
