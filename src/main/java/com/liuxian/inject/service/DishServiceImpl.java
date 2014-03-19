package com.liuxian.inject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuxian.dao.DishDao;
import com.liuxian.model.Dish;
@Service("dishService")
@Transactional
public class DishServiceImpl
{ 	
	@Resource(name = "dishDao")
	private DishDao dishDao;
	
	public void add(Dish dish)
	{
		dishDao.save(dish);
	}
	
	public List<Dish> list() {
		return dishDao.findAll();
	}
	
	public List<Dish> list(int groupId) {
		return dishDao.list(groupId);
	}
	
	public boolean remove(int id) {
		return dishDao.remove(id);
	}
	
	public Dish update(Dish Dish) {
		return dishDao.update(Dish);
	}
	
	public Dish get(int id) {
		return dishDao.findById(id);
	}
}
