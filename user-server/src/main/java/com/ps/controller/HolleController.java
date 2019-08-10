package com.ps.controller;

import com.ps.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HolleController {
    @Autowired
    private DiscoveryClient discoveryClient;



    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        List<ServiceInstance> list = discoveryClient.getInstances("user-Service");
        if(list!=null && list.size()>0){
            return list.get(0).getUri().toString();
        }
        return "null what ";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String holle(@RequestParam String name){
        return "hello:"+name;
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public User hello1(@RequestHeader String name, @RequestHeader Integer age){

        return new User(age,name);
    }
    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String hello2(@RequestBody User user){
        return " hello :"+ user.getName()+" ,"+"age :"+user.getAge();
    }

}
