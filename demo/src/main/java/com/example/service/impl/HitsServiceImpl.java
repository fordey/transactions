package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.api.CustomerHitsDao;
import com.example.domain.Customer;
import com.example.domain.CustomerHits;
import com.example.domain.CustomerHits.Channel;
import com.example.service.api.CustomerService;
import com.example.service.api.HitsService;


@Service
@Qualifier("niceHitsService")
@Transactional
public class HitsServiceImpl implements HitsService {

	@Autowired
	private CustomerHitsDao hitsDao;
	
	
	@Autowired
	@Qualifier("NiceCustomerService")
	private CustomerService quoteService;

	@Override
	public List<CustomerHits> getCustomerHits(long customerId) {
		return hitsDao.readHits(customerId);
	}

	
	@Override
	public void addHits(Customer customer) {
		hitsDao.incrementHit(customer, 1, Channel.WEB);
	}	
	
}
