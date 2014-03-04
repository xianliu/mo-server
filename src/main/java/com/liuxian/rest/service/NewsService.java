package com.liuxian.rest.service;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.liuxian.model.News;
import com.liuxian.util.JsonP;

@Controller
public class NewsService {
	@Autowired
	private JsonP jsonP;

	@RequestMapping(value="/news", method = RequestMethod.GET)
	public void getMovie(HttpServletResponse response) {
		List<News> newsList = new ArrayList<News>();
		News news = new News();
		news.setId(1);
		news.setTitle("test");
		news.setContent("content");
		newsList.add(news);
		News news2 = new News();
		news2.setId(2);
		news2.setTitle("test1");
		news2.setContent("content1");
		newsList.add(news2);
		
		jsonP.buildJsonp(newsList, response);
	}
	
}