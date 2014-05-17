package com.liuxian.rest.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			@RequestParam String userId,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.parseInt(userId));
		List<Recipe> recipeList = recipeDao.findByHQL("where c.userId=:userId", map); 
		jsonP.buildJsonp(recipeList, cb, response);
	}
	
	@RequestMapping(value = "/api/saveRecipe.json", method = RequestMethod.GET)
	public void saveRecipe(
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			@RequestParam String access_token,
			@RequestParam String user_id,
			@RequestParam String total_price,
			@RequestParam String location,
			@RequestParam String detail,
			HttpServletResponse response) throws UnsupportedEncodingException {
		Recipe recipe = new Recipe();
		recipe.setUserId(Integer.parseInt(user_id));
		
		location = URLDecoder.decode(location, "utf-8");
		
		recipe.setLocation(location);
		recipe.setPrice(total_price);
		recipe.setDetail(detail);
		recipe.setCreateDate(new Date());
		
		recipeDao.save(recipe);
		jsonP.buildJsonp(recipe, cb, response);
	}

}