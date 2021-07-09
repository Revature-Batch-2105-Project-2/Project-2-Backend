package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Employee;
import com.revature.repo.IEmployeeRepo;

@Component
public class EmployeeService implements IEmployeeService {
	private IEmployeeRepo repo;
	
	@Autowired
	public EmployeeService(IEmployeeRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Employee get(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Employee getByUsernameAndPassword(String username, String password) {
		// TODO: test that findByUsernameAndPassword actually exists
		return this.repo.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Employee> getAll() {
		return (List<Employee>) this.repo.findAll();
	}

	@Override
	public Employee add(Employee e) {
		return this.repo.save(e);
	}

	@Override
	public Employee update(Employee e) {
		return this.repo.save(e);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
