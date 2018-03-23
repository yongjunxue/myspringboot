package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAction {
	@RequestMapping("/")
    public String hello(){
        return "Greetings from Spring Boot!";
    }
}
