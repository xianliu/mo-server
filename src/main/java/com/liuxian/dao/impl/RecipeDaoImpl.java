package com.liuxian.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuxian.dao.RecipeDao;
import com.liuxian.model.Recipe;

@Repository("recipeDao")
public class RecipeDaoImpl extends BaseDaoImpl<Recipe> implements RecipeDao {

}
