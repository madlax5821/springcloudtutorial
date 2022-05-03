package com.xiaofei.li.controller;

import com.xiaofei.li.entity.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xiaofei
 * Date: 2022-04-29, 17:49
 * Description:
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConsulConfigController {
    @Value("${myName}")
    private String myName;
    @Autowired
    private StudentConfig studentConfig;

    @GetMapping("/myname")
    public String hello(){
        System.out.println("my name is "+myName);
        return myName;
    }

    @GetMapping("/test")
    public String testConfig(){
        System.out.println(studentConfig.toString());
        return studentConfig.toString();
    }
}
