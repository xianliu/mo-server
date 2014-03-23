package com.liuxian.inject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuxian.dao.NewsDao;
import com.liuxian.model.News;
import com.liuxian.model.Shop;
@Service("newsService")
@Transactional
public class NewsServiceImpl
{ 	
	@Resource(name = "newsDao")
	private NewsDao newsDao;
	
	public void add(News news)
	{
		newsDao.save(news);
	}
	
	public List<News> list() {
		return newsDao.findAll();
	}
	
	public boolean remove(int id) {
		return newsDao.remove(id);
	}
	
	public News update(News news) {
		return newsDao.update(news);
	}
	
	public News get(int id) {
		return newsDao.findById(id);
	}

}
