package com.liuxian.inject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuxian.dao.ShopDao;
import com.liuxian.model.Shop;
@Service("shopService")
@Transactional
public class ShopServiceImpl
{ 	
	@Resource(name = "shopDao")
	private ShopDao shopDao;
	
	public void add(Shop shop)
	{
		shopDao.save(shop);
	}
	
	public List<Shop> list() {
		return shopDao.findAll();
	}
	
	public boolean remove(int id) {
		return shopDao.remove(id);
	}
	
	public Shop update(Shop shop) {
		return shopDao.update(shop);
	}
	
	public Shop get(int id) {
		return shopDao.findById(id);
	}

}
