package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Customer;
import com.revature.repo.ICustomerRepo;

@Component
public class CustomerService implements ICustomerService {
	private ICustomerRepo repo;
	
	@Autowired
	public CustomerService(ICustomerRepo repo) {
		this.repo = repo;
	}

	@Override
	public Customer get(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Customer> getAll() {
		return (List<Customer>) this.repo.findAll();
	}

	@Override
	public Customer add(Customer c) {
		return this.repo.save(c);
	}

	@Override
	public Customer update(Customer c) {
		return this.repo.save(c);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
