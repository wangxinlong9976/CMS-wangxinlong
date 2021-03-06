package com.wxl.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.User;

public interface AdminUserManagerDao {
	
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
	/**
	 * 
	 * @param con 
	 * @Title: selectUser
	 * @Description: TODO	查询所有的user
	 * @param user
	 * @return    
	 * List<User>    
	 *
	 */
	List<User> selectUser(Conditions con);

	/**
	 * 	
	 * @Title: lockedStatus
	 * @Description: TODO			修改用户的禁用状态
	 * @param id
	 * @param status
	 * @return    
	 * int    
	 *
	 */
	int lockedStatus(@Param("id")Integer id, @Param("status")Integer status);
	
}
