package com.revature.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Employee;
//import com.revature.security.ActiveUserStore;
import com.revature.services.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path="/employees")
public class EmployeeController {
	private EmployeeService es;
//	private ActiveUserStore store;
	
	@Autowired
	public EmployeeController(EmployeeService es) {
		this.es = es;
	}
	
//	@Autowired
//	public void setActiveUserStore(ActiveUserStore store) {
//		this.store = store;
//	}
//	
//	@GetMapping("/logged_in")
//	public Employee getLoggedIn() {
//		return this.store.getActiveEmployee();
//	}
//	
//	@PostMapping("/log_in")
//	public Employee login(@RequestBody String username, @RequestBody String password) {
//		System.out.println("logging in with credentials " + username + " " + password);
//		Employee e = this.es.getByUsernameAndPassword(username, password);
//		if (e == null) return new Employee();
//		else {
//			this.store.setActiveEmployee(e);
//			return e;
//		}
//	}
	
	@PostMapping("/log_in")
	public Employee login(@RequestBody Map<String, String> loginInfo) {
		// TODO: placeholder!!!
		Employee e = this.es.getByUsernameAndPassword(loginInfo.get("username"), loginInfo.get("password"));
		System.out.println("Employee " + e + " logged in!");
		return e;
	}
	
	@PostMapping("/log_out")
	public boolean logout() {
		// TODO: placeholder!!!
		return true;
	}
	
	@GetMapping
	public List<Employee> getAll() {
		return this.es.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") int id) {
		return this.es.get(id);
	}
	
	@PostMapping("/add")
	public Employee add(@RequestBody Employee c) {
		return this.es.add(c);
	}
	
	@PutMapping("/update")
	public Employee update(@RequestBody Employee c) {
		return this.es.update(c);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.es.delete(id);
	}
}