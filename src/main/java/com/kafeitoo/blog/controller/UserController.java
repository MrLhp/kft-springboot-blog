package com.kafeitoo.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/w/user")
public class UserController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser() {

        return "";
    }
}