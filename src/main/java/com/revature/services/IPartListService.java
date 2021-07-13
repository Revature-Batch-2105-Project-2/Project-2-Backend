package com.revature.services;

import java.util.List;

import com.revature.beans.PartList;

public interface IPartListService {
	public PartList get(int id);
	public List<PartList> getAll();
	public List<PartList> getByOrderId(int id);
	public PartList add(PartList pl);
	public PartList update(PartList pl);
	public void delete(int id);
}
