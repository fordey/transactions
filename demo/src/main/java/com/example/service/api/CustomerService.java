package com.example.service.api;

import java.util.List;

import com.example.domain.Customer;

public interface CustomerService {

	public Customer retieveCustomer(Long id);
	
	public List<Customer> retrieveAll();
	
}
