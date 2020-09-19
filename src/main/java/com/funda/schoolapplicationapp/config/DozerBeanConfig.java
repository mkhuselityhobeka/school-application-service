package com.funda.schoolapplicationapp.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerBeanConfig {
	
	@Bean
	public DozerBeanMapper beanMapper() {
		DozerBeanMapper beanMapper = new DozerBeanMapper();
		return beanMapper;
	}
}
