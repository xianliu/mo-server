package com.liuxian.action;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.liuxian.inject.service.GroupServiceImpl;
import com.liuxian.model.Group;
import com.liuxian.model.Shop;
import com.opensymphony.xwork2.ActionContext;

@Controller("groupAction")
public class GroupAction {
	private int id;
	private int shopId;
	private String name;
	
	@Autowired
	private GroupServiceImpl groupService;
	
	@Autowired
	private Gson gson;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String list() {
		List<Group> groupList = groupService.list(shopId);
		ActionContext.getContext().put("groupList", groupList);
		return "groupList";
	}
	
	public String update() {
		Group group = new Group();
		group.setId(id);
		group.setShopId(shopId);
		group.setName(name);
		group.setCreateTime(new Date());
		groupService.update(group);
		return list();
	}

	
	public String add() {
		Group group = new Group();
		group.setShopId(shopId);
		group.setName(name);
		group.setCreateTime(new Date());
		groupService.add(group);
		return list();
	}
	
	public String remove() {
		groupService.remove(id);
		return list();
	}
	
	public void get() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		Group group = groupService.get(id);
		response.setContentType("application/json; charset=utf-8");
		Writer out;
		try {
			out = response.getWriter();
			out.write(gson.toJson(group));
			System.out.println(gson.toJson(group));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
