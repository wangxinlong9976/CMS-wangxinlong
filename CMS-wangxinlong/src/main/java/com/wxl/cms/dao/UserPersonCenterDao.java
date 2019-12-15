package com.wxl.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.pojo.User;

public interface UserPersonCenterDao {
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
	
	/**
	 * 
	 * @Title: insertOneUser
	 * @Description: TODO		添加单个user
	 * @param user
	 * @return    
	 * Integer    
	 *
	 */
	Integer insertOneUser(@Param("user")User user);
	
	/**
	 * 
	 * @Title: insertBatchUser
	 * @Description: TODO	批量添加User
	 * @param users
	 * @return    
	 * Integer    
	 *
	 */
	Integer insertBatchUser(@Param("users")List<User> users);
	
	/**
	 * 
	 * @Title: deleteOneUser	删除单个User
	 * @Description: TODO
	 * @param id
	 * @return    
	 * Integer    
	 *
	 */
	Integer deleteOneUser(@Param("id")Integer id);
	
	
	/**
	 * 
	 * @Title: deleteBatchUser	
	 * @Description: TODO	批量删除User
	 * @param ids
	 * @return    
	 * Integer    
	 *
	 */
	Integer deleteBatchUser(@Param("ids")String ids);
	

	
	/**
	 * 
	 * @Title: updateUser
	 * @Description: TODO	修改User
	 * @param user
	 * @return    
	 * Integer    
	 *
	 */
	Integer updateUser(@Param("user")User user);
}
