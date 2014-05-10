package com.liuxian.action;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.liuxian.inject.service.ShopServiceImpl;
import com.liuxian.model.Shop;
import com.opensymphony.xwork2.ActionContext;

@Controller("shopAction")
public class ShopAction
{
	@Autowired
	private ShopServiceImpl shopService;
	
	@Autowired
	private Gson gson;
	
	private int id;
	private String name;
	private String location;
	private String owner;
	private String result;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String list() {
		List<Shop> shopList = shopService.list();
		ActionContext.getContext().put("shopList", shopList);
		return "shopList";
	}
	
	public String add() {
		Shop shop = new Shop();
		shop.setName(name);
		shop.setLocation(location);
		shop.setOwner(owner);
		shopService.add(shop);
		return list();
	}
	
	public String update() {
		Shop shop = new Shop();
		shop.setId(id);
		shop.setName(name);
		shop.setLocation(location);
		shop.setOwner(owner);
		shopService.update(shop);
		return list();
	}
	
	public String remove() {
		shopService.remove(id);
		return list();
	}
	
	public void get() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		Shop shop = shopService.get(id);
		response.setContentType("application/json; charset=utf-8");
		Writer out;
		try {
			out = response.getWriter();
			out.write(gson.toJson(shop));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
