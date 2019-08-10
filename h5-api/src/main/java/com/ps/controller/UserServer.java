package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserServer {
    @Autowired
    private RestTemplate template;
    @RequestMapping("/user")
    public String uerserver(String name ){

        return template.getForObject("http://holle-service/index?name="+name,String.class);

    }
}
