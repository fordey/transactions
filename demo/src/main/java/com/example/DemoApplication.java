package com.example;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class DemoApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	PlatformTransactionManager txmanager;
	
    public static void main(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        
        logger.info("------------------------------------------------");
        logger.info("Spring Beans created by Spring Boot : ");
        logger.info("------------------------------------------------");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        
        for(String beanName : beanNames){
     	   logger.info(beanName);
        }
        
        
    }
}
