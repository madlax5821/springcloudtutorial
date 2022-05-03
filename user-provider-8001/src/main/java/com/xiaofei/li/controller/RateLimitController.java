package com.xiaofei.li.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xiaofei
 * Date: 2022-05-02, 17:39
 * Description:
 */
@RestController
@RequestMapping("/rate")
public class RateLimitController {
    @GetMapping("/test1")
    public String test1(){
        return "to many clicks, please visit back later";

    }
}
