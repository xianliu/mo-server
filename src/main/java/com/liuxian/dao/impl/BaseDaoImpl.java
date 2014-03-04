package com.liuxian.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.liuxian.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private final Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T save(T t) {
		getSession().persist(t);
		return t;
	}

	@Override
	public T saveOrUpdate(T t) {
		return (T) (getSession().contains(t) ? getSession().merge(t) : t); 
	}

	@Override
	public boolean remove(Serializable id) {
		T t = (T) getSession().get(clazz, id);
		if(null == t) {
			return false;
		} else {
			getSession().delete(t);
			return true;
		}
		
	}

	@Override
	public int removeByHQL(String hql, Object... params) {
		Query query = getSession().createQuery("DELETE FROM " + clazz.getSimpleName() + " c" + hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.executeUpdate();
	}

	@Override
	public T findById(Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	@Override
	public List<T> findByHQL(String hql, Object... params) {
		Query query = getSession().createQuery("FROM " + clazz.getSimpleName() + hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.list();
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession(); 
	}

}
