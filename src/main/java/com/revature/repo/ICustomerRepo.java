package com.revature.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Customer;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer>{

}
