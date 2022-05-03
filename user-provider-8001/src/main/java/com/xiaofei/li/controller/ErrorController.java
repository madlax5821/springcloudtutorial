package com.xiaofei.li.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xiaofei
 * Date: 2022-05-02, 16:51
 * Description:
 */
@RestController
@RequestMapping ("/error")
public class ErrorController {
    @GetMapping("/fallbackCircuitBreaker")
    public String fallbackError(Exception e){
        return "time out: "+e.getMessage();
    }
}
