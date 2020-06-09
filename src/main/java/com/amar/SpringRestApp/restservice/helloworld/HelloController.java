package com.amar.SpringRestApp.restservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amar.SpringRestApp.bean.helloworld.HelloWorldBeanJ;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "hello world";
	}

	@GetMapping(path="/hello-world-bean")
	public HelloWorldBeanJ helloWorldBean() {
		return new HelloWorldBeanJ("hello world bean");
		//throw new RuntimeException("Runtime Exception happened");
		}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBeanJ helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBeanJ("hello world , "+name);
	}
}
