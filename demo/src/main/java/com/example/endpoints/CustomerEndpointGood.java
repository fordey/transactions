package com.example.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.domain.CustomerHits;
import com.example.facade.api.CustomerFacade;
import com.example.service.api.CustomerService;
import com.example.service.api.HitsService;


@RestController
@RequestMapping("/onetx")
public class CustomerEndpointGood {

	@Autowired
	@Qualifier("GoodFacade")
	private CustomerFacade facade;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/{id}")
	public Customer getCustomer(@PathVariable long id){
		return facade.retieveCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/")
	public List<Customer> getAllCustomers(){
		return facade.retrieveAll();
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/hits/{id}")
	public List<CustomerHits> getCustomerHits(@PathVariable long id){
		
		return facade.getCustomerHits(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/hits/add/{id}")
	public List<CustomerHits> addHit(@PathVariable Long id){
		return facade.addHits(id);
		
	}
	
	
}
