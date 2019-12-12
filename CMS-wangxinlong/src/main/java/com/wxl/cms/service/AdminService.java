package com.wxl.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.Conditions;
import com.wxl.cms.pojo.User;

public interface AdminService {
	
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
	
	/**
	 * 
	 * @Title: userIsExis
	 * @Description: TODO	查询用户是否存在
	 * @param user
	 * @return    
	 * boolean    
	 *
	 */
	boolean userIsExis(@Param("user")User user);

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

	/**
	 * 
	 * @Title: selectChannel
	 * @Description: TODO		查询全部的频道
	 * @return    
	 * List<Channel>    
	 *
	 */
	List<Channel> selectChannel();

	/**
	 * 
	 * @Title: selectCategory
	 * @Description: TODO	通过频道(channel的id查询所有的分类)
	 * @return    
	 * List<Category>    
	 *
	 */
	List<Category> selectCategory(Integer channelId);
}
