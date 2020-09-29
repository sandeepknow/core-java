package com.defy.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SingletonService {

//	@Autowired
//	PrototypeService prototypeService;
	
	@Autowired
	ApplicationContext context;

	public String getMethod() {
		return context.getBean(PrototypeService.class).getMethod();
//		return prototypeService.getMethod();
	}
	
}
