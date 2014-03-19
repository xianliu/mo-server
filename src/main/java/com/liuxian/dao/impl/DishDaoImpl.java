package com.liuxian.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.liuxian.dao.DishDao;
import com.liuxian.model.Dish;

@Repository("dishDao")
public class DishDaoImpl extends BaseDaoImpl<Dish> implements DishDao {

	@Override
	public List<Dish> list(int groupId) {
		String hql = "from Dish d where d.group_id=:id";
		return getSession().createQuery(hql).setInteger("id", groupId).list();
	}
}
