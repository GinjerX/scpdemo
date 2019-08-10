package com.ps.controller;

import com.ps.domain.User;
import com.ps.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String index(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer1",method = RequestMethod.POST)
    public String index1(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(helloService.hello()).append("\n");
        stringBuilder.append(helloService.hello("DIDI")).append("\n");
        stringBuilder.append(helloService.hello("DIDI",13)).append("\n");
        stringBuilder.append(helloService.hello(new User(12,"DIDI")));
        return stringBuilder.toString();

    }

}
