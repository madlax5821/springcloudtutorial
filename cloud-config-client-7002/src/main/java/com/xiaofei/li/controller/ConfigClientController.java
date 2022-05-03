package com.xiaofei.li.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xiaofei
 * Date: 2022-04-26, 12:50
 * Description:
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${name}")
    private String username;
    @Value("${password}")
    private String password;

    @GetMapping ("/config/profile")
    public String hello(){
        return this.username+" "+this.password;
    }
}
