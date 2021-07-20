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
@CrossOrigin(origins = {"http://localhost:4200/", "http://revature-bucket.s3-website-us-west-1.amazonaws.com/"})
@RequestMapping(path="/customers")
public class CustomerController {
	private CustomerService cs;
	
	@Autowired
	public CustomerController(CustomerService cs) {
		this.cs = cs;
	}
	
	@GetMapping
	public List<Customer> getAll() {
		return this.cs.getAll();
	}
	
	@GetMapping("/{id}")
	public Customer getById(@PathVariable("id") int id) {
		return this.cs.get(id);
	}
	
	@PostMapping("/add")
	public Customer add(@RequestBody Customer c) {
		return this.cs.add(c);
	}
	
	@PutMapping("/update")
	public Customer update(@RequestBody Customer c) {
		return this.cs.update(c);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.cs.delete(id);
	}
}
