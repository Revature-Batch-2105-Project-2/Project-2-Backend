package com.revature.controller;

import java.util.List;

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

import com.revature.beans.Customer;
import com.revature.services.CustomerService;

@RestController
@RequestMapping(path="/customers")
public class CustomerController {
	private CustomerService cs;
	
	@Autowired
	public CustomerController(CustomerService cs) {
		this.cs = cs;
	}
	
//	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping
	public List<Customer> getAll() {
		return this.cs.getAll();
	}
	
//	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/{id}")
	public Customer getById(@PathVariable("id") int id) {
		return this.cs.get(id);
	}
	
//	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/add")
	public Customer add(@RequestBody Customer c) {
		return this.cs.add(c);
	}
	
//	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/update")
	public Customer update(@RequestBody Customer c) {
		return this.cs.update(c);
	}
	
//	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.cs.delete(id);
	}
}
