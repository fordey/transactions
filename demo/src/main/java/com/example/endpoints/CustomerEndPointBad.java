package com.example.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.CustomerHits;
import com.example.facade.api.CustomerFacade;

@RestController
@RequestMapping("/multitx")
public class CustomerEndPointBad {
	@Autowired
	@Qualifier("BadFacade")
	private CustomerFacade facade;
	
	@RequestMapping(method=RequestMethod.GET, value="/hits/add/{id}")
	public List<CustomerHits> addHit(@PathVariable Long id){
		return facade.addHits(id);
		
	}
	
}
