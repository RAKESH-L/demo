package com.spring.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.demo.configuration.DIConfiguration;
import com.spring.demo.consumer.ConsumerClass;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		ConsumerClass obj = context.getBean(ConsumerClass.class);
		obj.processMessage("Dependency Injection through setter", "rakesh@abc.com");
	}

}
