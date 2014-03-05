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
import com.liuxian.model.News;
import com.liuxian.util.JsonP;

@Controller
public class NewsService {
	@Autowired
	private JsonP jsonP;
	
	@Resource(name="newsDao")
	private NewsDao newsDao;

	@RequestMapping(value="/news", method = RequestMethod.GET)
	public void getMovie(@RequestParam("callback") String cb, HttpServletResponse response) {
		List<News> newsList = newsDao.findAll();
		jsonP.buildJsonp(newsList, cb, response);
	}
	
}