package com.example.dao.api;

import java.util.List;

import com.example.domain.Customer;

public interface CustomerDao {

	public Customer getCustomer(long id);
	
	public List<Customer> getAll();
}
