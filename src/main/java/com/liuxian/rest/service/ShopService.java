package com.liuxian.rest.service;

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

import com.liuxian.dao.DishDao;
import com.liuxian.dao.GroupDao;
import com.liuxian.dao.ShopDao;
import com.liuxian.model.Dish;
import com.liuxian.model.Group;
import com.liuxian.model.Shop;
import com.liuxian.util.JsonP;

@Controller
public class ShopService {
	@Autowired
	private JsonP jsonP;

	@Resource(name = "shopDao")
	private ShopDao shopDao;
	
	@Resource(name = "groupDao")
	private GroupDao groupDao;
	
	@Resource(name = "dishDao")
	private DishDao dishDao;

	@RequestMapping(value = "/api/shops.json", method = RequestMethod.GET)
	public void getShopList(
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			HttpServletResponse response) {
		List<Shop> shopList = shopDao.findAll();
		jsonP.buildJsonp(shopList, cb, response);
	}
	
	@RequestMapping(value = "/api/group.json", method = RequestMethod.GET)
	public void getGroupList(
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			@RequestParam(value = "shopId") String shopId,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("shopId", Integer.parseInt(shopId));
		List<Group> groupList = groupDao.findByHQL("where c.shopId=:shopId", map); 
		jsonP.buildJsonp(groupList, cb, response);
	}
	
	@RequestMapping(value = "/api/dishList.json", method = RequestMethod.GET)
	public void getDishList(
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			@RequestParam(value = "groupId") String groupId,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", Integer.parseInt(groupId));
		List<Dish> dishList = dishDao.findByHQL("where c.group_id=:groupId", map); 
		jsonP.buildJsonp(dishList, cb, response);
	}
	
	@RequestMapping(value = "/api/dishes.json", method = RequestMethod.GET)
	public void getDishListByIds(
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			@RequestParam(value = "ids") String ids,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dish> dishList = dishDao.findByHQL("where c.id in (" + ids + ")", map); 
		jsonP.buildJsonp(dishList, cb, response);
	}

}