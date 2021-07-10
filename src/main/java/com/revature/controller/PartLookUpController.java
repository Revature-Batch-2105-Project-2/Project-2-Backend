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

import com.revature.beans.PartLookUp;
import com.revature.services.PartLookUpService;

@RestController
@RequestMapping(path="/parts")
public class PartLookUpController {
	private PartLookUpService plus;
	
	@Autowired
	public PartLookUpController(PartLookUpService plus) {
		this.plus = plus;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping
	public List<PartLookUp> getAll() {
		return this.plus.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/{id}")
	public PartLookUp getById(@PathVariable("id") int id) {
		return this.plus.get(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/add")
	public PartLookUp add(@RequestBody PartLookUp c) {
		return this.plus.add(c);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/update")
	public PartLookUp update(@RequestBody PartLookUp c) {
		return this.plus.update(c);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.plus.delete(id);
	}
}