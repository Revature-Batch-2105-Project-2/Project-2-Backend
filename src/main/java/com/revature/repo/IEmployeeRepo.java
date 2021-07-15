package com.revature.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Employee;

@Repository
public interface IEmployeeRepo extends CrudRepository<Employee, Integer> {
	Employee findByUsername(String username);
	Employee findByUsernameAndPassword(String username, String password);
}
