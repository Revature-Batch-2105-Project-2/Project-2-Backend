package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.PartList;
import com.revature.repo.IPartListRepo;

@Component
public class PartListService implements IPartListService {
	private IPartListRepo repo;
	
	@Autowired
	public PartListService(IPartListRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public PartList get(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<PartList> getAll() {
		return (List<PartList>) this.repo.findAll();
	}
	
	@Override
	public List<PartList> getByOrderId(int id) {
		return this.repo.findAllByOrderId(id);
	}

	@Override
	public PartList add(PartList pl) {
		return this.repo.save(pl);
	}

	@Override
	public PartList update(PartList pl) {
		return this.repo.save(pl);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
