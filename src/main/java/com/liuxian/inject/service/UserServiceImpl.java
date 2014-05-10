package com.liuxian.inject.service;

import java.util.List;

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
	
	public void add(User user) {
		userDao.save(user);
	}
	
	public List<User> list() {
		return userDao.findAll();
	}
	
	public User get(int userId) {
		return userDao.findById(userId);
	}
	
	public boolean remove(int id) {
		return userDao.remove(id);
	}
	
	public User update(User user) {
		return userDao.update(user);
	}
	
}
