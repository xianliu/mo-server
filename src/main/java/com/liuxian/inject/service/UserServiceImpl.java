package com.liuxian.inject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuxian.dao.UserDaoI;
import com.liuxian.model.User;
@Service("userService")
@Transactional
public class UserServiceImpl
{ 	
	@Autowired
	private UserDaoI<User> userDao;
	
	public void addUser(User user)
	{
		userDao.save(user);
	}

}
