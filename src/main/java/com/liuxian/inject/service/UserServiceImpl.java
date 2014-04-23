package com.liuxian.inject.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuxian.dao.UserDao;
import com.liuxian.model.User;
@Service("userService")
@Transactional
public class UserServiceImpl
{ 	
	@Resource(name = "userDao")
	private UserDao userDao;
	
}
