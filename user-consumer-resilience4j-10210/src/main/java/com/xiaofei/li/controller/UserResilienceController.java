package com.xiaofei.li.controller;

import com.xiaofei.li.service.UserService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xiaofei
 * Date: 2022-04-20, 23:52
 * Description:
 */
@RestController
@RequestMapping("/users")
public class UserResilienceController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")

    public String getUserById(@PathVariable Integer id){
        return "consumer remotely invoke the method: "+userService.getUserById(id);
    }

    @GetMapping("/semaphore/{id}")
    @Bulkhead(name = "semaphoreService",type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "fallback")
    public String semaphoreMethod(@PathVariable Integer id){

        return "consumer remotely invoke the method: "+userService.semaphoreMethod(id);
    }

    @GetMapping("/thread/{id}")
    @Bulkhead(name = "threadService",type = Bulkhead.Type.THREADPOOL)
    public String threadMethod(@PathVariable Integer id){

        return "consumer remotely invoke the method: "+userService.threadMethod(id);
    }
    @GetMapping("/circuit/{id}")
    @CircuitBreaker(name = "x")
    public String circuitMethod(@PathVariable Integer id){
        return "consumer remotely invoke the method: "+userService.circuitMethod(id);
    }

    public String fallback(int id, Throwable throwable){
        return id+":"+throwable.getMessage();
    }
}
