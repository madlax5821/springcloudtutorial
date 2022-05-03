package com.xiaofei.li.userconsumerfeign10110;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
@EnableFeignClients (basePackages = "com.xiaofei.li.service")
public class UserConsumerFeign10110Application {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerFeign10110Application.class, args);
    }

}
