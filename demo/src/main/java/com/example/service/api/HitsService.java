package com.example.service.api;

import java.util.List;

import com.example.domain.Customer;
import com.example.domain.CustomerHits;


public interface HitsService {
	public List<CustomerHits> getCustomerHits(long customerId);
	
	public void addHits(Customer customer);
	
}
