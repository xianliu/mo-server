package com.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sql.dao.UserDaoI;
import com.sql.model.User;
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
