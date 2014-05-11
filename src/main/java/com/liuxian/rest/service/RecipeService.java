package com.liuxian.rest.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liuxian.dao.RecipeDao;
import com.liuxian.model.Recipe;
import com.liuxian.util.JsonP;

@Controller
public class RecipeService {
	@Autowired
	private JsonP jsonP;

	@Resource(name = "recipeDao")
	private RecipeDao recipeDao;
	
	@RequestMapping(value = "/api/recipeList.json", method = RequestMethod.GET)
	public void getRecipeList(
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			HttpServletResponse response) {
		List<Recipe> recipeList = recipeDao.findAll(); 
		jsonP.buildJsonp(recipeList, cb, response);
	}

}