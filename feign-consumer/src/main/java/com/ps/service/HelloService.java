package com.ps.service;

import com.ps.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-server")
public interface HelloService {
    @RequestMapping("/index")
    String hello();

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(@RequestParam String name);

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestHeader String name,@RequestHeader int age);

    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    String hello(@RequestBody User user);





}
