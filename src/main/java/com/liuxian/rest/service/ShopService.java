package com.liuxian.rest.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liuxian.dao.NewsDao;
import com.liuxian.dao.ShopDao;
import com.liuxian.model.News;
import com.liuxian.model.Shop;
import com.liuxian.util.JsonP;

@Controller
public class ShopService {
	@Autowired
	private JsonP jsonP;

	@Resource(name = "shopDao")
	private ShopDao shopDao;

	@RequestMapping(value = "/shop/all", method = RequestMethod.GET)
	public void getMovie(
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			HttpServletResponse response) {
		List<Shop> shopList = shopDao.findAll();
		jsonP.buildJsonp(shopList, cb, response);
	}

}