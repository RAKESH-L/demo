package com.spring.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.demo.service.EmailService;
import com.spring.demo.service.MessageService;

@Configuration
@ComponentScan(value = ("com.spring.demo.consumer"))
public class DIConfiguration {
	
	@Bean
	public MessageService getMessageService() {
		return new EmailService();
		
	}
	

}
