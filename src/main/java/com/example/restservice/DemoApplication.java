package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //Convenience annotation that adds all the things
@RestController // This annotation tells Spring that this code describes an endpoint that should be made available over the web
public class DemoApplication {

	public static void main(String[] args) {
		/*
			The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
			Did you notice that there was not a single line of XML? There is no web.xml file, either.
			This web application is 100% pure Java and you did not have to deal with configuring any plumbing or infrastructure.
		*/
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello") //This annotation tells Spring to use our hello() method to answer requests that get send to the endpoint
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		//@RequestParam tells Spring to expect a name value in the request
		return String.format("Hello %s!", name);
	}
}
