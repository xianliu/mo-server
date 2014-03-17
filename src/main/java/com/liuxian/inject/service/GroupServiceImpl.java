package com.liuxian.inject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuxian.dao.GroupDao;
import com.liuxian.model.Group;

@Service("groupService")
@Transactional
public class GroupServiceImpl {
	@Resource(name = "groupDao")
	private GroupDao GroupDao;
	
	public void add(Group Group) {
		GroupDao.save(Group);
	}
	
	public List<Group> list() {
		return GroupDao.findAll();
	}
	
	public List<Group> list(int shopId) {
		return GroupDao.list(shopId);
	}
	
	public boolean remove(int id) {
		return GroupDao.remove(id);
	}
	
	public Group update(Group Group) {
		return GroupDao.update(Group);
	}
	
	public Group get(int id) {
		return GroupDao.findById(id);
	}
}
