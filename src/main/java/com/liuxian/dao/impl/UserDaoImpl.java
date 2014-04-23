package com.liuxian.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuxian.dao.UserDao;
import com.liuxian.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
}
