package com.example.dao.api;

import java.util.List;

import com.example.domain.Customer;
import com.example.domain.CustomerHits;
import com.example.domain.CustomerHits.Channel;

public interface CustomerHitsDao {

	 CustomerHits readHitsForCustomer(Customer customer, Channel channel);
	 List<CustomerHits> readHits(long customerId);
	 void incrementHit(Customer customer, long numberHits, Channel channel);
	 
	 
}
