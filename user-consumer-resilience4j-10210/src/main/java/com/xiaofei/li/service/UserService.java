package com.xiaofei.li.service;

import com.xiaofei.li.controller.UserResilienceController;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author: xiaofei
 * Date: 2022-04-20, 23:17
 * Description:
 */
@FeignClient (name = "user-provider", fallbackFactory = UserServiceFallbackFactory.class)
@Service
@LoadBalancerClient ("user-provider")
public interface UserService {

    @GetMapping("/users/{id}")
    String getUserById(@PathVariable Integer id);
    @GetMapping("/users/semaphore/{id}")
    String semaphoreMethod(@PathVariable Integer id);
    @GetMapping("/users/thread/{id}")
    String threadMethod(@PathVariable Integer id);
    @GetMapping("/users/circuit/{id}")
    String circuitMethod(@PathVariable Integer id);
}
