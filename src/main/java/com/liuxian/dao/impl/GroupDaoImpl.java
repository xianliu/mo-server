package com.liuxian.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.liuxian.dao.GroupDao;
import com.liuxian.model.Group;

@Repository("groupDao")
public class GroupDaoImpl extends BaseDaoImpl<Group> implements GroupDao {
	
	@Override
	public List<Group> list(int shopId) {
		String hql = "from Group g where g.shopId=:id";
		return getSession().createQuery(hql).setInteger("id", shopId).list();
	}
}
