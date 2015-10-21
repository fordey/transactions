package com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.dao.api.CustomerDao;
import com.example.domain.Customer;

@Repository
public class CustomerJDBCDao implements CustomerDao {

	private static final Logger logger = LoggerFactory.getLogger(CustomerJDBCDao.class);
	
	@Autowired
	JdbcTemplate template;
		
	
	public Customer getCustomer(long id){
		
		Customer customer = (Customer)template.queryForObject("SELECT id, name FROM Customer WHERE id= ? ", new Object[] {id}, new CustomerMapper());
		
		
		if (customer == null){
			customer = new Customer(0l, "");
		}
		
		
		return customer;
				
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Customer> getAll() {
		List<Map<String, Object>> rows = template.queryForList("SELECT * FROM Customer");
		
		List<Customer> customers = new ArrayList<Customer>();
		
		for(Map row :rows){
			Customer customer = new Customer( (Long) row.get("id"), (String)row.get("name"));
			customers.add(customer);
		}
		
		
		return customers;
	}
	
	
	private static final class CustomerMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Customer(rs.getLong("id"), rs.getString("name"));
		
		}
		
	}


	
	
}
