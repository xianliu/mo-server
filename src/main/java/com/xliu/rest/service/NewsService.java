package com.xliu.rest.service;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sql.model.News;

@Controller
@RequestMapping("/movie")
public class NewsService {


	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public @ResponseBody News getMovie(@PathVariable String name, ModelMap model) {
		News news = new News();
		news.setId(0);
		news.setTitle("test");
		news.setContent("content");
		return news;

	}
	
}