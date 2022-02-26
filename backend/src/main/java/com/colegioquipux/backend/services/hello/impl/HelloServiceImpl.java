package com.colegioquipux.backend.services.hello.impl;

import org.springframework.stereotype.Service;

import com.colegioquipux.backend.services.hello.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHelloPerson(String name) {
		return "Hello " + name + "!";
	}

	@Override
	public String sayHelloWorld() {
		return "Hello World!";
	}

}
