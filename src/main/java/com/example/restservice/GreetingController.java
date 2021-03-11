package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/*
    GreetingController is a resource controller!
    In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.

    A key difference between a traditional MVC controller and the RESTful web service controller shown
    earlier is the way that the HTTP response body is created. Rather than relying on a view technology
    to perform server-side rendering of the greeting data to HTML, this RESTful web service controller
    populates and returns a Greeting object. The object data will be written directly to the HTTP response as JSON.
*/

//This code uses Spring @RestController annotation, which marks the class as a controller where every method returns a domain object instead of a view. It is shorthand for including both @Controller and @ResponseBody.
@RestController
public class GreetingController {
    private static final String template = "Greetings, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting") //This annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method

    //@RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        //The implementation of the method body creates and returns a new Greeting object with id and content attributes

        long id = counter.incrementAndGet();
        String content = String.format(template, name);

        Greeting greet = new Greeting(id, content);
        System.out.println(greet);

        return greet;
    }
}
