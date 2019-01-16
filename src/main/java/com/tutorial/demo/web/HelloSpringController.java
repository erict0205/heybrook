package com.tutorial.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    //透過 @RequestMapping 指定從/會被對應到此hello()方法
    @RequestMapping("/")
    public String hello() {
        return "heyBrook";
    }
}