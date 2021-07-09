package com.revature.services;

import java.util.List;

import com.revature.beans.PartLookUp;

public interface IPartLookUpService {
	public PartLookUp get(int id);
	public List<PartLookUp> getAll();
	public PartLookUp add(PartLookUp p);
	public PartLookUp update(PartLookUp p);
	public void delete(int id);
}
