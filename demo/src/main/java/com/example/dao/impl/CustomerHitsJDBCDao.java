package com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.dao.api.CustomerHitsDao;
import com.example.domain.Customer;
import com.example.domain.CustomerHits;
import com.example.domain.CustomerHits.Channel;


@Repository
public class CustomerHitsJDBCDao implements CustomerHitsDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParamTemplate;
	
	
	
	@Override
	public CustomerHits readHitsForCustomer(Customer customer, Channel channel) {
		
		SqlParameterSource paramMap = new MapSqlParameterSource()
			.addValue("customer_id", customer.getId())
			.addValue("channel", channel.toString());
		
		
		 return namedParamTemplate.queryForObject(
	                "SELECT id, customer_id, hits, channel FROM Customer_Hits where customer_id = :customer_id AND channel=:channel",
	                paramMap,
	                new CustomerHitsMapper());
	}

	@Override
	public List<CustomerHits> readHits(long customerId) {
		SqlParameterSource paramMap = new MapSqlParameterSource()
        .addValue("customerId", customerId);

		return namedParamTemplate.query(
        "SELECT id, customer_id, hits, channel FROM customer_hits where customer_id = :customerId",
        paramMap,
        new CustomerHitsMapper());
	}

	@Override
	public void incrementHit(Customer customer, long numberHits, Channel channel){
		
		 SqlParameterSource paramSource =
	                new MapSqlParameterSource()
	        .addValue("customerId", customer.getId())
	        .addValue("numberHits", numberHits)
	        .addValue("channel", channel.toString());

		 	namedParamTemplate.update(
	                "UPDATE customer_hits SET hits = hits+ :numberHits WHERE customer_id=:customerId AND channel=:channel",
	                paramSource);
		
	}
	
	
	private static final class CustomerHitsMapper implements RowMapper<CustomerHits> {

        @Override
        public CustomerHits mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerHits customerHits = new CustomerHits();
            customerHits.setId(rs.getLong("id"));
            customerHits.setCustomerId(rs.getLong("customer_id"));
            customerHits.setHits(rs.getLong("hits"));
            customerHits.setChannel(Channel.valueOf(rs.getString("channel")));
            return customerHits;
        }
	}
	
}
