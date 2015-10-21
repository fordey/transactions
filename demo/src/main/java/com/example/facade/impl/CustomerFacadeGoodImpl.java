package com.example.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.domain.CustomerHits;
import com.example.facade.api.CustomerFacade;
import com.example.service.api.CustomerService;
import com.example.service.api.HitsService;


@Component
@Qualifier("GoodFacade")
@Transactional
public class CustomerFacadeGoodImpl implements CustomerFacade {

	@Autowired
	@Qualifier("NiceCustomerService")
	private CustomerService customerService;
	
	@Autowired
	private HitsService hitsService;
	
	
	@Override
	public Customer retieveCustomer(Long id) {
		return customerService.retieveCustomer(id);
	}

	@Override
	public List<Customer> retrieveAll() {
		return customerService.retrieveAll();
	}

	@Override
	public List<CustomerHits> getCustomerHits(long customerId) {
		return hitsService.getCustomerHits(customerId);
	}

	@Override
	public List<CustomerHits> addHits(Long id) {
		Customer customer = customerService.retieveCustomer(id);
		hitsService.addHits(customer);
		
		return hitsService.getCustomerHits(id);
		
	}

}
