package com.liuxian.action;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.liuxian.inject.service.RecipeServiceImpl;
import com.liuxian.model.Recipe;
import com.opensymphony.xwork2.ActionContext;

@Controller("recipeAction")
public class RecipeAction {
	@Autowired
	private Gson gson;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Autowired
	private RecipeServiceImpl recipeService;
	
	
	public String list() {
		List<Recipe> recipeList = recipeService.list();
		ActionContext.getContext().put("recipeList", recipeList);
		return "recipeList";
	}
	
	
	public void get() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		Recipe recipe = recipeService.get(id);
		response.setContentType("application/json; charset=utf-8");
		Writer out;
		try {
			out = response.getWriter();
			out.write(gson.toJson(recipe));
			System.out.println(gson.toJson(recipe));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
