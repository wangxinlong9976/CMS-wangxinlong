package com.wxl.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.pojo.User;

public interface AdminUserManagerService {
	
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
	 * @Title: lockedStatus
	 * @Description: TODO	通过id和状态修改 用户的禁用状态
	 * @param id
	 * @param status
	 * @return    
	 * boolean    
	 *
	 */
	boolean lockedStatus(Integer id, Integer status);
}
