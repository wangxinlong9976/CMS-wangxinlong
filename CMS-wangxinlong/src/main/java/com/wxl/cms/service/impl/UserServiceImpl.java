package com.wxl.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.dao.UserLoginDao;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserLoginDao userDao;

	@Override
	public List<User> selectUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
		return false;
	}
}
