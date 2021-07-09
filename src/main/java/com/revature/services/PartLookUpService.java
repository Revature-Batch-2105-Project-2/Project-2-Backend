package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.PartLookUp;
import com.revature.repo.IPartLookUpRepo;

@Component
public class PartLookUpService implements IPartLookUpService {
	private IPartLookUpRepo repo;
	
	@Autowired
	public PartLookUpService(IPartLookUpRepo repo) {
		this.repo = repo;
	}

	@Override
	public PartLookUp get(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<PartLookUp> getAll() {
		return (List<PartLookUp>) this.repo.findAll();
	}

	@Override
	public PartLookUp add(PartLookUp p) {
		return this.repo.save(p);
	}

	@Override
	public PartLookUp update(PartLookUp p) {
		return this.repo.save(p);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
