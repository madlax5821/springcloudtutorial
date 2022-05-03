package com.xiaofei.li.userconsumerresilience4j10210;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication (scanBasePackages = {"com.xiaofei.li.service","com.xiaofei.li.controller"})
@EnableFeignClients (basePackages = "com.xiaofei.li.service")
@EnableEurekaClient
public class UserConsumerResilience4j10210Application {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerResilience4j10210Application.class, args);
    }

}
