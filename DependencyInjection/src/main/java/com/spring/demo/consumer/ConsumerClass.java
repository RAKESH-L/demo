package com.spring.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.demo.service.MessageService;

@Component
public class ConsumerClass {
	private MessageService service;
	
	@Autowired
	public void setService(MessageService svc) {
		this.service = svc;
	}
	
	public boolean processMessage(String msg, String rec) {
		return this.service.sendMessage(msg, rec);
	}
}
