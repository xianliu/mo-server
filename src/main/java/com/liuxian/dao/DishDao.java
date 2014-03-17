package com.liuxian.dao;

import java.util.List;

import com.liuxian.model.Dish;

public interface DishDao extends BaseDao<Dish>{
	public List<Dish> list(int groupId);
}
