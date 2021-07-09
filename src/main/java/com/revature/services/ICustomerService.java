package com.revature.services;

import java.util.List;

import com.revature.beans.Customer;

public interface ICustomerService {
	public Customer get(int id);
	public List<Customer> getAll();
	public Customer add(Customer c);
	public Customer update(Customer c);
	public void delete(int id);
}
