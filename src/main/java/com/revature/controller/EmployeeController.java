package com.revature.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.beans.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.JwtUtil;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://revature-bucket.s3-website-us-west-1.amazonaws.com/"})
@RequestMapping(path="/employees")
public class EmployeeController {
	private EmployeeService es;
	private AuthenticationManager am;
	private JwtUtil jwt;
	private Gson gson = new GsonBuilder().create();
	
	@Autowired
	public EmployeeController(EmployeeService es, AuthenticationManager am, JwtUtil jwt) {
		this.es = es;
		this.am = am;
		this.jwt = jwt;
	}
	
	@PostMapping("/log_in")
	public String login(@RequestBody Map<String, String> info) throws Exception {
		System.out.println("logging in! " + info);
		
		try {
			this.am.authenticate(new UsernamePasswordAuthenticationToken(info.get("username"), info.get("password")));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password!!!", e);
		}
		
		final UserDetails details = this.es.getUserDetails(info.get("username"), info.get("password"));
		final String token = this.jwt.generateToken(details);
		System.out.println(token);
		return this.gson.toJson(token);
	}
	
	@PostMapping("/log_out")
	public boolean logout(@RequestBody String token) {
		System.out.println("logging out with token " + token);
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