package com.xiaofei.li.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author: xiaofei
 * Date: 2022-04-20, 20:38
 * Description:
 */
@FeignClient ("user-provider")
@Service
@LoadBalancerClient (name = "user-provider")
public interface UserService {
    @GetMapping("/users/{id}")
    String getUserById(@PathVariable Integer id);
}
