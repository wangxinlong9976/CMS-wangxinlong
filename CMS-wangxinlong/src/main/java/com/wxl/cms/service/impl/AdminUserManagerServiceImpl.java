package com.wxl.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxl.cms.common.Conditions;
import com.wxl.cms.common.ConditionsArticleManager;
import com.wxl.cms.dao.AdminLoginManagerDao;
import com.wxl.cms.dao.AdminUserManagerDao;
import com.wxl.cms.pojo.User;
import com.wxl.cms.service.AdminUserManagerService;

@Service
public class AdminUserManagerServiceImpl implements AdminUserManagerService{
	
	@Autowired
	private AdminUserManagerDao adminUserManagerDao;

	@Override
	public List<User> selectUser(Conditions con) {
		// TODO Auto-generated method stub
		return adminUserManagerDao.selectUser(con);
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return adminUserManagerDao.getUserById(id);
	}
	
	@Override
	public boolean lockedStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		
		return adminUserManagerDao.lockedStatus(id,status)>0;
	}
}
