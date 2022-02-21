package com.colegioquipux.backend.controllers.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegioquipux.backend.services.hello.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	@GetMapping
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.status(HttpStatus.OK).body(helloService.sayHelloWorld());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<String> sayHelloPerson(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.OK).body(helloService.sayHelloPerson(name));
	}
}
