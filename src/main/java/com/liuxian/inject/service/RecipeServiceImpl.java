package com.liuxian.inject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuxian.dao.RecipeDao;
import com.liuxian.model.Recipe;
@Service("recipeService")
@Transactional
public class RecipeServiceImpl { 	
	@Resource(name = "recipeDao")
	private RecipeDao recipeDao;
	
	public void add(Recipe recipe)
	{
		recipeDao.save(recipe);
	}
	
	public List<Recipe> list() {
		return recipeDao.findAll();
	}
	
	public boolean remove(int id) {
		return recipeDao.remove(id);
	}
	
	public Recipe update(Recipe recipe) {
		return recipeDao.update(recipe);
	}
	
	public Recipe get(int id) {
		return recipeDao.findById(id);
	}

}
