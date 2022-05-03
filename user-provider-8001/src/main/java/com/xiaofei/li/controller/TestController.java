package com.xiaofei.li.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xiaofei
 * Date: 2022-05-02, 17:11
 * Description:
 */
@RestController
@RequestMapping
public class TestController {
    @GetMapping("/fallbackCircuitBreaker")
    public String test(){
        return "successfully forward the fallback method here";
    }
}
