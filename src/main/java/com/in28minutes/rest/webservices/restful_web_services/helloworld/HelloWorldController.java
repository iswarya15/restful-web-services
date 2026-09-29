package com.in28minutes.rest.webservices.restful_web_services.helloworld;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World " + name);
    }
}
