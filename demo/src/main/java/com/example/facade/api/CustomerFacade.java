package com.example.facade.api;

import java.util.List;

import com.example.domain.Customer;
import com.example.domain.CustomerHits;

public interface CustomerFacade {

	public Customer retieveCustomer(Long id);
	
	public List<Customer> retrieveAll();
	
	public List<CustomerHits> getCustomerHits(long customerId);
	
	public List<CustomerHits> addHits(Long id);
	
}
