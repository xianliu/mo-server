package com.sql.dao.impl;

import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sql.dao.UserDaoI;

@Repository("userDao")
public class UserDaoImpl<T> implements UserDaoI<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public Serializable save(T o) {
		return sessionFactory.getCurrentSession().save(o);
	}

}
