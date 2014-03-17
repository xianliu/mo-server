package com.liuxian.dao;

import java.util.List;

import com.liuxian.model.Group;

public interface GroupDao extends BaseDao<Group> {
	public List<Group> list(int shopId);
}
