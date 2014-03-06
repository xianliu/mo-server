package com.liuxian.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuxian.dao.NewsDao;
import com.liuxian.model.News;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {
	
}
