package com.liuxian.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.liuxian.inject.service.DishServiceImpl;
import com.liuxian.model.Group;

@Controller("dishAction")
public class DishAction {
	private int id;
	
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Autowired
	private DishServiceImpl dishService;
	
}
