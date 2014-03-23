package com.liuxian.action;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.liuxian.inject.service.NewsServiceImpl;
import com.liuxian.model.News;
import com.liuxian.model.Shop;
import com.opensymphony.xwork2.ActionContext;

@Controller("newsAction")
public class NewsAction {
	@Autowired
	private NewsServiceImpl newsService;
	
	@Autowired
	private Gson gson;
	
	private int id;
	private String title;
	private String content;
	
	private static final String LIST = "newsList";
	private static final String REFRESH_LIST = "refreshList";
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String list() {
		List<News> newsList = newsService.list();
		ActionContext.getContext().put("newsList", newsList);
		return LIST;
	}
	
	public String add() {
		News news = new News();
		news.setTitle(title);
		news.setContent(content);
		news.setCreateDate(new Date());
		newsService.add(news);
		return list();
	}
	
	public String update() {
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setContent(content);
		news.setCreateDate(new Date());
		newsService.update(news);
		return REFRESH_LIST;
	}
	
	public String remove() {
		newsService.remove(id);
		return list();
	}
	
	public void get() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		News news = newsService.get(id);
		response.setContentType("application/json; charset=utf-8");
		Writer out;
		try {
			out = response.getWriter();
			out.write(gson.toJson(news));
			System.out.println(gson.toJson(news));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
