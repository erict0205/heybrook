package com.tutorial.demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Integer getUserId() {
        System.out.println("進入了UserService的getUserId方法");
        int userId = 5;
        return userId;
    }
}
