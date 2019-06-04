package com.example.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String Hello()
    {
        return "Hello World!";
    }
}
