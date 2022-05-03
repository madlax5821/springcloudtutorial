package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: xiaofei
 * Date: 2022-04-26, 19:15
 * Description:
 */
@RestController
@RequestMapping("/users")
public class ConsulProviderController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id){
        return "xiaofeifei "+id;
    }

}
