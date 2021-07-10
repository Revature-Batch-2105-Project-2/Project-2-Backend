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

import com.revature.beans.PartList;
import com.revature.services.PartListService;

@RestController
@RequestMapping(path="/partlists")
public class PartListController {
	private PartListService pls;
	
	@Autowired
	public PartListController(PartListService pls) {
		this.pls = pls;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping
	public List<PartList> getAll() {
		return this.pls.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/{id}")
	public PartList getById(@PathVariable("id") int id) {
		return this.pls.get(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/add")
	public PartList add(@RequestBody PartList c) {
		return this.pls.add(c);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/update")
	public PartList update(@RequestBody PartList c) {
		return this.pls.update(c);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.pls.delete(id);
	}
}