package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.beans.Employee;
import com.revature.repo.IEmployeeRepo;

@Component
@Service
public class EmployeeService implements IEmployeeService, UserDetailsService {
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
	public Employee getByUserDetails(UserDetails details) {
		return this.getByUsernameAndPassword(details.getUsername(), details.getPassword());
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername(): " + username);
		Employee e = this.repo.findByUsername(username);
		if (e != null) return new User(e.getUsername(), e.getPassword(), new ArrayList<>());
		else return null;
	}
	
	@Override
	public UserDetails getUserDetails(String username, String password) {
		Employee e = this.getByUsernameAndPassword(username, password);
		if (e != null) return new User(e.getUsername(), e.getPassword(), new ArrayList<>());
		else return null;
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
