package com.wxl.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.dao.AdminDao;
import com.wxl.cms.pojo.Category;
import com.wxl.cms.pojo.Channel;
import com.wxl.cms.pojo.Conditions;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<User> selectUser(Conditions con) {
		// TODO Auto-generated method stub
		return adminDao.selectUser(con);
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.getUserById(id);
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
	public boolean userIsExis(User user) {
		// TODO Auto-generated method stub
		return adminDao.userIsExis(user)==null;
	}

	@Override
	public boolean lockedStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		
		return adminDao.lockedStatus(id,status)>0;
	}

	@Override
	public List<Channel> selectChannel() {
		// TODO Auto-generated method stub
		return adminDao.selectChannel();
	}

	@Override
	public List<Category> selectCategory(Integer channelId) {
		// TODO Auto-generated method stub
		return adminDao.selectCategory(channelId);
	}
	
}
