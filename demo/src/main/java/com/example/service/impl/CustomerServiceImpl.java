package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.api.CustomerDao;
import com.example.domain.Customer;
import com.example.service.api.CustomerService;


@Service
@Qualifier("NiceCustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public Customer retieveCustomer(Long id) {
		return customerDao.getCustomer(id);
	}


	@Override
	public List<Customer> retrieveAll() {
		return customerDao.getAll();
	}

	
	

}
