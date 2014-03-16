package com.liuxian.dao;

import java.util.List;
import java.io.Serializable;

import org.hibernate.Session;

public interface BaseDao<T> {
	public T save(T t);
	
	public T update(T t);
	
	public T saveOrUpdate(T t);
	
	public boolean remove(Serializable id);
	
	public int removeByHQL(String hql, Object... params);
	
	public T findById(Serializable id);
	
	public List<T> findAll();
	
	public List<T> findByHQL(String hql, Object... params);
	
	Session getSession();
}
